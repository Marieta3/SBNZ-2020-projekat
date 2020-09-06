import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './authentication/login/login.component';
import { ListAllFruitComponent } from './fruit/components/list-all-fruit/list-all-fruit.component';
import { FruitDetailsComponent } from './fruit/components/fruit-details/fruit-details.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'fruit', component: ListAllFruitComponent},
  {path: 'fruit/details/:id', component: FruitDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
