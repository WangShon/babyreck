package vn.edu.vnua.toiec.usecases;

import vn.edu.vnua.toiec.core.security.UserPrinciple;
import vn.edu.vnua.toiec.data.entities.User;

import java.util.List;

public interface UserService {

    List<UserPrinciple> getAllUser();

    void delete(User user);

    UserPrinciple getCurrentUser();

    User update(User user);
}
