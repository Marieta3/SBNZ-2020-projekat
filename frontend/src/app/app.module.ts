import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule  } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


import { AuthenticationModule } from './authentication/authentication.module';
import { MaterialModule } from './material/material.module';
import { BootstrapModule } from './bootstrap/bootstrap.module';
import { ToastrModule } from 'ngx-toastr';
import { MainModule } from './main/main.module';
import { HttpInterceptorService } from './shared/services/http-interceptor.service';
import { CertificatesModule } from './certificates/certificates.module';
import { CertificateRequestService } from './certificate-request/services/certificate-request.service';
import { CertificateRequestModule } from './certificate-request/certificate-request.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    BootstrapModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ToastrModule.forRoot({
      progressBar: true,
      timeOut: 4000,
      closeButton: true,
      positionClass: 'toast-bottom-right',
      preventDuplicates: true
    }),
    MaterialModule,
    BootstrapModule,
    AuthenticationModule,
    MainModule,
    BrowserAnimationsModule,
    CertificatesModule,
    CertificateRequestModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
