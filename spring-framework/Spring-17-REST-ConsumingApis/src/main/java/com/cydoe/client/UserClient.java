package com.cydoe.client;

import com.cydoe.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url="https://jsonplaceholder.typicode.com",name = "USER-CLIENT") //base url
//USER CLIENT IF TARGETING THE URL ENDPOINT
public interface UserClient {

    @GetMapping("/users")
    List<User> getUsers();

}
