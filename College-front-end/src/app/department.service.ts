import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Department } from './department';
import { Observable } from 'rxjs';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private departmentURL:string

  constructor(private http: HttpClient) { 
    this.departmentURL = 'http://localhost:8080/api/department';
  }

  public findAll(): Observable<Department[]> {
    return this.http.get<Department[]>(this.departmentURL + "/all");
  }

  public findById(id: number): Observable<Department> {
    return this.http.get<Department>(this.departmentURL + '/' + id);
  }

  public addDepartment(department: Department): void {
    this.http.post<Department>(this.departmentURL + "/add", department)
    .subscribe(
      data => {
        console.log("Department added successfully", data);
      },
      error => {
        console.error("Error adding department", error);
      }
    );  }

  public updateDepartment(id: number, department: Department): void {
    this.http.put<Department>(this.departmentURL + "/update/" + id, department)
    .subscribe(
      data => {
        console.log("Department updated successfully", data);
      },
      error => {
        console.error("Error updating department", error);
      }
    );
  }

  public getCourses(id:number):Observable<Course[]>{
    return this.http.get<Course[]>(this.departmentURL + '/' + id + '/' + "courses");
  }
}
