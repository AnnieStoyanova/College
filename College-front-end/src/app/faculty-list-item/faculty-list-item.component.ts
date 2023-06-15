import { Component } from '@angular/core';
import { Faculty } from '../faculty';
import { FacultyService } from '../faculty.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-faculty-list-item',
  templateUrl: './faculty-list-item.component.html',
  styleUrls: ['./faculty-list-item.component.css']
})
export class FacultyListItemComponent {
  faculties: Faculty[] = [];
  static ID: number;

  constructor(private facultyService: FacultyService, private router: Router) {}

  ngOnInit(): void{

    this.facultyService.findAll().subscribe(data =>
      this.faculties = data
    )
    console.log("In ts");
    console.log(this.faculties);
  };

  getId(id: number): void {
    FacultyListItemComponent.ID = id;
    this.router.navigateByUrl('department-list-page-component');
    console.log(id);
  }

  edit(id:number) {
    FacultyListItemComponent.ID = id;
    this.router.navigateByUrl('edit-faculty-component');
  }

  delete(id:number){
    console.log("delete daculty");
   this.facultyService.deleteFaculty(id);
    window.location.reload();
  }

}
