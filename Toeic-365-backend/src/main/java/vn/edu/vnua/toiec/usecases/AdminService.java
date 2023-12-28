package vn.edu.vnua.toiec.usecases;

import vn.edu.vnua.toiec.presentation.model.CalcAdminResponse;
import vn.edu.vnua.toiec.presentation.model.CalcExamResponse;
import vn.edu.vnua.toiec.presentation.model.CalcUserResponse;

import java.util.List;
import java.util.Map;

public interface AdminService {

    List<CalcAdminResponse> getAvgPointOfMonth(Integer year);

    CalcUserResponse getUserOfMonth();

    CalcExamResponse getExamOfMonth();
}
