package coding.spring.upload_file_image_spring.mapper;

import coding.spring.upload_file_image_spring.DTO.UserDTO;
import coding.spring.upload_file_image_spring.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    // convert entity user to user dto
    public UserDTO toDto(User user){
        if (user ==null){
            return null;
        }
       return  UserDTO.builder()
                .username(user.getUsername())
                .age(user.getAge())
                .imageBase64(user.getImageData())

                .build();
    }
}
