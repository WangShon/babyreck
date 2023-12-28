package vn.edu.vnua.toiec.presentation.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CalcUserResponse {
    private Integer userId;
    private String fullName;
    private Long count;

    public CalcUserResponse(Integer userId, String fullName, Long count) {
        this.userId = userId;
        this.fullName = fullName;
        this.count = count;
    }
}
