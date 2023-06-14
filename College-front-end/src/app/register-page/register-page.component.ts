import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent {

  constructor(private profileService: StudentService, private myRouter: Router){} 

student = {
    id: 12,
    role: " ",
    firstName: " ",
    lastName: " ",
    email: " ",
    password: " "
    };

getVal(role:string,firstName:string, lastName:string,email:string,password:string)
  {

      this.student = {
      id: 12,
      role: role.toUpperCase(),
      firstName: firstName,
      lastName: lastName, 
      email: email,
      password: password
      };

      this.profileService.addStudent(this.student);
      this.myRouter.navigateByUrl('home-page-component');

  }
}

