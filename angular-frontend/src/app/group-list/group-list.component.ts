import { Component, OnInit, Input } from '@angular/core';
import { Group } from '../model/group.model';
import { GroupService } from '../service/group.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-group-list',
	templateUrl: './group-list.component.html',
	styleUrls: ['./group-list.component.scss']
})
export class GroupListComponent implements OnInit {
	pageSize: number;
	currentPage: number;
	totalSize: number;
	groupList: Group[];
	displayedColumns: string[] = ['name', 'description', 'creationDate'];

	constructor(
		private groupService: GroupService ,
		
		private router: Router
	) {
		this.pageSize = 5;
		this.currentPage = 1;
		this.totalSize = 1;
	}

	changePage(newPage: number) {
		
	}

	ngOnInit() {
		this.groupService.getGroups().subscribe(
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
