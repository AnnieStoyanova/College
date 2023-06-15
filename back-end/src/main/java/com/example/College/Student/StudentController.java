package com.example.College.Student;

import com.example.College.Course.Course;
import com.example.College.Grade.Grade;
import com.example.College.Grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;


    public StudentController(StudentService studentService, GradeService gradeService) {
        this.studentService = studentService;
        this.gradeService = gradeService;
    }

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


    @GetMapping(value = "/{studentId}/grades")
    public Optional<List<Grade>> getAllGrades(@PathVariable("studentId") Long studentId) {
        return studentService.findStudentById(studentId).map(Student::getGrades);
    }

    @PatchMapping(value = "/addGradeToStudent/{studentId}/{gradeId}")
    public Optional<Object> addGrade(@PathVariable("studentId") Long studentId, @PathVariable("gradeId") Long gradeId){
        return studentService.findStudentById(studentId).map(student -> {
            student.addGradeToStudent(gradeService.findGradeById(gradeId).get());
            studentService.addNewStudent(student);
            return student;
        });
    }


}
