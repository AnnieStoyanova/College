import { Component } from '@angular/core';
import { Department } from '../department';
import { FacultyService } from '../faculty.service';
import { Router } from '@angular/router';
import { FacultyListItemComponent } from '../faculty-list-item/faculty-list-item.component';

@Component({
  selector: 'app-department-list-item',
  templateUrl: './department-list-item.component.html',
  styleUrls: ['./department-list-item.component.css']
})
export class DepartmentListItemComponent {
  departments: Department[] = [];
  static ID: number;

  constructor(private facultyService: FacultyService,private router: Router) {}

  ngOnInit(): void {
    this.facultyService.getDepartments(FacultyListItemComponent.ID).subscribe(
      data => {
        this.departments = data;
        console.log("Successfully get departments", data);
      },
      error => {
        console.error("Failed to get Departments of faculty with id:" + FacultyListItemComponent.ID, error);
      }
    );
  }  
  getId(id: number): void {
    DepartmentListItemComponent.ID = id;
    this.router.navigateByUrl('course-list-page-component');
    console.log(DepartmentListItemComponent.ID);
  }
}
