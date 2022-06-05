package com.cydeo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
@JsonIgnoreProperties(value = "{hibernateLazyInitializer}", ignoreUnknown = true)
public class User extends BaseEntity {

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//show me when I am posting, don't show me when I get it
    private String password;

    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference
    //is the forward part of the referebce - the one that gets serialize normally, we'll see account in user
    private Account account;

}
