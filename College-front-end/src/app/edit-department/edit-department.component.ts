import { Component } from '@angular/core';
import { DepartmentService } from '../department.service';
import { NavigationExtras, Router } from '@angular/router';
import { DepartmentListItemComponent } from '../department-list-item/department-list-item.component';

@Component({
  selector: 'app-edit-department',
  templateUrl: './edit-department.component.html',
  styleUrls: ['./edit-department.component.css']
})
export class EditDepartmentComponent {

constructor(private departmentService: DepartmentService, private router:Router){}

department ={
  id:12,
  name:" "
}

edit(name:string){
  this.department ={
    id:DepartmentListItemComponent.ID,
    name:name
  }
  this.departmentService.updateDepartment(DepartmentListItemComponent.ID,this.department);
  const navigationExtras: NavigationExtras = {
    queryParams: { reload: true }
  };
  this.router.navigate(["faculty-list-page-component"], navigationExtras);
}
}
