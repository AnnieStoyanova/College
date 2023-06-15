import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Teacher } from './teacher';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  private teacherUrl: string;

  constructor(private http: HttpClient) { 
    this.teacherUrl = 'http://localhost:8080/api/teacher';
  }

  public findAll(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>(this.teacherUrl);
  }

  public findById(id: number): Observable<Teacher> {
    return this.http.get<Teacher>(this.teacherUrl + '/' + id);
  }

  public findByEmail(email: string): Observable<Teacher> {
    return this.http.get<Teacher>(this.teacherUrl + '/byEmail/' + email);
  }

  public addTeacher(teacher: Teacher): void {
    this.http.post<Teacher>(this.teacherUrl + "/add", teacher)
    .subscribe(
      data => {
        console.log("Teacher added successfully", data);
      },
      error => {
        console.error("Error adding teacher", error);
      }
    );  }

  public updateTeacher(id: number, teacher: Teacher): void {
    this.http.put<Teacher>(this.teacherUrl + "/update/" + id, teacher)
    .subscribe(
      data => {
        console.log("Teacher updated successfully", data);
      },
      error => {
        console.error("Error updating teacher", error);
      }
    );
  }
}
