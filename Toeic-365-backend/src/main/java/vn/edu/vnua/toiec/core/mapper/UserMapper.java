package vn.edu.vnua.toiec.core.mapper;

import org.modelmapper.ModelMapper;
import vn.edu.vnua.toiec.data.entities.Exam;
import vn.edu.vnua.toiec.data.entities.User;
import vn.edu.vnua.toiec.presentation.model.ExamResponse;
import vn.edu.vnua.toiec.presentation.model.UserDTO;

public class UserMapper {
    ModelMapper modelMapper = new ModelMapper();
    public UserDTO convertToDto(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return  userDTO;
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return  user;
    }
}
