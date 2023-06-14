import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component'
import { CoursesListPageComponent } from './courses-list-page/courses-list-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { FacultyListPageComponent } from './faculty-list-page/faculty-list-page.component';
import { DepartmentListPageComponent } from './department-list-page/department-list-page.component';
import { LogInPageComponent } from './log-in-page/log-in-page.component';
import { EditFacultyListItemComponent } from './edit-faculty-list-item/edit-faculty-list-item.component';

const routes: Routes = [
  {path: 'home-page-component', component: HomePageComponent},
  {path: 'course-list-page-component', component: CoursesListPageComponent},
  {path: 'register-page-component', component: RegisterPageComponent},
  {path: 'faculty-list-page-component', component: FacultyListPageComponent},
  {path: 'department-list-page-component', component: DepartmentListPageComponent},
  {path: 'log-in-page-component', component: LogInPageComponent},
  {path: 'edit-faculty-list-item-component', component: EditFacultyListItemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
