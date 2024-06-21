package coding.spring.upload_file_image_spring.repository;

import coding.spring.upload_file_image_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface UserRepo extends JpaRepository<User,Long> {

}
