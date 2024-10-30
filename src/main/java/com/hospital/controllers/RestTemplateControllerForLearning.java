package com.hospital.controllers;

import com.hospital.dtos.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest-template")
@RequiredArgsConstructor
public class RestTemplateControllerForLearning {

    private final RestTemplate restTemplate;
    String URL = "https://jsonplaceholder.typicode.com/posts";

    @GetMapping("/get-all-post-data")
    public List<PostDto> getAllPost() {

        try {
            PostDto[] postData = restTemplate.getForObject(URL, PostDto[].class);
            return Arrays.asList(postData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
