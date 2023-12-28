package vn.edu.vnua.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.vnua.toiec.core.mapper.ExamMapper;
import vn.edu.vnua.toiec.core.mapper.UserMapper;
import vn.edu.vnua.toiec.data.entities.Exam;
import vn.edu.vnua.toiec.data.entities.HistoryExam;
import vn.edu.vnua.toiec.data.entities.User;
import vn.edu.vnua.toiec.data.repository.ExamRepository;
import vn.edu.vnua.toiec.data.repository.HistoryExamRepository;
import vn.edu.vnua.toiec.data.repository.UserRepository;
import vn.edu.vnua.toiec.presentation.model.ExamResponse;
import vn.edu.vnua.toiec.presentation.model.HistoryExamRequest;
import vn.edu.vnua.toiec.presentation.model.HistoryExamResponse;
import vn.edu.vnua.toiec.presentation.model.UserDTO;
import vn.edu.vnua.toiec.usecases.HistoryExamService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryExamImpl implements HistoryExamService {

    @Autowired
    private HistoryExamRepository historyExamRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public HistoryExam createHistory(HistoryExamRequest historyExamRequest) throws Exception {

        int count = 0;
        Integer maxTimeOfExam = historyExamRepository.maxTimeOfExam(historyExamRequest.getUserId());
        if (maxTimeOfExam != null && maxTimeOfExam != 0) {
            count = maxTimeOfExam + 1;
        } else {
            count = 1;
        }

        HistoryExam historyExam = new HistoryExam();
        historyExam.setTimeOfExam(count);
        historyExam.setListeningScore(historyExamRequest.getListeningScore());
        historyExam.setReadingScore(historyExamRequest.getReadingScore());
        historyExam.setCreateAt(new Date());

        ExamResponse examResponse = examRepository.findExamById(historyExamRequest.getExamId());
        ExamMapper examMapper = new ExamMapper();
        Exam exam = examMapper.convertToEntity(examResponse);
        if (exam != null) {
            historyExam.setExam(exam);
        } else {
            throw new Exception("Exam is not exist!");
        }

        UserDTO userDto = userRepository.getUserById(historyExamRequest.getUserId());
        UserMapper userMapper = new UserMapper();
        User user = userMapper.convertToEntity(userDto);
        if (user != null) {
            historyExam.setUser(user);
        } else {
            throw new Exception("User is not exist");
        }

        historyExamRepository.save(historyExam);
        return historyExam;
    }

    @Override
    public Page<HistoryExamResponse> getHistoryByUserId(Integer userId, Pageable pageable) {
        Page<HistoryExamResponse> responses = historyExamRepository.getHistoryExamByUserId(userId, pageable);
        return responses;
    }
}
