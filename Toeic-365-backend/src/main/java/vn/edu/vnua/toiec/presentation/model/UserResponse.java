package vn.edu.vnua.toiec.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.vnua.toiec.core.security.UserPrinciple;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private UserPrinciple userInfo;
    private String token;
}
