import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-faculty-list-page',
  templateUrl: './faculty-list-page.component.html',
  styleUrls: ['./faculty-list-page.component.css']
})
export class FacultyListPageComponent {

  constructor(private router:Router){}

  addFaculty(){
   this.router.navigateByUrl("add-faculty-page-component");
  }

}
