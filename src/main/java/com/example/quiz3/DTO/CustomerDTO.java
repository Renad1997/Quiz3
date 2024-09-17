package com.example.quiz3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;


//    @NotEmpty
//    @Size(min = 4, max = 10)
//    @Column(columnDefinition = "varchar (20) not null unique")
    private String username;


//    @NotEmpty
//    @Size(min = 6 )
    private String password;

//    @NotEmpty
//    @Size(min = 2, max = 20)
    private String name;

//    @Email
//    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

//    @NotEmpty
//@Pattern(regexp = "CUSTOMER"|"EMPLOYEE" |"ADMIN")
    private String role;


//    @NotEmpty
//    @Pattern(regexp = "")
    private String phoneNumber;

}
