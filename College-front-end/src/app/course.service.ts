import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from './course';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class CourseService {


  private courseUrl: string;

  constructor(private http: HttpClient) { 
    this.courseUrl = 'http://localhost:8080/api/course';
  }

  public findAll(): Observable<Course[]> {
    return this.http.get<Course[]>(this.courseUrl + "/all");
  }

  public findById(id: number): Observable<Course> {
    return this.http.get<Course>(this.courseUrl + id);
  }

  public addCourse(Course: Course): void {
    this.http.post<Course>(this.courseUrl + "/add", Course)
    .subscribe(
      data => {
        console.log("Course added successfully", data);
      },
      error => {
        console.error("Error adding Course", error);
      }
    );  
  }

    public updateCourse(id: number, course: Course): void {
      this.http.put<Course>(this.courseUrl + "/update/" + id, course)
      .subscribe(
        data => {
          console.log("Course updated successfully", data);
        },
        error => {
          console.error("Error updating Course", error);
        }
      );
    }

    public deleteCourse(id: number, course: Course): void {
        this.http.delete<Course>(this.courseUrl + "/delete/" + id)
        .subscribe(
          data => {
            console.log("Course updated successfully", data);
          },
          error => {
            console.error("Error updating Course", error);
          }
        );
      }

      public getStudents(id:number):Observable<Student[]>{
        return this.http.get<Student[]>(this.courseUrl + '/' + id + '/' + "students");
      }
    
 }
