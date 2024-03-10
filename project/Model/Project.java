package com.example.project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
   // project Class : ID , title , description , status, companyName
    private  int id;
    private String title;
    private String description;
    //private boolean status;
    private String status;
    private String companyName;
}
