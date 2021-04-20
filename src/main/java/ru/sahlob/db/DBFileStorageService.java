package ru.sahlob.db;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.sahlob.db.interfaces.DBLogosRepository;
import ru.sahlob.persistance.Logo;

import java.io.IOException;

@Service
@Data
public class DBFileStorageService {

    private final DBLogosRepository dbLogosRepository;

    public Logo storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            var dbFile = new Logo(fileName, file.getContentType(), file.getBytes());
            return dbLogosRepository.save(dbFile);
        } catch (IOException ex) {
            throw null;
        }
    }
}
