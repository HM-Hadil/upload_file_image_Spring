package coding.spring.upload_file_image_spring.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
public class UserDTO {
    private Long id;
    private String username;
    private double age;
    private byte[] imageBase64;
}
