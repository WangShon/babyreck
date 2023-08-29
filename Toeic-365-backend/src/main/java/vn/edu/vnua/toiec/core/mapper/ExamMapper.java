package vn.edu.vnua.toiec.core.mapper;

import org.modelmapper.ModelMapper;
import vn.edu.vnua.toiec.data.entities.Exam;
import vn.edu.vnua.toiec.presentation.model.ExamResponse;

public class ExamMapper {

    ModelMapper modelMapper = new ModelMapper();
    public ExamResponse convertToDto(Exam exam) {
        ExamResponse examResponse = modelMapper.map(exam, ExamResponse.class);
        return  examResponse;
    }

    public Exam convertToEntity(ExamResponse examResponse) {
        Exam exam = modelMapper.map(examResponse, Exam.class);
        return  exam;
    }
}
