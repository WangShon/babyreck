package vn.edu.vnua.toiec.usecases;

import vn.edu.vnua.toiec.data.entities.GroupQuestion;
import vn.edu.vnua.toiec.presentation.model.GroupQuestionRequest;
import vn.edu.vnua.toiec.presentation.model.GroupQuestionResponse;

import java.util.List;

public interface GroupQuestionService {
    GroupQuestion createGroupQuestion(GroupQuestionRequest groupQuestionRequest);

    List<GroupQuestionResponse> getAllGroupQuestions();

    List<GroupQuestionResponse> getAllTitle(String numberPart);

    GroupQuestion update(GroupQuestionResponse groupQuestionResponse);

    GroupQuestion delete(GroupQuestionResponse groupQuestionResponse);

}
