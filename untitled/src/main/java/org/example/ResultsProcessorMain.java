package org.example;

import java.io.File;
import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ResultsProcessorMain {

    public static void main(String[] args) throws IOException {
        File resultsFile = new File();
        File studentResultsFile = new File();
        boolean equal =  new IsEqual(resultsFile.toPath(),studentResultsFile.toPath());
        System.out.println(equal);

    }
}