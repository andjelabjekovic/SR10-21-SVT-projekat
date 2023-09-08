import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { PostListComponent } from './post-list/post-list.component';
import { GroupListComponent } from './group-list/group-list.component';
import { CreatePostComponent } from './create-post-component/create-post.component';
import { CreateGroupComponent } from './create-group-component/create-group.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { DetailedPostComponent } from './detailed-post/detailed-post.component';
import { DetailedGroupComponent } from './detailed-group/detailed-group.component';
import { MyGroupsComponent } from './my-groups/my-groups.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';

const routes: Routes = [
 
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
  {
    path: 'createGroup',
    component: CreateGroupComponent,
  },
  {
    path: 'myProfile',
    component: MyProfileComponent, 
  },
  {
    path: 'myGroups',
    component: MyGroupsComponent, 
  },
  {
    path: 'detailedPost',
    component: DetailedPostComponent, 
  },
  {
    path: 'detailedGroup',
    component: DetailedGroupComponent, 
  },
  {
    path: 'changePassword',
    component: ChangePasswordComponent,
   
  },
  {
    path: 'editProfile',
    component: EditProfileComponent ,
   
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
