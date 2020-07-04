import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OrganisationData } from 'src/app/models/organistation.data.model';
import { CertificateService } from '../../services/certificate.service';

@Component({
  selector: 'app-new-certifiaces',
  templateUrl: './new-certifiaces.component.html',
  styleUrls: ['./new-certifiaces.component.scss']
})
export class NewCertifiacesComponent implements OnInit {

  certifactFormGroup: FormGroup;
  organisation: OrganisationData;

  constructor(
    private formBuilder: FormBuilder,
    private certificateService: CertificateService,
    ) { }
  ngOnInit(): void {
    this._initForm();
  }

  _initForm() {
    this.certifactFormGroup = this.formBuilder.group({
      holderName: ['', [Validators.required]],
      organisation: ['', [Validators.required]],
      organisationUnit: ['', [Validators.required]],
      country: ['', [Validators.required]],
      uniqueIdentifier: ['', [Validators.required]],
      holderMail: ['', [Validators.required]],
    });
  }

  onFormSubmit(){
    const data = new OrganisationData();
    data.holderName = this.certifactFormGroup.get('holderName').value;
    data.holderMail = this.certifactFormGroup.get('holderMail').value;
    data.country = this.certifactFormGroup.get('country').value;
    data.organisation = this.certifactFormGroup.get('organisation').value;
    data.organisationUnit = this.certifactFormGroup.get('organisationUnit').value;
    data.uniqueIdentifier = this.certifactFormGroup.get('uniqueIdentifier').value;

    this.certificateService.create(data).subscribe(() => {
      this._initForm();
    });
  }

}
