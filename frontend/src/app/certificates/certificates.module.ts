import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListAllCertifiacesComponent } from './components/list-all-certifiaces/list-all-certifiaces.component';
import { CertificatesRoutingModule } from './certificates-routing.module';
import { NewCertifiacesComponent } from './components/new-certifiaces/new-certifiaces.component';
import { MaterialModule } from '../material/material.module';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [ListAllCertifiacesComponent, NewCertifiacesComponent],
  imports: [
    CommonModule,
    CertificatesRoutingModule,
    MaterialModule,
    ReactiveFormsModule,
  ]
})
export class CertificatesModule { }
