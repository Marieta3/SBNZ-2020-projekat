import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/shared/services/base.service';
import { User } from 'src/app/models/user.model';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Zemljiste } from 'src/app/models/zemljiste.model';
import { Observable } from 'rxjs';


const ENDPOINTS = {
  ZEMLJISTE: '/suggest'
}

@Injectable({
  providedIn: 'root'
})
export class ZemljisteService extends BaseService {

  activeUser: User;
  httpOptions = {
    headers: new HttpHeaders({
      // 'Content-Type':  'application/xml',
      'Response-Type': 'text',
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    })
  };

  constructor(private http: HttpClient, private router: Router) {
    super();
    this.activeUser = JSON.parse(localStorage.getItem('user'));
  }

  send(zemljiste: Zemljiste): Observable<any> {
    return this.http.post(`${this.baseUrl}${ENDPOINTS.ZEMLJISTE}`, zemljiste, this.httpOptions);
  }
}
