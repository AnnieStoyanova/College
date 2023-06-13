import { Component } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { DepartmentService } from '../department.service';
import { DepartmentListItemComponent } from '../department-list-item/department-list-item.component';

@Component({
  selector: 'app-courses-list-item',
  templateUrl: './courses-list-item.component.html',
  styleUrls: ['./courses-list-item.component.css']
})
export class CoursesListItemComponent {
  courses: Course[] = [];

  constructor(private departmentService:DepartmentService) {}

  ngOnInit(): void{
    this.departmentService.getCourses(DepartmentListItemComponent.ID).subscribe(
      data => {
        this.courses = data;
        console.log("Successfully get courses", data);
      },
      error => {
        console.error("Failed to get Courses of faculty with id:" + DepartmentListItemComponent.ID, error);
      }
    );
  };
}
