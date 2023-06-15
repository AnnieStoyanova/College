import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {

constructor(private studentService:StudentService,private router:Router){}

student = {
  id: 12,
  role: " ",
  firstName: " ",
  lastName: " ",
  email: " ",
  password: " "
  };

getVal(role:string,email:string,password:string){
 
console.log(role);
console.log(email);
console.log(password);
this.studentService.findByEmail(email).subscribe(data=>{
  this.student=data;

  console.log(this.student);

 // this.router.navigateByUrl("home-page-component")

})
}

}
