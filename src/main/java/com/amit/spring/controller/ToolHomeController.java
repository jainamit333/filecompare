package com.amit.spring.controller;

import com.amit.spring.Executor.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by amit on 20/2/16.
 */
@Controller
public class ToolHomeController {


    @Autowired
    RequestHandler requestHandler;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String loadTools(){
        return "index";
    }

    @RequestMapping(value="/upload",method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestParam("multipartFile1")MultipartFile multipartFile1,@RequestParam("multipartFile2")MultipartFile multipartFile2) throws IOException {

        if(!multipartFile1.isEmpty() || !multipartFile2.isEmpty()){

            requestHandler.executeRequest(multipartFile1,multipartFile2);

        }
        return "success";
    }
}
