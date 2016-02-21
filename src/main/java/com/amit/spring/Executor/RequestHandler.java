package com.amit.spring.Executor;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit on 21/2/16.
 */
@Component
public class RequestHandler {



    public void executeRequest(MultipartFile multipartFile1,MultipartFile multipartFile2) throws IOException {




        BufferedReader reader1 = new BufferedReader(new InputStreamReader(multipartFile1.getInputStream()));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(multipartFile2.getInputStream()));


        String line1 = null;
        String line2 = null;

        while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null)
        {
            if (!line1.equals(line2))
            {
                System.out.println("file 1 "+ line1);
                System.out.println("file 2 "+ line2);
            }
        }


        for (String line; (line = reader1.readLine()) != null;) {
            System.out.println(line);
        }
        for (String line; (line = reader2.readLine()) != null;) {
            System.out.println(line);
        }
    }
}
