import { Component, OnInit } from '@angular/core';
import { CertificateRequestService } from '../../services/certificate-request.service';
import { RequestData } from 'src/app/models/request.data.model';
import { MatTableDataSource } from '@angular/material/table';
import { RequestResponse } from 'src/app/models/request.response.model';


@Component({
  selector: 'app-requests-list',
  templateUrl: './requests-list.component.html',
  styleUrls: ['./requests-list.component.scss']
})
export class RequestsListComponent implements OnInit {

  requests: RequestData[];

  dataSource: MatTableDataSource<RequestData>;
  
  constructor(
    private certificateRequestService: CertificateRequestService,
    ) {}

  ngOnInit(): void {
    this._getData();
  }

  _getData(){
    this.certificateRequestService.getAll().subscribe((requestDatas: RequestData[]) => {
      if (requestDatas != null) {
        this.requests = requestDatas;
        this.initializeDataSource();
      }
    });
  }

  initializeDataSource() {
    this.dataSource  = new MatTableDataSource<RequestData>();
    this.dataSource.data = this.requests || [];
  }

  getDisplayedColumns(){
    return ['index', 'holderName', 'organisation', 'organisationUnit', 'country', 'uniqueIdentifier', 'options'];
  }

  answerRequest(idRequest: number, answer: boolean){
    const requestResponse: RequestResponse = new RequestResponse();
    requestResponse.requestId = idRequest;
    requestResponse.confirmed = answer;

    this.certificateRequestService.answer(requestResponse).subscribe(() => {
      this._getData();
    });
  }
}
