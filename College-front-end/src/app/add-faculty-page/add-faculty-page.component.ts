import { Component } from '@angular/core';
import { FacultyService } from '../faculty.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-faculty-page',
  templateUrl: './add-faculty-page.component.html',
  styleUrls: ['./add-faculty-page.component.css']
})
export class AddFacultyPageComponent {
constructor(private facultyService:FacultyService, private router:Router){}

faculty = {
id:12,
name:" "
}
addFaculty(name:string){
  this.faculty = {
    id:12,
    name:name
  }
  this.facultyService.addFaculty(this.faculty)
  this.router.navigate(["faculty-list-page-component"]).then(() => {
    window.location.reload();
  });
}

}
