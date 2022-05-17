package com.cydeo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MapperUtil {
    private final ModelMapper modelMapper;

    public MapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //generic method type first then return type
    public <T> T convert(Object objectToBeConverted, T convertedObject) {
        return modelMapper.map(objectToBeConverted, (Type) convertedObject.getClass());
    }


//    //generic method type first then return type
//    public <T> T convertToEntity(Object objectToBeConverted,T convertedObject){
//
//        return modelMapper.map(objectToBeConverted,(Type)convertedObject.getClass());
//    }
//
//    //generic method type first then return type
//    public <T> T convertToDto(Object objectToBeConverted,T convertedObject){
//
//        return modelMapper.map(objectToBeConverted,(Type)convertedObject.getClass());
//    }
}
