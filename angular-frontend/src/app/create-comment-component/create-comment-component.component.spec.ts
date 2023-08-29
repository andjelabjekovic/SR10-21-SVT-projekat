import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCommentComponentComponent } from './create-comment-component.component';

describe('CreateCommentComponentComponent', () => {
  let component: CreateCommentComponentComponent;
  let fixture: ComponentFixture<CreateCommentComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCommentComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCommentComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
