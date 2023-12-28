package vn.edu.vnua.toiec.presentation.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CalcExamResponse {
    private Long examId;
    private String examName;
    private Long count;

    public CalcExamResponse(Long examId, String examName, Long count) {
        this.examId = examId;
        this.examName = examName;
        this.count = count;
    }
}
