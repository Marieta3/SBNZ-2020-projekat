import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RequestsListComponent } from './components/requests-list/requests-list.component';
import { CertificateRequestRoutingModule } from './certificate-request-routing.module';
import { MaterialModule } from '../material/material.module';



@NgModule({
  declarations: [RequestsListComponent],
  imports: [
    CommonModule,
    MaterialModule,
    CertificateRequestRoutingModule
  ]
})
export class CertificateRequestModule { }
