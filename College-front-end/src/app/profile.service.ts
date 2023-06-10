import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profile } from './profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private profilesUrl: string;

  constructor(private http: HttpClient) { 
    this.profilesUrl = 'http://localhost:4200/api/profiles';
  }

  public findAll(): Observable<Profile[]> {
    return this.http.get<Profile[]>(this.profilesUrl);
  }

  public findById(id: number): Observable<Profile> {
    return this.http.get<Profile>(this.profilesUrl + '/' + id);
  }

  public findByEmail(email: string): Observable<Profile> {
    return this.http.get<Profile>(this.profilesUrl + '/byEmail/' + email);
  }

  public addProfile(profile: Profile): void {
    this.http.post<Profile>(this.profilesUrl + "/add", profile)
    .subscribe(
      data => {
        console.log("Profile added successfully", data);
      },
      error => {
        console.error("Error adding profile", error);
      }
    );  }

  public updateProfile(id: number, profile: Profile): void {
    this.http.put<Profile>(this.profilesUrl + "/update/" + id, profile)
    .subscribe(
      data => {
        console.log("Profile updated successfully", data);
      },
      error => {
        console.error("Error updating profile", error);
      }
    );
  }

  
}
