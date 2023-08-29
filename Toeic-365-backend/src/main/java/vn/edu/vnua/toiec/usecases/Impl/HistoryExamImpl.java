package vn.edu.vnua.toiec.usecases.Impl;

import org.springframework.beans.factory.annotation.Autowired;
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
import vn.edu.vnua.toiec.presentation.model.UserDTO;
import vn.edu.vnua.toiec.usecases.HistoryExamService;

import java.util.List;

@Service
public class HistoryExamImpl implements HistoryExamService {

    @Autowired
    private HistoryExamRepository historyExamRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public HistoryExam createHistory(HistoryExamRequest historyExamRequest) {

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

        ExamResponse examResponse = examRepository.findExamById(historyExamRequest.getExamId());
        ExamMapper examMapper = new ExamMapper();
        Exam exam = examMapper.convertToEntity(examResponse);
        if (exam!=null) {
            historyExam.setExam(exam);
        } else {
            throw  new NullPointerException("Exam is not exist!");
        }

        UserDTO userDto = userRepository.getUserById(historyExamRequest.getUserId());
        UserMapper userMapper = new UserMapper();
        User user = userMapper.convertToEntity(userDto);
        if (user!=null) {
            historyExam.setUser(user);
        } else {
            throw  new NullPointerException("User is not exist");
        }

        historyExamRepository.save(historyExam);
        return historyExam;
    }

    @Override
    public List<HistoryExam> getHistoryByUserId(Integer userId) {
        List<HistoryExam> histories = historyExamRepository.getHistoryExamByUserId(userId);
        return histories;
    }
}
