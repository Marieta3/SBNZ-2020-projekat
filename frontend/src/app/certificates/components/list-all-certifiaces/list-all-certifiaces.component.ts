import { Component, OnInit } from '@angular/core';
import { OrganisationData } from 'src/app/models/organistation.data.model';
import { MatTableDataSource } from '@angular/material/table';
import { CertificateService } from '../../services/certificate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-all-certifiaces',
  templateUrl: './list-all-certifiaces.component.html',
  styleUrls: ['./list-all-certifiaces.component.scss']
})
export class ListAllCertifiacesComponent implements OnInit {

  organisations: OrganisationData[];

  dataSource: MatTableDataSource<OrganisationData>;


  constructor(
    private certificateService: CertificateService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this._getData();
  }

  _getData(){
    this.certificateService.getAll().subscribe((organistationDatas: OrganisationData[]) => {
      if (organistationDatas != null) {
        this.organisations = organistationDatas;
        this.initializeDataSource();
      }
    });
  }

  initializeDataSource() {
    this.dataSource  = new MatTableDataSource<OrganisationData>();
    this.dataSource.data = this.organisations || [];
  }

  getDisplayedColumns(){
    return ['index', 'holderName', 'organisation', 'organisationUnit', 'country', 'uniqueIdentifier', 'delete'];
  }

  redirectToAddNewPage() {
    this.router.navigate(['certificates/new']);
  }

  disable(organisationId){
    this.certificateService.revoke(organisationId).subscribe(() => {
      this._getData();
    });
  }

}
