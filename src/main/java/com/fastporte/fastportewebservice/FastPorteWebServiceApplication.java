package com.fastporte.fastportewebservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class FastPorteWebServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(FastPorteWebServiceApplication.class, args);
    }

}
