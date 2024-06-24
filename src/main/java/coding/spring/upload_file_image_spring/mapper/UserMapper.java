package coding.spring.upload_file_image_spring.mapper;

import coding.spring.upload_file_image_spring.DTO.UserDTO;
import coding.spring.upload_file_image_spring.entities.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper {
    // convert entity user to user dto
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .age(user.getAge())
                .imageBase64(user.getImageData() )
                .build();

    }

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setAge(userDTO.getAge());
        user.setImageData(userDTO.getImageBase64() );
        return user;
    }
}
