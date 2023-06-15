import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradeListItemComponent } from './grade-list-item.component';

describe('GradeListItemComponent', () => {
  let component: GradeListItemComponent;
  let fixture: ComponentFixture<GradeListItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradeListItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GradeListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
