package com.cydeo.repository;

import com.cydeo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    //build all queries that'll bring data from DB
    //there are 2 ways
    //derive query
    //@Query(JPA,native)
    //also there is ready repository, if not enough I can start buildign my queries

}
