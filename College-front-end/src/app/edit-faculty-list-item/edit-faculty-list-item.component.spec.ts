import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditFacultyListItemComponent } from './edit-faculty-list-item.component';

describe('EditFacultyListItemComponent', () => {
  let component: EditFacultyListItemComponent;
  let fixture: ComponentFixture<EditFacultyListItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditFacultyListItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditFacultyListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
