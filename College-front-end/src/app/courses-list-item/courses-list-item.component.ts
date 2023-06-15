import { Component } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';
import { DepartmentService } from '../department.service';
import { DepartmentListItemComponent } from '../department-list-item/department-list-item.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-courses-list-item',
  templateUrl: './courses-list-item.component.html',
  styleUrls: ['./courses-list-item.component.css']
})
export class CoursesListItemComponent {
  courses: Course[] = [];
  static ID: number;

  constructor(private departmentService: DepartmentService, private router: Router) { }

  ngOnInit(): void {
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

  getId(id: number): void {
    CoursesListItemComponent.ID = id;
    this.router.navigateByUrl('student-list-page-component');
  }

  edit(id: number) {
    CoursesListItemComponent.ID = id;
    this.router.navigateByUrl("edit-course-component")
  }

  delete(id: number) {

  }
}
