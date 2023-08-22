package com.tajweed.backend.component;

import com.google.cloud.storage.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class FirebaseStorageService {
    private static final String BUCKET_NAME = "my-unique-bucket-name";

    public String uploadFile(MultipartFile multipartFile) throws IOException {

        String objectName = generateFileName(multipartFile);
        BlobId blobId = BlobId.of(BUCKET_NAME, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(multipartFile.getContentType()).build();

        Storage storage = StorageOptions.getDefaultInstance().getService();
        storage.create(blobInfo, multipartFile.getBytes());

        return objectName;
    }

    public String getFile(String name) {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        Blob blob = storage.get(BUCKET_NAME, name);

        return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s", BUCKET_NAME, name);
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + Objects.requireNonNull(multiPart.getOriginalFilename()).replace(" ", "_");
    }
}
