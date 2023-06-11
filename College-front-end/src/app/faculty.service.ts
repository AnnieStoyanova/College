import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Faculty } from './faculty';

@Injectable({
  providedIn: 'root'
})
export class FacultyService {
private facultyURL:string

  constructor(private http: HttpClient) { 
    this.facultyURL = 'http://localhost:8080/api/faculty';
  }

  public findAll(): Observable<Faculty[]> {
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
}
