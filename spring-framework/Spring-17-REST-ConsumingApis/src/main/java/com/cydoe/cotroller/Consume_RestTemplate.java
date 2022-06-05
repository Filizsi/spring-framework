package com.cydoe.cotroller;

import com.cydoe.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    //uri that we gonna consume
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    //we need to inject resttemplate bean
    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //build my api, get entity return []
    @GetMapping
    public User[] readAllUsers(){
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI,User[].class);//mapped the api with my DTO class I want

        return responseEntity.getBody();
    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){
        String URL = URI+"/{id}";
        return restTemplate.getForObject(URL,Object.class,id);//this one is mot mapping just give us any object
    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApi(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);
        return response;
    }
}
