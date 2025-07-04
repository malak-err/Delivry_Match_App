package com.deliverymatch.deliverymatch.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ConducteurDto {

    private  Long id;
    private String firstName;

    private String lastName;

    private  String email;
    private String password;




}
