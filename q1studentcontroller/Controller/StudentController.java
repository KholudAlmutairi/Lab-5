package com.example.q1studentcontroller.Controller;

import com.example.q1studentcontroller.Api.ApiResponse;
import com.example.q1studentcontroller.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/student")
class StudentController {
    private static ArrayList<Student> students = new ArrayList<>();

    //- GET /students : return array of students
    @GetMapping("/get")
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // add
    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("student added");
    }
    // Update a student
    @PutMapping("/update/{id}")
    public ApiResponse updatedStudent(@PathVariable int id, @RequestBody Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return new ApiResponse("student updated");
            }
        }
        return new ApiResponse("student not found with id: " + id);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteStudent(@PathVariable int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return new ApiResponse("student deleted");
            }
        }
        return new ApiResponse("student not found");
    }

    // GET /name : return name of student by student id
    @GetMapping("/name/{id}")
    public ApiResponse getStudentName(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return new ApiResponse("Student name is " + student.getName());
            }
        }
        return new ApiResponse("Student not found ");
    }

    // GET /age : return age of student
    @GetMapping("/age/{id}")
    public ApiResponse getAge(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return new ApiResponse("Student age is " + student.getAge());
            }
        }
        return new ApiResponse("Student age not found");
    }


    // GET /college/degree: return bachelor or diploma or master
    @GetMapping("/college/degree/{id}")
    public ApiResponse getDegree(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return new ApiResponse("Student degree is " + student.getDegree());
            }
        }
        return new ApiResponse("Student degree not found");
    }


    // GET /study/status: return true if graduated and false if ungraduated
    @GetMapping("/study/status/{id}")
    public ApiResponse getGraduated(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return new ApiResponse("Student graduated " + student.isGraduated());
            }
        }
        return new ApiResponse("Student ungraduated");
    }

}










    ////

//    //- GET /name : return name of student
//    @GetMapping("/name/{id}")
//    public String getStudentName(@PathVariable int id) {
//        for (int i = 0; i < students.size(); i++){
//            if(students.get(i).getId()==id){
//               int x =students.get(i).getName();
//                return x ;
//            }
//        }
//        return new ApiResponse("student not found") ;
//
//
//    }
//
//    //- GET /age : return age of student
//    @GetMapping("/age")
//    public int getStudentAge() {
//        for each
//
//        return students.get(0).getAge();
//    }
//
//
//    //- GET / college/degree: return bachelor or diploma or master
//    @GetMapping("/college/degree")
//    public String getStudentDegree() {
//        for each
//        return students.getDegree();
//    }
//
//    //- GET / study/status: return true if graduated and false if ungraduated
//    @GetMapping("get/study/status")
//    public boolean getStudyStatus() {
//        for each
//
//        return students.isGraduated();
//    }






