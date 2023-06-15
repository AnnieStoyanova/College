import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradeListPageComponent } from './grade-list-page.component';

describe('GradeListPageComponent', () => {
  let component: GradeListPageComponent;
  let fixture: ComponentFixture<GradeListPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradeListPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GradeListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
