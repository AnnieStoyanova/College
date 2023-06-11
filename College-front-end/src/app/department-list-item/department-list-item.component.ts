import { Component } from '@angular/core';
import { Department } from '../department';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-department-list-item',
  templateUrl: './department-list-item.component.html',
  styleUrls: ['./department-list-item.component.css']
})
export class DepartmentListItemComponent {
  departments: Department[] = [];

  constructor(private departmentService: DepartmentService) {}

  ngOnInit(): void{
    this.departmentService.findAll().subscribe(data =>
      this.departments = data
    )
  };
}
