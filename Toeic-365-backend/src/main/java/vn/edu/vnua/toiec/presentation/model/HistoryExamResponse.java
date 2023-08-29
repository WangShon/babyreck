package vn.edu.vnua.toiec.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryExamResponse {
    private Integer timeOfExam;
    private BigDecimal listeningScore;
    private BigDecimal readingScore;
    private String examName;
}
