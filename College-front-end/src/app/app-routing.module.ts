import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component'
import { CoursesListPageComponent } from './courses-list-page/courses-list-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { FacultyListPageComponent } from './faculty-list-page/faculty-list-page.component';
import { DepartmentListPageComponent } from './department-list-page/department-list-page.component';
import { EditFacultyComponent } from './edit-faculty/edit-faculty.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { EditDepartmentComponent } from './edit-department/edit-department.component';
import { EditCourseComponent } from './edit-course/edit-course.component';
import { StudentListItemComponent } from './student-list-item/student-list-item.component';
import { StudentListPageComponent } from './student-list-page/student-list-page.component';
import { AddFacultyPageComponent } from './add-faculty-page/add-faculty-page.component';

const routes: Routes = [
  {path: 'home-page-component', component: HomePageComponent},
  {path: 'course-list-page-component', component: CoursesListPageComponent},
  {path: 'register-page-component', component: RegisterPageComponent},
  {path: 'faculty-list-page-component', component: FacultyListPageComponent},
  {path: 'department-list-page-component', component: DepartmentListPageComponent},
  {path: 'login-page-component', component: LoginPageComponent},
  {path: 'edit-faculty-component', component: EditFacultyComponent},
  {path: 'edit-department-component', component: EditDepartmentComponent},
  {path: 'edit-course-component', component: EditCourseComponent},
  {path: 'student-list-page-component', component: StudentListPageComponent},
  {path: 'student-list-item-component', component: StudentListItemComponent},
  {path: 'add-faculty-page-component', component: AddFacultyPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
