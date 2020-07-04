import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListAllCertifiacesComponent } from './components/list-all-certifiaces/list-all-certifiaces.component';
import { NewCertifiacesComponent } from './components/new-certifiaces/new-certifiaces.component';
import { RoleGuard } from '../shared/guards/role.guard';

const routes: Routes = [{
  path: 'certificates/all',
  component: ListAllCertifiacesComponent,
  data: {expectedRoles: 'ROLE_ADMIN'},
  canActivate: [RoleGuard]
}, {
  path: 'certificates/new',
  component: NewCertifiacesComponent,
  data: {expectedRoles: 'ROLE_ADMIN'},
  canActivate: [RoleGuard]
}];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class CertificatesRoutingModule { }