package coding.spring.upload_file_image_spring.controller;

import coding.spring.upload_file_image_spring.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileController {
      private FileService fileService;
      @PostMapping("/ulpoadFile")
      public ResponseEntity<String> storeFileIntoBD(@RequestParam("file") MultipartFile files) throws IOException {
            String response =fileService.storeFile(files);
            return ResponseEntity.ok().body(response);

      }
      @GetMapping("/getFileByName/{fileName}")
      public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
            byte[] imageData = fileService.getFiles(fileName);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(imageData);
      }
}
