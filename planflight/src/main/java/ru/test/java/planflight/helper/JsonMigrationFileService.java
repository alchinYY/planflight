package ru.test.java.planflight.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.test.java.planflight.exception.InternalServerException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@RequiredArgsConstructor
@Component
public class JsonMigrationFileService implements FileHelper {

    @Value("${tmp.dir}")
    private File tmpDir;

    private final ObjectMapper objectMapper;

    @Override
    public <D> D parse(File file, Class<D> outCLass) {
        try {
            return objectMapper.readValue(file, outCLass);
        } catch (IOException ex) {
            throw new InternalServerException(ex.getMessage());
        }
    }

    @Override
    public File saveFile(MultipartFile file) {
        var fileName = Objects.requireNonNull(file.getOriginalFilename());
        File saveFile = new File(tmpDir, fileName);
        try {
            FileUtils.forceMkdir(saveFile.getParentFile());
            Files.copy(file.getInputStream(), saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return saveFile;
        } catch (IOException ex) {
            throw new InternalServerException(ex.getMessage());
        }
    }

}
