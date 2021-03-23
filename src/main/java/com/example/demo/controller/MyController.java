package com.example.demo.controller;

import com.example.demo.CSVHelper;
import com.example.demo.Campaign;
import com.example.demo.Merchant;
import com.example.demo.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.catalina.util.CustomObjectInputStream;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
public class MyController {

//    @RequestMapping("/")
//    public String get(){
//        return "index";
//    }
    @Autowired
    CallbackRepository repo;

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value = "/callback",method = {RequestMethod.POST})
    public void callBackResponse(@RequestBody CallbackTemplate callbackTemplate) {
        if(repo.findexists(callbackTemplate.getMessageID())==0) {
            repo.save(callbackTemplate);
        }
//        else if(repo.findstatus(callbackTemplate.getMessageID())!="STATUS_DELIVERED"){
//            repo.save(callbackTemplate);
//        }
        //System.out.println(callbackTemplate.toString());
    }

    @ResponseBody
    @RequestMapping(value="/uploadfile",method = {RequestMethod.POST})
    public String uploadFile(@RequestParam("Campaign")String campaignId,@RequestParam("file") MultipartFile file) {
        ObjectMapper mapper=new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String message="";
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                List<HashMap<String,String>> l=CSVHelper.csvToTutorials(file.getInputStream());
                List<String> headerlist=CSVHelper.headerList(file.getInputStream());
                for(int i=0;i<l.size();i++){
                    Campaign campaign=new Campaign();
                    campaign.setCampaignID(campaignId);
                    SendToNumber number=new SendToNumber(l.get(i).get("MobileNumber"));
                    CallbackUrl Url=new CallbackUrl("https://8647b271ee8f.ngrok.io/callback");
                    campaign.setTo(number) ;
                    campaign.setCallback(Url);
                    HashMap<String,String> h=new HashMap<>();
                    for(int j=1;j<headerlist.size();j++){
                        h.put(headerlist.get(j),l.get(i).get(headerlist.get(j)));
                    }
                    campaign.setParameters(h);
                    String postString=mapper.writeValueAsString(campaign);
                    Post post=new Post();
                    post.POSTRequest(postString);
                }
                return "SuccessFull";
            } catch (Exception e) {
                System.out.println(e);
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return message;
            }
        }

        message = "Please upload a csv file!";
        return message;
    }

}
