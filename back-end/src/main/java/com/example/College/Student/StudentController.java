package com.example.College.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/all")
    private Collection<Student> getAll(){
        return studentService.findAllStudents();
    }

    @GetMapping("/byEmail/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable String email){
        System.out.println(studentService.findStudentByEmail(email));
        return studentService.findStudentByEmail(email);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
            studentService.saveStudentToDb(student);
    }

    @PutMapping("/update/{studentId}")
    public Optional<Student> updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student newStudent) {
        return studentService.findStudentById(studentId)
                .map((student) -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setEmail(newStudent.getEmail());
                    student.setPassword(newStudent.getPassword());
                    studentService.saveStudentToDb(student);
                    return student;
                });

    }
}
