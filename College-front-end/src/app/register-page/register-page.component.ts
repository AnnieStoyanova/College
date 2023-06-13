import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent {

  constructor(private profileService: ProfileService, private myRouter: Router){} 

profile = {
    id: 12,
    role: " ",
    name: " ",
    email: " ",
    password: " "
    };

getVal(role:string,name:string,email:string,password:string)
  {

      this.profile = {
      id: 12,
      role: role.toUpperCase(),
      name: name,
      email: email,
      password: password
      };

      this.profileService.addProfile(this.profile);
      this.myRouter.navigateByUrl('home-page-component');

  }
}

