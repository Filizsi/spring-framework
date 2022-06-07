package com.cydoe.cotroller;

import com.cydoe.client.EmployeeClient;
import com.cydoe.client.UserClient;
import com.cydoe.dto.ResponseWrapper;
import com.cydoe.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient  userClient;
    private final EmployeeClient employeeClient;


    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users") //my api en
    public ResponseEntity<ResponseWrapper> getUser(){
        return  ResponseEntity.ok(new ResponseWrapper("User list retrieved",userClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee(){
        return ResponseEntity.ok(new ResponseWrapper("success",employeeClient.getEmployees("6298ebfecd0551211fce37a6")));
    }
}
