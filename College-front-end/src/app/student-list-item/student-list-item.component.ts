import { Component } from '@angular/core';
import {Student} from '../student';
import { StudentService } from '../student.service';
import { CourseService } from '../course.service';
import { CoursesListItemComponent } from '../courses-list-item/courses-list-item.component';
import { Router } from '@angular/router';



@Component({
  selector: 'app-student-list-item',
  templateUrl: './student-list-item.component.html',
  styleUrls: ['./student-list-item.component.css']
})
export class StudentListItemComponent {
  students: Student[] = [];
  static ID: number;

  constructor(private courseService:CourseService,private router:Router) {}

  ngOnInit(): void{
    this.courseService.getStudents(CoursesListItemComponent.ID).subscribe(
      data => {
        this.students = data;
        console.log("Successfully get students", data);
      },
      error => {
        console.error("Failed to get Students of course with id:" + CoursesListItemComponent.ID, error);
      }
    );
  };

  edit(id:number){
CoursesListItemComponent.ID = id;
this.router.navigateByUrl("edit-course-component")
  }

  delete(id:number){

  }
}
