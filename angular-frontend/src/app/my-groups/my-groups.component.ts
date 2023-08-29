import { Component, OnInit } from '@angular/core';
import { Group } from '../model/group.model';
import { GroupService } from '../service/group.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-my-groups',
  templateUrl: './my-groups.component.html',
  styleUrls: ['./my-groups.component.css']
})
export class MyGroupsComponent implements OnInit {
  pageSize: number;
	currentPage: number;
	totalSize: number;
	groupList: Group[];
	displayedColumns: string[] = ['name', 'description'];
  constructor(
    private groupService: GroupService,
		private router: Router
  ) { 
    this.pageSize = 5;
		this.currentPage = 1;
		this.totalSize = 1;
		
  }
  
	changePage(newPage: number) {
		
	}

  ngOnInit() {
    this.groupService.getGroupsForLogged().subscribe(
			res => {
				this.groupList = res as Group[];
			}
		);
  }
  onGroupClick(group) {
    
		localStorage.setItem("clickedGroup", JSON.stringify(group));
		this.router.navigate(["/detailedGroup"]);	
	
	}

}
