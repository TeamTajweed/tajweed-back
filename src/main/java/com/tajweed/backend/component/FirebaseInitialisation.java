package com.tajweed.backend.component;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
@Component
public class FirebaseInitialisation {
    @Value("classpath:firebaseKey.json")
    Resource resourceFile;

    @PostConstruct
    public void initialize() throws IOException {
        InputStream serviceAccount = resourceFile.getInputStream();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tajweed-97b3e.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);
    }
}
