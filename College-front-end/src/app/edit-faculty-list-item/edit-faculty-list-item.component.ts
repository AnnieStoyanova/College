import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FacultyService } from '../faculty.service';
import { FacultyListItemComponent } from '../faculty-list-item/faculty-list-item.component';


@Component({
  selector: 'app-edit-faculty-list-item',
  templateUrl: './edit-faculty-list-item.component.html',
  styleUrls: ['./edit-faculty-list-item.component.css']
})
export class EditFacultyListItemComponent {

  faculty = {
    id:12,
    name:""
  }
  constructor(private router: Router, private facultyService: FacultyService) { }

  edit(newName:string) {
    this.faculty.name = newName;
    console.log(FacultyListItemComponent.ID);
    this.facultyService.updateFaculty(FacultyListItemComponent.ID, this.faculty);
    this.router.navigateByUrl("faculty-list-page-component");
  }


}
