import { Component } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from '../course';
import { CoursesListItemComponent } from '../courses-list-item/courses-list-item.component';



@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  courses = [
    { name: 'Mathematics', teacher: 'John Doe', date: 'Tuesday 9:40' },
    { name: 'Physics', teacher: 'Jane Smith', date: 'Monday 11:20' },
    { name: 'History', teacher: 'Mike Johnson', date: 'Wednesday 11:20' },
  ];
}
