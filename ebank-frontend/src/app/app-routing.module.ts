import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ClientsComponent } from './clients/clients.component';
import { ComptesComponent } from './comptes/comptes.component';
import {OperationComponent} from "./operation/operation.component";
import {DashboardComponent} from "./dashboard/dashboard.component";

const routes: Routes = [
  {path:'home',component :HomeComponent

        ,children :[
          {path:'clients',component :ClientsComponent}
          ,
          {path:'comptes',component :ComptesComponent}
          ,
          {path:'operations',component :OperationComponent}
          ,
          {path:'dashboards',component :DashboardComponent}
        ]
}
  ,
  {path :'login' , component : LoginComponent}
  ,
  {path:'',component :LoginComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
