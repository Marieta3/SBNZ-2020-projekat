import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RequestsListComponent } from './components/requests-list/requests-list.component';

const routes: Routes = [{
  path: 'certificateRequests/all',
  component: RequestsListComponent
}];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class CertificateRequestRoutingModule { }