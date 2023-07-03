import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { PostListComponent } from './post-list/post-list.component';
import { GroupListComponent } from './group-list/group-list.component';
import { CreatePostComponent } from './create-post-component/create-post.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignUpComponent,
  },
  {
    path: 'posts',
    component: PostListComponent,
  },
  {
    path: 'groups',
    component: GroupListComponent,
  },
  {
    path: 'createPost',
    component: CreatePostComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
