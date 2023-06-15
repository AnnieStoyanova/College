import { Component } from '@angular/core';
import { CourseService } from '../course.service';
import { Course } from '../course';

@Component({
  selector: 'app-table-item',
  templateUrl: './table-item.component.html',
  styleUrls: ['./table-item.component.css']
})
export class TableItemComponent {
  courses: Course[] = [];
  constructor(private courseService:CourseService) {

  }

ngOnInit() {
  this.courseService.findAll().subscribe(data =>
    this.courses = data
  )
  console.log(this.courses);
};

  


}
