import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FruitService } from '../../services/fruit.service';
import { Fruit } from 'src/app/models/fruit.model';

@Component({
  selector: 'app-add-fruit',
  templateUrl: './add-fruit.component.html',
  styleUrls: ['./add-fruit.component.scss']
})
export class AddFruitComponent implements OnInit {

  addFruitForm: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private fruitService: FruitService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.addFruitForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      opis: ['', [Validators.required]],
      nadmorskaVisina: [0, [Validators.required]],
      prosecnaGodisnjaTemperatura: [0, [Validators.required]],
      phCategory: ['', [Validators.required]],
      calcCategory: ['', [Validators.required]],
    });
  }

  onAddFruitSubmit(){
    console.log('ON ADD fruit');
    const name: string = this.addFruitForm.get('name').value;
    const opis: string = this.addFruitForm.get('opis').value;
    const nadmorskaVisina: number = this.addFruitForm.get('nadmorskaVisina').value;
    const prosecnaGodisnjaTemperatura: number = this.addFruitForm.get('prosecnaGodisnjaTemperatura').value;
    const phCategory: string = this.addFruitForm.get('phCategory').value;
    const calcCategory: string = this.addFruitForm.get('calcCategory').value;
    let fruit: Fruit = new Fruit(name, opis, nadmorskaVisina, prosecnaGodisnjaTemperatura, phCategory, calcCategory);
    console.log(fruit);
    this.fruitService.addFruit(fruit);
  }

}
