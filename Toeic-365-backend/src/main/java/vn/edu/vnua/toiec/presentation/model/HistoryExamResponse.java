package vn.edu.vnua.toiec.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.vnua.toiec.data.entities.HistoryExam;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryExamResponse {
    private Long id;
    private Integer timeOfExam;
    private BigDecimal listeningScore;
    private BigDecimal readingScore;
    private String examName;

    public HistoryExamResponse(HistoryExam historyExam) {
        this.id = historyExam.getId();
        this.timeOfExam = historyExam.getTimeOfExam();
        this.listeningScore = historyExam.getListeningScore();
        this.readingScore = historyExam.getReadingScore();
        this.examName = historyExam.getExam().getExamName();

    }
}
