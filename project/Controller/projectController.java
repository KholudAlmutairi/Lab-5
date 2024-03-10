package com.example.project.Controller;

import com.example.project.Api.ApiResponse;
import com.example.project.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class projectController {

    ArrayList<Project> projects = new ArrayList<>();

    //Display all project .
    @GetMapping("/get")
    public ArrayList<Project> getProjects() {
        return projects;
    }

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("project added");
    }

    // Update a project
    @PutMapping("/update/{id}")
    public ApiResponse updatedProject(@PathVariable int id, @RequestBody Project project) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == id) {
                projects.set(i,project);
                return new ApiResponse("project updated");
            }
        }
        return new ApiResponse("project not found with id: " + id);
    }

    //Delete a project
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteProject(@PathVariable int id) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == id) {
                projects.remove(i);
                return new ApiResponse("project deleted");
            }
        }
        return new ApiResponse("project not found");
    }

    //• Change the project status as done or not done

    @PutMapping("/change/{id}")
    public ApiResponse changeProject(@PathVariable int id, @RequestBody String status) {
        for (Project project : projects) {
            if (project.getId() == id) {
                project.setStatus(status);
                return new ApiResponse("Project status changed");
            }
        }
        return new ApiResponse("Project not found");
    }

    //• Display All project for one company by companyName.
    @GetMapping("/getByCompany/{companyName}")
    public ApiResponse getByCompany(@PathVariable String companyName){
        ArrayList<Project> company = new ArrayList<>();
        for (Project project:projects){
            if(project.getCompanyName().equals(companyName)){
                company.add(project);
                return new ApiResponse(("Company name does exist projects"+"  "+ company));
            }

        }
        return new ApiResponse("Company does not exist projects ");
    }

    // Search for a project by given title.
    @GetMapping("/search/{title}")
    public ApiResponse searchProject(@PathVariable String title){
            for (Project project : projects) {
                if (project.getTitle().equals(title)) {
                    return new ApiResponse("Project found"+" "+project);
                }
            }
            return new ApiResponse("Project not found");
        }


    }









