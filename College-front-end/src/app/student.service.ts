import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private studentUrl: string;

  constructor(private http: HttpClient) { 
    this.studentUrl = 'http://localhost:8080/api/student';
  }

  public findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentUrl);
  }

  public findById(id: number): Observable<Student> {
    return this.http.get<Student>(this.studentUrl + '/' + id);
  }

  public findByEmail(email: string): Observable<Student> {
    return this.http.get<Student>(this.studentUrl + '/byEmail/' + email);
  }

  public addStudent(student: Student): void {
    this.http.post<Student>(this.studentUrl + "/add", student)
    .subscribe(
      data => {
        console.log("Student added successfully", data);
      },
      error => {
        console.error("Error adding student", error);
      }
    );  }

  public updateStudent(id: number, student: Student): void {
    this.http.put<Student>(this.studentUrl + "/update/" + id, student)
    .subscribe(
      data => {
        console.log("Student updated successfully", data);
      },
      error => {
        console.error("Error updating student", error);
      }
    );
  }
}