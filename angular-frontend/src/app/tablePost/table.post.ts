import { Component, OnInit, Input } from '@angular/core';
import { Post} from '../model/post.model';

@Component({
	selector: 'app-table',
	templateUrl: './table.post.html',
	styleUrls: ['./table.post.scss'] //napravila al je prazno ko i njima
})
export class TablePostComponent implements OnInit {
	@Input() posts: Post[];

	constructor() {}

	ngOnInit() {}
}
