import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PostComponent } from './post/post.component';
import { UpdateComponent } from './update/update.component';

// define routes to navigate between components
// path: '' is the default route to the register component
// path: 'register' is the route to the register component
// path: 'login' is the route to the login component
// path: 'home' is the route to the home component
// pth: 'post' is the route to the post component
// path: 'update' is the route to the update component



const routes: Routes = [
  { path: '', component: RegisterComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home',component: HomeComponent },
  { path: 'post',component: PostComponent},
  { path: 'update',component: UpdateComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
