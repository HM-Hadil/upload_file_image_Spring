package coding.spring.upload_file_image_spring.repository;

import coding.spring.upload_file_image_spring.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.util.Optional;


public interface FileRepo extends JpaRepository<File,Long> {
    Optional<File> findByName(String name);

}
