package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.Property;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

@PropertySource("classpath:application.properties")
public class IsEqual {

        private static boolean isEqual(Path resultsFile, Path studentResultsFile) throws IOException {
        try (BufferedReader bf1= Files.newBufferedReader(resultsFile);
             BufferedReader bf2 = Files.newBufferedReader(studentResultsFile)) {
            String line;
            int j=0;
            int sum =0;
            Properties prop = new Properties();
            prop.load(new FileInputStream("application.properties"));
            while ((line= bf1.readLine()) != null) {
                if (line != bf2.readLine()) {
                    j++;
                    return false;
                }
            } j++;
            if (j<5) sum = sum + Integer.parseInt(prop.getProperty("pointAnswer1-4"));
            if (j<8 &  j >4) sum = sum + Integer.parseInt(prop.getProperty("pointAnswer4-8"));
            if (j<10 &  j >8) sum = sum + Integer.parseInt(prop.getProperty("pointAnswer9-10"));
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }return false;
    }

}
