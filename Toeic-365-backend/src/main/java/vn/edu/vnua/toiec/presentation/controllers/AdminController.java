package vn.edu.vnua.toiec.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnua.toiec.presentation.model.CalcAdminResponse;
import vn.edu.vnua.toiec.presentation.model.CalcExamResponse;
import vn.edu.vnua.toiec.presentation.model.CalcUserResponse;
import vn.edu.vnua.toiec.usecases.AdminService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/hello")
    public String hello(){
        return "I AM ADMIN";
    }

    @GetMapping("/avg-point-of-month/{year}")
    public ResponseEntity<List<CalcAdminResponse>> getAvgPointOfMonth(@PathVariable Integer year) {
        return new ResponseEntity<>(adminService.getAvgPointOfMonth(year), HttpStatus.OK);
    }

    @GetMapping("/user-of-month")
    public ResponseEntity<CalcUserResponse> getUserOfMonth() {
        return new ResponseEntity<>(adminService.getUserOfMonth(), HttpStatus.OK);
    }

    @GetMapping("/exam-of-month")
    public ResponseEntity<CalcExamResponse> getExamOfMonth() {
        return new ResponseEntity<>(adminService.getExamOfMonth(), HttpStatus.OK);
    }
}
