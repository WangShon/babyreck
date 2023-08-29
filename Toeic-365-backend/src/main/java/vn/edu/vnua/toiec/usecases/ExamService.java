package vn.edu.vnua.toiec.usecases;

import vn.edu.vnua.toiec.data.entities.Exam;
import vn.edu.vnua.toiec.presentation.model.ExamDTO;
import vn.edu.vnua.toiec.presentation.model.ExamRequest;
import vn.edu.vnua.toiec.presentation.model.ExamResponse;

import java.util.List;

public interface ExamService {
    Exam create(ExamRequest examRequest);

    ExamDTO getExamById(Long id);

    List<Exam> getAllExams();

    List<ExamResponse> getAllExam();

    ExamResponse getIntroExamById(Long id);

    Exam update(ExamRequest examRequest);

    Exam delete(Exam exam);

}
