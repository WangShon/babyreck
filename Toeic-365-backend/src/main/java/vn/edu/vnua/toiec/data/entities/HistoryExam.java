package vn.edu.vnua.toiec.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.vnua.toiec.presentation.model.ExamResponse;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "history_exam")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoryExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer timeOfExam;
    private BigDecimal listeningScore;
    private BigDecimal readingScore;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
}
