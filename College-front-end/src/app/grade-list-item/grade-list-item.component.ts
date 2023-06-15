import { Component } from '@angular/core';
import {Grade} from '../grade';
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

  constructor(private studentService:StudentService,private router:Router) {}

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

  delete(id:number){

  }
}
