import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Faculty } from './faculty';
import { Department } from './department';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {
private facultyURL:string

  constructor(private http: HttpClient) { 
    this.facultyURL = 'http://localhost:8080/api/faculty';
  }

  public findAll(): Observable<Faculty[]> {
    console.log("In service")
    return this.http.get<Faculty[]>(this.facultyURL + "/all");
  }

  public findById(id: number): Observable<Faculty> {
    return this.http.get<Faculty>(this.facultyURL + '/' + id);
  }

  public addFaculty(faculty: Faculty): void {
    this.http.post<Faculty>(this.facultyURL + "/add", faculty)
    .subscribe(
      data => {
        console.log("Faculty added successfully", data);
      },
      error => {
        console.error("Error adding faculty", error);
      }
    );  }

  public updateFaculty(id: number, faculty: Faculty): void {
    this.http.put<Faculty>(this.facultyURL + "/update/" + id, faculty)
    .subscribe(
      data => {
        console.log("Faculty updated successfully", data);
      },
      error => {
        console.error("Error updating faculty", error);
      }
    );
  }

  public getDepartments(id:number):Observable<Department[]>{
    return this.http.get<Department[]>(this.facultyURL + '/' + id + '/' + "departments");
  }

  public deleteFaculty(id:number): void{
    console.log("in faculty service");
    this.http.delete<Faculty>(this.facultyURL + '/' + id).subscribe(
      (response) => {
        // Handle the response if needed
        console.log("Faculty deleted successfully");
      },
      (error) => {
        // Handle the error if any
        console.log("Error deleting faculty:", error);
      }
    );
  }
}
