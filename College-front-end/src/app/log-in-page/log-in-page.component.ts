import { Component } from '@angular/core';
import { ProfileService } from '../profile.service';
import { Router } from '@angular/router';
import { Profile } from '../profile';

@Component({
  selector: 'app-log-in-page',
  templateUrl: './log-in-page.component.html',
  styleUrls: ['./log-in-page.component.css']
})
export class LogInPageComponent {

  constructor(private profileService: ProfileService, private router: Router) {}

profile: Profile = {
    id: 0,
    role: "",
    name: "",
    email: "",
    password: ""
  };
  
  getVal(email:string,password:string)
  {
    console.log("In function getval");
    this.profileService.findByEmail(email).subscribe(data => {
      this.profile = data
      
      console.log(this.profile)
      
      if(this.profile!=null && password == this.profile.password){
      
      this.router.navigateByUrl('home-page-component');
      console.log("Logged in successfully!")
     } else {
      console.log("Log in failed");
     }
      
    });
  }

}
  
