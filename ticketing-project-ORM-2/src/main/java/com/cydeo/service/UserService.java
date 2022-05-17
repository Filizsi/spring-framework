package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    //because Controller is calling this method, and controller will send it to
    //view we need to return DTO
    //service layer is always returning DTO
    List<UserDTO> listAllUsers();
    UserDTO findByUsername(String username);
    void save(UserDTO userDTO);
    UserDTO update (UserDTO userDTO);
    void deleteByUserName(String name);
    void delete(String username);
    public List<UserDTO> listAllByRole(String role);


}

