package coding.spring.upload_file_image_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class UploadFileImageSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadFileImageSpringApplication.class, args);
    }

}
