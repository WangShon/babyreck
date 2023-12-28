package vn.edu.vnua.toiec.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.toiec.data.entities.Exam;
import vn.edu.vnua.toiec.data.entities.HistoryExam;
import vn.edu.vnua.toiec.data.entities.User;
import vn.edu.vnua.toiec.presentation.model.CalcAdminResponse;
import vn.edu.vnua.toiec.presentation.model.CalcExamResponse;
import vn.edu.vnua.toiec.presentation.model.CalcUserResponse;
import vn.edu.vnua.toiec.presentation.model.HistoryExamResponse;

import java.util.List;

@Repository
public interface HistoryExamRepository extends JpaRepository<HistoryExam, Long> {

    @Query("select new vn.edu.vnua.toiec.presentation.model.HistoryExamResponse(he.id, he.timeOfExam, he.listeningScore, he.readingScore, e.examName) from HistoryExam he inner join Exam e on e.id = he.exam.id where he.user.id = :userId ORDER BY he.timeOfExam ASC")
    Page<HistoryExamResponse> getHistoryExamByUserId(@Param("userId") Integer userId, Pageable pageable);

    @Query("select max(he.timeOfExam) from HistoryExam he where he.user.id = :userId")
    Integer maxTimeOfExam(@Param("userId") Integer userId);

    @Query("SELECT NEW vn.edu.vnua.toiec.presentation.model.CalcAdminResponse(" +
            "AVG(he.listeningScore), AVG(he.readingScore), MONTH(he.createAt)) " +
            "FROM HistoryExam he " +
            "WHERE YEAR(he.createAt) = :targetYear " +
            "GROUP BY MONTH(he.createAt) " +
            "ORDER BY MONTH(he.createAt)")
    List<CalcAdminResponse> getAvgPointOfMonth(@Param("targetYear") Integer targetYear);

    @Query("SELECT NEW vn.edu.vnua.toiec.presentation.model.CalcUserResponse(he.user.id, u.fullName, COUNT(he.user.id)) " +
            "FROM HistoryExam he " +
            "JOIN User u ON u.id = he.user.id " +
            "WHERE FUNCTION('YEAR', he.createAt) = :targetYear AND FUNCTION('MONTH', he.createAt) = :targetMonth " +
            "GROUP BY he.user.id " +
            "ORDER BY COUNT(he.user.id) DESC")
    List<CalcUserResponse> getUserExecute(@Param("targetYear") Integer targetYear, @Param("targetMonth") Integer targetMonth);

    @Query("SELECT NEW vn.edu.vnua.toiec.presentation.model.CalcExamResponse(he.exam.id, e.examName, COUNT(he.exam.id)) " +
            "FROM HistoryExam he " +
            "JOIN Exam e ON e.id = he.exam.id " +
            "WHERE FUNCTION('YEAR', he.createAt) = :targetYear AND FUNCTION('MONTH', he.createAt) = :targetMonth " +
            "GROUP BY he.exam.id " +
            "ORDER BY COUNT(he.exam.id) DESC")
    List<CalcExamResponse> getExamExecute(@Param("targetYear") Integer targetYear, @Param("targetMonth") Integer targetMonth);
}
