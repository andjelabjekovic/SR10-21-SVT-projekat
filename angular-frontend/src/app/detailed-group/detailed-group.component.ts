import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService, UserService } from '../service';
import { Subject } from 'rxjs/Subject';
import { takeUntil } from 'rxjs/operators';
import { PostService } from '../service/post.service';
import { Post } from '../model/post.model';
import { Group } from '../model/group.model';
import { GroupService } from '../service/group.service';

@Component({
  selector: 'app-detailed-group',
  templateUrl: './detailed-group.component.html',
  styleUrls: ['./detailed-group.component.css']
})
export class DetailedGroupComponent implements OnInit {

  title = 'View Group';
  form: FormGroup;
  selectedGroup: Group;
 
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private groupService: GroupService
  ) {

  }

  ngOnInit() {
   
    this.selectedGroup = JSON.parse(localStorage.getItem("clickedGroup"));
    this.form = this.formBuilder.group({
      name: [this.selectedGroup.name],
      description: [this.selectedGroup.description]
    });
  }

  onSubmit() {
  
    const updatedPost = {"id": this.selectedGroup.id, "name": this.form.value.name, "description": this.form.value.description}
    this.groupService.updateGroup(updatedPost) 
      .subscribe(data => {
        console.log(data); 
        
        //this.router.navigate([]);
      },
        error => {
         
        });
  }

}
