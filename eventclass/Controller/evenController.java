package com.example.eventclass.Controller;

import com.example.eventclass.Api.ApiResponse;
import org.springframework.web.bind.annotation.*;
import com.example.eventclass.Model.Even;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/even")
public class evenController {
    ArrayList<Even> evens=new ArrayList<Even>();
    //• Display all event .
    @GetMapping("/get")
    public ArrayList<Even> getEvens(){
        return evens;
    }
    //Add event
    @PostMapping("/add")
    public ApiResponse addEven(@RequestBody Even even){
        evens.add(even);
        return new ApiResponse("even added") ;
    }

    // Update an event
    @PutMapping("/update/{id}")
    public ApiResponse updateEven(@PathVariable int id, @RequestBody Even even){
        for (int i = 0; i < evens.size(); i++) {
            if (evens.get(i).getId() == id) {
                evens.set(i, even);
                return new ApiResponse("even updated") ;
            }
        }
        return new ApiResponse("even not found") ;
    }

    // Delete an event
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteEven(@PathVariable int id){
        for (int i = 0; i < evens.size(); i++) {
            if (evens.get(i).getId() == id) {
                evens.remove(i);
                return new ApiResponse("even deleted") ;
            }
        }
        return new ApiResponse("even not found") ;
    }

    // Change capacity
    @PutMapping("/change/{id}")
    public ApiResponse changeCapacity(@PathVariable int id, @RequestBody Even even) {
        for (Even event : evens) {
            if (event.getId() == id) {
                event.setCapacity(even.getCapacity());
                return new ApiResponse("even capacity changed");
            }
        }
        return new ApiResponse("even not found");
    }

    // Search for an event by given id
    @GetMapping("/search/{id}")
    public ApiResponse searchEven(@PathVariable int id) {
        for (Even event : evens) {
            if (event.getId() == id) {
                return new ApiResponse("event exists");
            }
        }
        return new ApiResponse("event does not exist");
    }

}




