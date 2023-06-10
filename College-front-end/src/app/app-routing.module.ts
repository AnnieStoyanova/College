import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { LogInPageComponent } from './log-in-page/log-in-page.component';


const routes: Routes = [
  {path: 'home-page-component', component: HomePageComponent},
  {path: 'register-page-component', component: RegisterPageComponent},
  {path: 'log-in-page-component', component: LogInPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
