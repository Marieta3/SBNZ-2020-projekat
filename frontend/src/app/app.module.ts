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
import { ListAllFruitComponent } from './fruit/components/list-all-fruit/list-all-fruit.component';
import { FruitDetailsComponent } from './fruit/components/fruit-details/fruit-details.component';
import { AddFruitComponent } from './fruit/components/add-fruit/add-fruit.component';

@NgModule({
  declarations: [
    AppComponent,
    ListAllFruitComponent,
    FruitDetailsComponent,
    AddFruitComponent
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
    BrowserAnimationsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
