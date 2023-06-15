import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from '../student.service';
import { TeacherService } from '../teacher.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent {

  constructor(private studentService: StudentService, private teacherSrvice:TeacherService, private myRouter: Router){} 

student = {
    id: 12,
    role: " ",
    firstName: " ",
    lastName: " ",
    email: " ",
    password: " "
    };

    teacher = {
      id: 12,
      role: " ",
      firstName: " ",
      lastName: " ",
      email: " ",
      password: " "
      };

getVal(role:string,firstName:string, lastName:string,email:string,password:string)
  {

    if(role == "student"){
      this.student = {
      id: 12,
      role: role.toUpperCase(),
      firstName: firstName,
      lastName: lastName, 
      email: email,
      password: password
      };

      this.studentService.addStudent(this.student);
      this.myRouter.navigateByUrl('home-page-component');
    }else if(role=="teacher"){

      this.teacher = {
        id: 12,
        role: role.toUpperCase(),
        firstName: firstName,
        lastName: lastName, 
        email: email,
        password: password
        };
  
        this.teacherSrvice.addTeacher(this.teacher);
        this.myRouter.navigateByUrl('home-page-component');
    }else{
      console.log("Something went wrong");
    }
  }
}

