package vn.edu.vnua.toiec.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnua.toiec.data.entities.HistoryExam;
import vn.edu.vnua.toiec.presentation.model.ExamRequest;
import vn.edu.vnua.toiec.presentation.model.HistoryExamRequest;
import vn.edu.vnua.toiec.usecases.HistoryExamService;

import java.util.List;

@RestController
@RequestMapping("/api/history-exam")
public class HistoryExamController {

    @Autowired
    private HistoryExamService historyExamService;

    @PostMapping("/create-history-exam")
    public ResponseEntity<HistoryExam> createHistoryExam(@RequestBody HistoryExamRequest historyExamRequest) {
        return new ResponseEntity<>(historyExamService.createHistory(historyExamRequest), HttpStatus.CREATED);
    }

    @GetMapping("/list-history-exam")
    public ResponseEntity<List<HistoryExam>> getListHistoryExam(@RequestParam Integer userId) {
        return new ResponseEntity<>(historyExamService.getHistoryByUserId(userId), HttpStatus.CREATED);
    }
}
