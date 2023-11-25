package vn.edu.vnua.toiec.usecases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.edu.vnua.toiec.data.entities.HistoryExam;
import vn.edu.vnua.toiec.presentation.model.GroupQuestionRequest;
import vn.edu.vnua.toiec.presentation.model.HistoryExamRequest;
import vn.edu.vnua.toiec.presentation.model.HistoryExamResponse;

import java.util.List;

public interface HistoryExamService {
    HistoryExam createHistory(HistoryExamRequest historyExamRequest) throws Exception;

    Page<HistoryExamResponse> getHistoryByUserId(Integer userId, Pageable pageable);
}
