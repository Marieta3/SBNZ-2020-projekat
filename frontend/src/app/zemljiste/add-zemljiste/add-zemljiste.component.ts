import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ZemljisteService } from '../service/zemljiste.service';
import { Zemljiste } from 'src/app/models/zemljiste.model';

@Component({
  selector: 'app-add-zemljiste',
  templateUrl: './add-zemljiste.component.html',
  styleUrls: ['./add-zemljiste.component.scss']
})
export class AddZemljisteComponent implements OnInit {

  addZemljisteForm: FormGroup;
  //regions = Region[];
  constructor(
    private formBuilder: FormBuilder,
    private zemljisteService: ZemljisteService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.addZemljisteForm = this.formBuilder.group({
      phVrednost: ['', [Validators.required]],
      kalcijumKarbonat: ['', [Validators.required]],
      region: ['', [Validators.required]]
    });
  }

  onAddZemljisteSubmit(){
    console.log('ON ADD zemljiste');
    const phVrednost: number = this.addZemljisteForm.get('phVrednost').value;
    const kalcijumKarbonat: number = this.addZemljisteForm.get('kalcijumKarbonat').value;
    const region: string = this.addZemljisteForm.get('region').value;
    let zemljiste: Zemljiste = new Zemljiste(phVrednost, kalcijumKarbonat, region);
    this.zemljisteService.send(zemljiste);
  }
}
