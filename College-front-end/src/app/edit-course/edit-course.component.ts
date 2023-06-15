import { Component } from '@angular/core';
import { CourseService } from '../course.service';
import { NavigationExtras, Router } from '@angular/router';
import { CoursesListItemComponent } from '../courses-list-item/courses-list-item.component';

@Component({
  selector: 'app-edit-course',
  templateUrl: './edit-course.component.html',
  styleUrls: ['./edit-course.component.css']
})
export class EditCourseComponent {

  constructor(private courseService:CourseService,private router:Router){}

course = {
  id:12,
  name: " "
}

edit(name:string){
  this.course = {
  id:12,
  name:name
}

this.courseService.updateCourse(CoursesListItemComponent.ID,this.course)
const navigationExtras: NavigationExtras = {
  queryParams: { reload: true }
};
this.router.navigate(["faculty-list-page-component"], navigationExtras);
}

}
