import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { HttpClientModule } from '@angular/common/http';
import { CoursesListPageComponent } from './courses-list-page/courses-list-page.component';
import { CoursesListItemComponent } from './courses-list-item/courses-list-item.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { FacultyListPageComponent } from './faculty-list-page/faculty-list-page.component';
import { FacultyListItemComponent } from './faculty-list-item/faculty-list-item.component';
import { DepartmentListItemComponent } from './department-list-item/department-list-item.component';
import { DepartmentListPageComponent } from './department-list-page/department-list-page.component';
import { EditFacultyComponent } from './edit-faculty/edit-faculty.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { EditDepartmentComponent } from './edit-department/edit-department.component';
import { EditCourseComponent } from './edit-course/edit-course.component';
import { StudentListPageComponent } from './student-list-page/student-list-page.component';
import { StudentListItemComponent } from './student-list-item/student-list-item.component';
import { AddFacultyPageComponent } from './add-faculty-page/add-faculty-page.component';
import { GradeListPageComponent } from './grade-list-page/grade-list-page.component';
import { GradeListItemComponent } from './grade-list-item/grade-list-item.component';
import { TableComponent } from './table/table.component';
import { TableItemComponent } from './table-item/table-item.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    CoursesListPageComponent,
    CoursesListItemComponent,
    RegisterPageComponent,
    FacultyListPageComponent,
    FacultyListItemComponent,
    DepartmentListItemComponent,
    DepartmentListPageComponent,
    EditFacultyComponent,
    LoginPageComponent,
    EditDepartmentComponent,
    EditCourseComponent,
    StudentListPageComponent,
    StudentListItemComponent,
    AddFacultyPageComponent,
    GradeListPageComponent,
    GradeListItemComponent,
    TableComponent,
    TableItemComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
