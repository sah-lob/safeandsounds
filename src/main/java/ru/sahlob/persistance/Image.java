package ru.sahlob.persistance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fileName;
    private String fileType;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] data;

    public Image(MultipartFile multipartFile) throws IOException {
        this.fileName = multipartFile.getOriginalFilename();
        this.fileType = multipartFile.getContentType();
        this.data = multipartFile.getBytes();
    }

}
