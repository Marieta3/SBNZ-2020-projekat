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
    });
  }

  onAddFruitSubmit(){
    console.log('ON ADD fruit');
    const name: string = this.addFruitForm.get('name').value;
    const opis: string = this.addFruitForm.get('opis').value;
    let fruit: Fruit = new Fruit(name, opis);
    this.fruitService.addFruit(fruit);
  }

}
