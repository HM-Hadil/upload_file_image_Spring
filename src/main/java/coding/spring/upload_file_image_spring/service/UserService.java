package coding.spring.upload_file_image_spring.service;

import coding.spring.upload_file_image_spring.DTO.UserDTO;
import coding.spring.upload_file_image_spring.entities.User;
import coding.spring.upload_file_image_spring.mapper.UserMapper;
import coding.spring.upload_file_image_spring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;

    public User saveUserWithFile(User user, MultipartFile file) throws IOException {
      User users = User.builder()
              .username(user.getUsername())
              .imageData(file.getBytes())
              .typeImage(file.getContentType())
              .nameImage(file.getOriginalFilename())
              .age(user.getAge())
              .build();
        userRepo.save(users);
        users.setImageData(null); // Clear image data before returning
        return users;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public UserDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (!optionalUser.isPresent()) {
            return null;
        }
        return userMapper.toDto(optionalUser.get());
    }
    public User updateUser(Long id, User userDetails, MultipartFile file) throws IOException {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setAge(userDetails.getAge());
            if (file != null && !file.isEmpty()) {
                user.setImageData(file.getBytes());
                user.setTypeImage(file.getContentType());
                user.setNameImage(file.getOriginalFilename());
            }
            return userRepo.save(user);
        } else {
            throw new RuntimeException("User not found with ID " + id);
        }
    }

    public void deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("User not found with ID " + id);
        }
    }
}
