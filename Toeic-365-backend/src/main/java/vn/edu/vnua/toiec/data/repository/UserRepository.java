package vn.edu.vnua.toiec.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.toiec.data.entities.Authority;
import vn.edu.vnua.toiec.data.entities.User;
import vn.edu.vnua.toiec.presentation.model.UserDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    List<User> findAllByRolesContains(Authority authority);

    User findByEmail(User user);

    @Query("select new vn.edu.vnua.toiec.presentation.model.UserDTO(u.id, u.fullName) from User u where u.id = :id")
    UserDTO getUserById(@Param("id") Integer id);
}
