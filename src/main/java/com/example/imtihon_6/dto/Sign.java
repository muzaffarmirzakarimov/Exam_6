package com.example.imtihon_6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sign {
//    @NotNull
    private String userName, password;
    private Integer aClass;
}
