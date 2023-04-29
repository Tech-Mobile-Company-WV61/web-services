package com.fastporte.fastportewebservice.util;

import com.fastporte.fastportewebservice.FastPorteWebServiceApplication;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class FirebaseService {

    @PostConstruct
    public void initializeFirebaseApp() throws IOException {
        ClassLoader classLoader = FastPorteWebServiceApplication.class.getClassLoader();

        File file = new File(Objects.requireNonNull(classLoader.getResource("firebase_secret.json")).getFile());

        FileInputStream serviceAccount =
                new FileInputStream(file.getAbsolutePath());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

    }

}