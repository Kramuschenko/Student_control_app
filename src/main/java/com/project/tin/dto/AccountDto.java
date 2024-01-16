package com.project.tin.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AccountDto {


    private int id;
    private String username;
    private String password;
    private String isAdmin;
}