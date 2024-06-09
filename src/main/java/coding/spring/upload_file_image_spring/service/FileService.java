package coding.spring.upload_file_image_spring.service;

import coding.spring.upload_file_image_spring.entities.File;
import coding.spring.upload_file_image_spring.repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileService {
    private FileRepo fileRepo;

    public String storeFile(MultipartFile file) throws IOException {
        File files = File.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes())
                .build();
         files= this.fileRepo.save(files);
        if (files.getId() !=null){
            return " File uploaded successfuly into data base";
        }
     return null;
    }


    public byte[] getFiles(String nameFile) {
        return fileRepo.findByName(nameFile)
                .map(File::getImageData)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }
}
