package vn.edu.vnua.toiec.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnua.toiec.data.entities.HistoryExam;
import vn.edu.vnua.toiec.presentation.model.HistoryExamRequest;
import vn.edu.vnua.toiec.presentation.model.HistoryExamResponse;
import vn.edu.vnua.toiec.usecases.HistoryExamService;

import java.util.List;

@RestController
@RequestMapping("/api/history-exam")
public class HistoryExamController {

    @Autowired
    private HistoryExamService historyExamService;

    @PostMapping("/create-history-exam")
    public ResponseEntity<HistoryExam> createHistoryExam(@RequestBody HistoryExamRequest historyExamRequest) throws Exception {
        return new ResponseEntity<>(historyExamService.createHistory(historyExamRequest), HttpStatus.CREATED);
    }

    @GetMapping("/list-history-exam")
    public ResponseEntity<Page<HistoryExamResponse>> getListHistoryExam(@RequestParam Integer id,
                                                                        @RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return new ResponseEntity<>(historyExamService.getHistoryByUserId(id, pageRequest), HttpStatus.OK);
    }
}
