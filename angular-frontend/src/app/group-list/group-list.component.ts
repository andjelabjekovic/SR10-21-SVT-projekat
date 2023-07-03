import { Component, OnInit, Input } from '@angular/core';
import { Group } from '../model/group.model';
import { GroupService } from '../service/group.service';

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

	constructor(
		private groupService: GroupService 
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
}
