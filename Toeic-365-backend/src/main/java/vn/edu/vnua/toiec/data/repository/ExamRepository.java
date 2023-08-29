package vn.edu.vnua.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.toiec.data.entities.Exam;
import vn.edu.vnua.toiec.data.entities.Part;
import vn.edu.vnua.toiec.presentation.model.ExamResponse;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    Exam findByPartsContains(Part part);

    @Query("select new vn.edu.vnua.toiec.presentation.model.ExamResponse(e.id, e.examName, e.totalTime) from Exam e where e.id = :id")
    ExamResponse findExamById(@Param("id") Long id);
}
