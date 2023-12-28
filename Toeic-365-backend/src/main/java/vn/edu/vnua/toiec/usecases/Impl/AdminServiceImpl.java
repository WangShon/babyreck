package vn.edu.vnua.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.vnua.toiec.data.entities.Exam;
import vn.edu.vnua.toiec.data.entities.HistoryExam;
import vn.edu.vnua.toiec.data.entities.User;
import vn.edu.vnua.toiec.data.repository.HistoryExamRepository;
import vn.edu.vnua.toiec.presentation.model.CalcAdminResponse;
import vn.edu.vnua.toiec.presentation.model.CalcExamResponse;
import vn.edu.vnua.toiec.presentation.model.CalcUserResponse;
import vn.edu.vnua.toiec.usecases.AdminService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private HistoryExamRepository historyExamRepository;

    @Override
    public List<CalcAdminResponse> getAvgPointOfMonth(Integer year) {
        return historyExamRepository.getAvgPointOfMonth(year).stream()
                .map(e -> new CalcAdminResponse(e.getAvgListeningScore(), e.getAvgReadingScore(), e.getMonth())).collect(Collectors.toList());
    }

    @Override
    public CalcUserResponse getUserOfMonth() {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        CalcUserResponse userResponse = historyExamRepository.getUserExecute(year, month).get(0);

        return new CalcUserResponse(userResponse.getUserId(), userResponse.getFullName(), userResponse.getCount());
    }

    @Override
    public CalcExamResponse getExamOfMonth() {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        CalcExamResponse examResponse = historyExamRepository.getExamExecute(year, month).get(0);

        return new CalcExamResponse(examResponse.getExamId(), examResponse.getExamName(), examResponse.getCount());
    }
}
