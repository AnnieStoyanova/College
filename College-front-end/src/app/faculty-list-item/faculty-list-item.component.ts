import { Component } from '@angular/core';
import { Faculty } from '../faculty';
import { FacultyService } from '../faculty.service';

@Component({
  selector: 'app-faculty-list-item',
  templateUrl: './faculty-list-item.component.html',
  styleUrls: ['./faculty-list-item.component.css']
})
export class FacultyListItemComponent {
  faculties: Faculty[] = [];

  constructor(private facultyService: FacultyService) {}

  ngOnInit(): void{
    this.facultyService.findAll().subscribe(data =>
      this.faculties = data
    )
  };
}
