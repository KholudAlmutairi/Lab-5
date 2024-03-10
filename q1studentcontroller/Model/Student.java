package com.example.q1studentcontroller.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor


public class Student {
    private int id;
    private String name;
    private String degree;
    private int age;
    private boolean graduated;
}
