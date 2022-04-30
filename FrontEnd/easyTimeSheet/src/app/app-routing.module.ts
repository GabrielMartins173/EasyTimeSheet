import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { ConfirmPresenceComponent } from './confirm-presence/confirm-presence.component';
import { ListOfClassroomsComponent } from './list-of-classrooms/list-of-classrooms.component';
import { TeacherDashboardComponent } from './teacher-dashboard/teacher-dashboard.component';
import { FindClassComponent } from './find-class/find-class.component';
import { TeacherClassesComponent } from './teacher-classes/teacher-classes.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'presence', component: ConfirmPresenceComponent },
  { path: 'classrooms', component: ListOfClassroomsComponent },
  { path: 'teacher/dashboard', component: TeacherDashboardComponent },
  { path: 'teacher/classes', component: TeacherClassesComponent},
  { path: 'find/class', component: FindClassComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
