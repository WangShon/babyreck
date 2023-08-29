package vn.edu.vnua.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.toiec.data.entities.HistoryExam;

import java.util.List;

@Repository
public interface HistoryExamRepository extends JpaRepository<HistoryExam, Long> {

    @Query("select new vn.edu.vnua.toiec.presentation.model.HistoryExamResponse(he.timeOfExam, he.listeningScore, he.readingScore, e.examName) from HistoryExam he inner join Exam e on e.id = he.exam.id where he.user.id = :userId ORDER BY he.timeOfExam ASC")
    List<HistoryExam> getHistoryExamByUserId(@Param("userId") Integer userId);

    @Query("select max(he.timeOfExam) from HistoryExam he where he.user.id = :userId")
    Integer maxTimeOfExam(@Param("userId") Integer userId);
}
