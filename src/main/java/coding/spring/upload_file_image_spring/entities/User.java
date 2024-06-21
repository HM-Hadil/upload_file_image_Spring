package coding.spring.upload_file_image_spring.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameImage;
    private String typeImage;
    private String username;
    private String age;
    @Lob
    @Column(name = "picture",length = 1000000)
    private byte[] imageData;
}
