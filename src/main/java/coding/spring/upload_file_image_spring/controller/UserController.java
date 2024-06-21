package coding.spring.upload_file_image_spring.controller;

import coding.spring.upload_file_image_spring.entities.User;
import coding.spring.upload_file_image_spring.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/uploadFile", consumes = "multipart/form-data")
    public ResponseEntity<User> saveUserWithFile(@RequestPart("user") User user, @RequestPart("file") MultipartFile file) throws IOException {
        log.info("Handling request parts: user={}, file={}", user, file.getOriginalFilename());
        User savedUser = userService.saveUserWithFile(user, file);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/updateUser/{id}", consumes = "multipart/form-data")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestPart("user") User user, @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        log.info("Updating user with ID {}: user={}, file={}", id, user, file != null ? file.getOriginalFilename() : "no file");
        User updatedUser = userService.updateUser(id, user, file);
        return ResponseEntity.ok(updatedUser);
    }

}
