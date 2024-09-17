package com.example.quiz3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private Integer id;

@NotEmpty
//@Pattern(regexp = "")
    private String accountNumber;

    @NotNull
    @Positive
    private double balance;

    @AssertFalse
    private boolean isActive;

    @ManyToOne
    @JsonIgnore
    private Customer customer;
}
