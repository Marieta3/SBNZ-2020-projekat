import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './authentication/login/login.component';
import { ListAllFruitComponent } from './fruit/components/list-all-fruit/list-all-fruit.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'fruit', component: ListAllFruitComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
