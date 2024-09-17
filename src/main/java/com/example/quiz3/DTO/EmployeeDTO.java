package com.example.quiz3.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {


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
    private String position ;

//    @NotNull
//    @Positive
    private double salary;
}
