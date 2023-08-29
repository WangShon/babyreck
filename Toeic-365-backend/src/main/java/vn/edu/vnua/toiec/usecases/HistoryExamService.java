package vn.edu.vnua.toiec.usecases;

import vn.edu.vnua.toiec.data.entities.HistoryExam;
import vn.edu.vnua.toiec.presentation.model.GroupQuestionRequest;
import vn.edu.vnua.toiec.presentation.model.HistoryExamRequest;

import java.util.List;

public interface HistoryExamService {
    HistoryExam createHistory(HistoryExamRequest historyExamRequest);

    List<HistoryExam> getHistoryByUserId(Integer userId);
}
