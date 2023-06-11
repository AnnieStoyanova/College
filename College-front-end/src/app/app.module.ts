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
    DepartmentListPageComponent
    
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
