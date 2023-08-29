package vn.edu.vnua.toiec.usecases;

import vn.edu.vnua.toiec.data.entities.Question;
import vn.edu.vnua.toiec.presentation.model.QuestionRequest;
import vn.edu.vnua.toiec.presentation.model.QuestionResponse;

import java.util.List;

public interface QuestionService {

    Question createQuestion(QuestionRequest questionRequest);

    List<QuestionResponse> getAllQuestions();

    Question update(QuestionResponse questionResponse);

    Question delete(QuestionResponse questionResponse);

}
