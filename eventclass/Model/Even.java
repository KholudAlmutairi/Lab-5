package com.example.eventclass.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Even {

    //ID , description , capacity, startDate , endDate
    private int id;
    private  String description;
    private double  capacity;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    private LocalDateTime endDate;




}
