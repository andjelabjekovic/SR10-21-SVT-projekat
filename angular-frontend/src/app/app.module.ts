import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { CardComponent } from './card/card.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { UserMenuComponent } from './user-menu/user-menu.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { PostListComponent } from './post-list/post-list.component';
import { TablePostComponent } from './tablePost/table.post';
import { TableGroupComponent } from './tableGroup/table.group'; //ovo
import { GroupListComponent } from './group-list/group-list.component';
import { CreatePostComponent } from './create-post-component/create-post.component';

import {AngularMaterialModule} from './angular-material/angular-material.module';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {ApiService} from './service/api.service';
import {ClubService} from './service/club.service';
import {AuthService} from './service/auth.service';
import {UserService} from './service/user.service';
import {ConfigService} from './service/config.service';
import { PostService } from './service/post.service';
import { GroupService } from './service/group.service'; //ovo

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './interceptor/TokenInterceptor';
import { CreateGroupComponent } from './create-group-component/create-group.component';
import { DetailedPostComponent } from './detailed-post/detailed-post.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { DetailedGroupComponent } from './detailed-group/detailed-group.component';
import { MyGroupsComponent } from './my-groups/my-groups.component';
import { CreateCommentComponentComponent } from './create-comment-component/create-comment-component.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    HomeComponent,
    HeaderComponent,
    UserMenuComponent,
    LoginComponent,
    SignUpComponent, 
    PostListComponent,
    TablePostComponent,
    TableGroupComponent, 
    GroupListComponent,
    CreatePostComponent,
    CreateGroupComponent,
    DetailedPostComponent,
    DetailedGroupComponent,
    MyProfileComponent,
    MyGroupsComponent,
    CreateCommentComponentComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NoopAnimationsModule,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [ 
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    ClubService,
    PostService,
    GroupService, //ovo
    AuthService,
    ApiService,
    UserService,
    ConfigService
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
