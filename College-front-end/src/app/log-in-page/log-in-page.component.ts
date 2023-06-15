import { Component, ElementRef, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { Student } from '../student';

@Component({
  selector: 'app-log-in-page',
  templateUrl: './log-in-page.component.html',
  styleUrls: ['./log-in-page.component.css']
})
export class LogInPageComponent {

  constructor(private profileService: StudentService, private router: Router, 
    private elementRef: ElementRef) {}

student: Student = {
    id: 0,
    role: "",
    firstName: "",
    lastName: "",
    email: "",
    password: ""
  };

  ngOnSubmit() {
    const myElement = this.elementRef.nativeElement.querySelector('#email');
    const extractedData = myElement.innerHTML;
    console.log(extractedData); 
  }
  
  
  // getVal(email:string,password:string)
  // {
  //   console.log("In function getval");
  //   this.profileService.findByEmail(email).subscribe(data => {
  //     this.student = data
      
  //     console.log(this.profile)
      
  //     if(this.profile!=null && password == this.profile.password){
      
  //     this.router.navigateByUrl('home-page-component');
  //     console.log("Logged in successfully!")
  //    } else {
  //     console.log("Log in failed");
  //    }
      
  //   });
  // }

}
  
