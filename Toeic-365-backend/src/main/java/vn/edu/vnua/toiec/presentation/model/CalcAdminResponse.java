package vn.edu.vnua.toiec.presentation.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CalcAdminResponse {
    private Double avgListeningScore;
    private Double avgReadingScore;
    private Integer month;

    public CalcAdminResponse(Double avgListeningScore, Double avgReadingScore, Integer month) {
        this.avgListeningScore = avgListeningScore;
        this.avgReadingScore = avgReadingScore;
        this.month = month;
    }
}
