package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        //controller calling me and requesting all the roles
        //so.. I need to go to DB and bring all the roles from there
        //repository is the one that brings the data from DB
        //how can I call any method from Role repository
//        List<Role> roleList = roleRepository.findAll();
        //this is Role but we need to return RoleDTO
        //we need a mechanism help us convert entity to DTO
        //we need MAPPERS,
        //1- add mapper dependency to POM
        //2- dependecy mean we bring library, means we have classes to use. We need to use the obkect of that class
        //we're in spring we need bean, how can we have been from this external class - @Configuration class
        //if we don't want to create config class we can have the bean in application - runner class

        //convert entity to dto - Mapper - get roles from DB and convert each role to RoleDto
//       return roleRepository.findAll().stream().map(roleMapper::convertToDto).collect(Collectors.toList());
       return roleRepository.findAll().stream().map(role->
               mapperUtil.convert(role,new RoleDTO())).collect(Collectors.toList());

    }

    @Override
    public RoleDTO findById(Long id) {

//        return roleMapper.convertToDto(roleRepository.findById(id).get());
        return mapperUtil.convert(roleRepository.findById(id).get(),new RoleDTO());
    }
}
