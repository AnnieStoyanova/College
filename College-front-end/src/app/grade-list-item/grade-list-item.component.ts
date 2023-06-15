import { Component } from '@angular/core';
import {Grade} from '../grade';
import { Course } from '../course';
import { GradeService } from '../grade.service';
import { StudentService } from '../student.service';
import { StudentListItemComponent } from '../student-list-item/student-list-item.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-grade-list-item',
  templateUrl: './grade-list-item.component.html',
  styleUrls: ['./grade-list-item.component.css']
})
export class GradeListItemComponent {
  grades: Grade[] = [];
  static ID: number;
  static courseName: string;
  static course:Course;

  constructor(private studentService:StudentService,private router:Router, private gradeService:GradeService) {}

  ngOnInit(): void{
    this.studentService.getGrades(StudentListItemComponent.ID).subscribe(
      data => {
        this.grades = data;
        console.log("Successfully get grades", data);
      },
      error => {
        console.error("Failed to get grades of course with id:" + StudentListItemComponent.ID, error);
      }
    );
  };

  edit(id:number){
    StudentListItemComponent.ID = id;
this.router.navigateByUrl("edit-student-component")
  }

  showCourse():void {
    //GradeListItemComponent.course = this.gradeService.getCourse(StudentListItemComponent.ID);
   // GradeListItemComponent.courseName = this.gradeService.getCourse(StudentListItemComponent.ID);
  }

  delete(id:number){

  }
}
