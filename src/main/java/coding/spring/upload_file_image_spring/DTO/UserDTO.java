package coding.spring.upload_file_image_spring.DTO;

import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@SuperBuilder
@Jacksonized
public class UserDTO {
    private Long id;
    private String username;
    private Integer age;
    private byte[] imageBase64;
}
