package com.example.quiz3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Size(min = 4, max = 10)
    @Column(columnDefinition = "varchar (20) not null unique")
    private String username;
  @NotEmpty
  @Size(min = 6 )
    private String password;
@NotEmpty
@Size(min = 2, max = 20)
    private String name;
@Email
@Column(columnDefinition = "varchar(20) not null unique")
    private String email;

@NotEmpty
//@Pattern(regexp = "CUSTOMER"|"EMPLOYEE" |"ADMIN")
    private String role;


    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer customer;

@OneToOne
@PrimaryKeyJoinColumn
private Employee employee;

}
