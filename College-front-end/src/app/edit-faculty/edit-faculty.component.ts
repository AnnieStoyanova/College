import { Component } from '@angular/core';
import { FacultyListItemComponent } from '../faculty-list-item/faculty-list-item.component';
import { FacultyService } from '../faculty.service';
import { NavigationExtras, Router } from '@angular/router';

@Component({
  selector: 'app-edit-faculty',
  templateUrl: './edit-faculty.component.html',
  styleUrls: ['./edit-faculty.component.css']
})
export class EditFacultyComponent {

  constructor(private facultyService: FacultyService, private router:Router){}

faculty ={
  id:12,
  name:" "
}

  edit(name:string){
    this.faculty ={
      id:FacultyListItemComponent.ID,
      name:name
    }
    this.facultyService.updateFaculty(FacultyListItemComponent.ID,this.faculty);
    const navigationExtras: NavigationExtras = {
      queryParams: { reload: true }
    };
    this.router.navigate(["faculty-list-page-component"], navigationExtras);
}
}
