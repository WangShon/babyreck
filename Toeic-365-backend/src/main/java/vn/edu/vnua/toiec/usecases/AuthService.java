package vn.edu.vnua.toiec.usecases;

import vn.edu.vnua.toiec.data.entities.User;
import vn.edu.vnua.toiec.presentation.model.LoginRequest;
import vn.edu.vnua.toiec.presentation.model.RegisterRequest;

import java.util.HashMap;

public interface AuthService {
    User register(RegisterRequest registerRequest);

    HashMap<String, Object> login(LoginRequest loginRequest);


}
