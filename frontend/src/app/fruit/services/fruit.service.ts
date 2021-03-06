import { Injectable } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { BaseService } from 'src/app/shared/services/base.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Fruit } from 'src/app/models/fruit.model';

const ENDPOINTS = {
  FRUIT: '/voce'
}

@Injectable({
  providedIn: 'root'
})
export class FruitService extends BaseService{
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
    this.activeUser = JSON.parse( localStorage.getItem('user'));
  }

  getAll(): Observable<any>{
    return this.http.get(`${this.baseUrl}${ENDPOINTS.FRUIT}`);
  }

  getDetails(id: string): Observable<any>{
    console.log('details');
    console.log(id);
    return this.http.get(`${this.baseUrl}${ENDPOINTS.FRUIT}` + '/id/' + id);
  }

  addFruit(fruit: Fruit): void{
    this.http.post(`${this.baseUrl}${ENDPOINTS.FRUIT}` , fruit, this.httpOptions)
      .subscribe(result => {
        // console.log(result);
        console.log('dodato voce');
        this.router.navigateByUrl('fruit');
      });
  }
}
