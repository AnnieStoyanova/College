import { Injectable } from '@angular/core';
import { Course } from './course';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GradeService {
  
  private gradeUrl: string;


  constructor(private http: HttpClient) { 
    this.gradeUrl = 'http://localhost:8080/api/grade';
  }

  public getCourse(id:number):Observable<Course>{
    return this.http.get<Course>(this.gradeUrl +'/getCourse'+ id);
  }
}
