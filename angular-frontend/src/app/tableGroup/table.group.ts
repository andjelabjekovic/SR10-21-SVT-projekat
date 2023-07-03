import { Component, OnInit, Input } from '@angular/core';
import { Group } from '../model/group.model';

@Component({
	selector: 'app-table-group',
	templateUrl: './table.group.html',
	styleUrls: ['./table.group.scss']
})              
export class TableGroupComponent implements OnInit {
	@Input() groups: Group[];

	constructor() {}

	ngOnInit() {}
}
