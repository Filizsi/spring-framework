package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Java {
        OfficeHours officeHours;



    //2. constructor injection
//    @Autowired
//    public Java(OfficeHours of) {
//        this.officeHours = of;
//    }

    //1 field injection
//    @Autowired
    public void getTeachingHours(){
        System.out.println("Weekly teaching hours : " +(20+officeHours.officeHours()));
    }
}
