import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/shared/services/base.service';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { OrganisationData } from 'src/app/models/organistation.data.model';

const ENDPOINTS = {
  GET_ALL: '/organisation',
  CREATE: '/organisation',
  REVOKE: (id: string) => `/organisation/revoke/${id}`
}



@Injectable({
  providedIn: 'root'
})
export class CertificateService extends BaseService{

  constructor(private http: HttpClient) {
    super();
   }


   getAll(): Observable<OrganisationData[]> {
    return this.http.get(`${this.baseUrl}${ENDPOINTS.GET_ALL}`)
      .pipe(
        map((res: any) =>  {
          var organisations: OrganisationData[] = res.map(element => {
            return new OrganisationData().deserialize(element);
          });
          return organisations;
        })
      );
  }

  create(data: OrganisationData): Observable<OrganisationData> {
    return this.http.post(`${this.baseUrl}${ENDPOINTS.CREATE}`, data).pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  revoke(id: string): Observable<OrganisationData> {
    const organisationData = new OrganisationData();
    return this.http.put(`${this.baseUrl}${ENDPOINTS.REVOKE(id)}`, organisationData ).pipe(
      map((res: any) => {
        const manifestation = res;
        return manifestation;
      })
    );
  }
}
