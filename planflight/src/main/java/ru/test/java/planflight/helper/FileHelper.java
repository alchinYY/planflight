package ru.test.java.planflight.helper;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileHelper {
    File saveFile(MultipartFile file);
    <D> D parse(final File file, Class<D> outCLass);
}
