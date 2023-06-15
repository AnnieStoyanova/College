import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFacultyPageComponent } from './add-faculty-page.component';

describe('AddFacultyPageComponent', () => {
  let component: AddFacultyPageComponent;
  let fixture: ComponentFixture<AddFacultyPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFacultyPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddFacultyPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
