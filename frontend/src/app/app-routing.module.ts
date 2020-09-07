import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './authentication/login/login.component';
import { ListAllFruitComponent } from './fruit/components/list-all-fruit/list-all-fruit.component';
import { FruitDetailsComponent } from './fruit/components/fruit-details/fruit-details.component';
import { AddFruitComponent } from './fruit/components/add-fruit/add-fruit.component';
import { RoleGuard } from './shared/guards/role.guard';
import { AddZemljisteComponent } from './zemljiste/add-zemljiste/add-zemljiste.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'fruit', component: ListAllFruitComponent},
  {path: 'fruit/details/:id', component: FruitDetailsComponent},
  {
    path: 'fruit/add',
    component: AddFruitComponent,
    canActivate: [RoleGuard],
    data: {expectedRoles: 'ROLE_ADMIN'}
  },
  {
    path: 'zemljiste/add',
    component: AddZemljisteComponent,
    canActivate: [RoleGuard],
    data: {expectedRoles: 'ROLE_USER'}
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
