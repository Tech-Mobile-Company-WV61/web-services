package com.fastporte.fastportewebservice.util;

import com.fastporte.fastportewebservice.FastPorteWebServiceApplication;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class FirebaseService {

    @PostConstruct
    public void initializeFirebaseApp() throws IOException {
        ClassLoader classLoader = FastPorteWebServiceApplication.class.getClassLoader();

        String firebaseSecretJson = "{\n" +
                "  \"type\": \"service_account\",\n" +
                "  \"project_id\": \"fastporte-app\",\n" +
                "  \"private_key_id\": \"f5f3b1cfcc2b075db2af2fcd3814608f6b359d18\",\n" +
                "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDLWG5qRI8rY81S\nt/EvwyI9rxu6z1sx8Zh989KpuFbD2JWopSfhoYD7T5+lcw34QjmquzHKQ8Lmtwfs\npoOFu6iIcxtIkd67TA/1UnAxkctEv8CBLL0cw3t1KcNxrFDjpRJyWMBktFuMe9Ed\nzkFA3UA556Ltty+tLVtZXBXs5U+1tXrD87FFajmxz2JCwP/Wresn9Qsy0mru/ap+\nQbB3uLNJT6f56lZpmNXGXdE0Y8G1Xr7bMam5F4zkokiK5qxciG402pqVMJiHP8Qy\nz8kcJN620l6CkB7QvNVm3wF7ZH5ypSOHLIiel/oGD+i1WvXm7ilsUORQ9hvSln1O\nfzlF1l8nAgMBAAECggEAXWEJJ2y/cFX+8mb874mE/l2c9s8FGmzPMbvXuE+qLHqX\n01+wbklbsUyRzAkHV8OVtsUK6s7uQEO59F9NE4snLC3r0AoIhes6gtYuJl1Ewpfp\n34f7eit81MNueJOAe+GQlIkUJMq8JcmwMKdISPCxb0XjiJVwY+7pvaHvgZ+WWKMg\n989dwvlAPs9Or/xqeSk7tA4+CLxPE6xvqeC/2P1RTkCU12B50TOw02/vpm9alBiQ\njCP9Adn+R1Phcq0OmTlN28RkT3UBDKWEiy0yflW8+SR5yjqBEz+4FnAdqHRwhaS3\nSDnSqsu8S+r624uBus0fqpYCUShteIsgBE7/3mknLQKBgQD9r8dtA+2IqpuxRPwt\nWCB4QyNztNqJAK+d+SvfzLiSIQuy/hS0LyjncqFunGSKE8uIUxJwkypdlODuIKxb\nSccVCKxaViHjRvoOeV/0khXwcI7ytwo+LQn+kFqRfc6q+57CQM8T1XmRlMfZppjN\n5Vm17uInGXsejg5DIpqQqKLbJQKBgQDNMyIB6aJl25tesNZe+XhtP1nrtnJogixa\nTpCrRb6xUQLpwGchrQzp5gQGKV+A9bJKFfsAmZTwl5odoPcrlF2r3HzZHQ89Vkx2\nU1nplEj96PRVsauBr6xC0bwusRMtvKNZzXgRpOq/qyjx4YglQYs+TpzW8C7kKn5h\nd3eFmmPFWwKBgBDHwso8O0cR+fB03rVlIeiykDLEILx1Niid5cAM+5x24R463kW4\n5NzCYVk+sQvNGWZwEEUwBtpf0a0OrjfvnmKOy0/CaMVu2XWBo846p4ba+ymk3+GS\n+xlClSsQhk4bDLpOrSPjuAHgNIP6GBtuc0usfHsXnWQ9A0Z/kHfHH9adAoGAP3qc\nAJ94H66KKAboqkTenl1EwgiU6AOtGNrJIlLXJR98mTduMBrKrej8QbO22bwoRYb7\nOTpJuwwLHzNWg2LIf4wcC0ZUGpOB3/D1Fa9LzVCtlXz7I4lm7tzXLFKXLkT2+6b2\nh+7OuDCI4Br29R+LpeDH4C45M1h59Ejy7p/OUZUCgYABS09W8pUdwv6XC+pa/uLi\nVh+28cGdBAYnFAybWdrUZKK1Q1RCZ3WzKkfB4RHOwHK03OPshyvA/iUEUVNsdb/J\nKoejJVPcc4YV+8HyQf0KXrsFDlco1BkELVfM4JgPUUdXZGgkZHyZ9WPU55Q7se29\n0PLS2E1Pejw5wKwrkvptCA==\n-----END PRIVATE KEY-----\n\",\n" +
                "  \"client_email\": \"firebase-adminsdk-ggrgm@fastporte-app.iam.gserviceaccount.com\",\n" +
                "  \"client_id\": \"106523423209455532525\",\n" +
                "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-ggrgm%40fastporte-app.iam.gserviceaccount.com\"\n" +
                "}";


        InputStream serviceAccount = new ByteArrayInputStream(
                firebaseSecretJson.getBytes(StandardCharsets.UTF_8));

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("fastporte-app.appspot.com")
                .build();

        FirebaseApp.initializeApp(options);

    }

}