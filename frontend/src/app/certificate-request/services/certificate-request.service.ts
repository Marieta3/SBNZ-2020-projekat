import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { RequestData } from 'src/app/models/request.data.model';
import { BaseService } from 'src/app/shared/services/base.service';
import { RequestResponse } from 'src/app/models/request.response.model';
import { element } from 'protractor';

const ENDPOINTS = {
  GET_ALL: '/organisation/request',
  ANSWER_REQUEST: '/organisation/confirmRequest',
};


@Injectable({
  providedIn: 'root'
})
export class CertificateRequestService extends BaseService {

  constructor(private http: HttpClient) {
    super();
   }

  getAll(): Observable<RequestData[]> {
    return this.http.get(`${this.baseUrl}${ENDPOINTS.GET_ALL}`)
      .pipe(
        map((res: any) =>  {
          const organisations: RequestData[] = [];
          for (let element of res) {
            const req = new RequestData().deserialize(element);
            if (!(req.approved || req.declined)){
              organisations.push(element);
            }
          }
          return organisations;
        })
      );
  }

  answer(data: RequestResponse): Observable<void> {
    return this.http.post(`${this.baseUrl}${ENDPOINTS.ANSWER_REQUEST}`, data).pipe(
      map((res: any) => {
        return;
      })
    );
  }
}
