import { Component, OnInit } from '@angular/core';
import { Fruit } from 'src/app/models/fruit.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FruitService } from '../../services/fruit.service';

@Component({
  selector: 'app-fruit-details',
  templateUrl: './fruit-details.component.html',
  styleUrls: ['./fruit-details.component.scss']
})
export class FruitDetailsComponent implements OnInit {
  fruitId: string;
  fruit: Fruit;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fruitService: FruitService
  ) { 
    this.fruit = new Fruit('', '', 0, 0, '', '');
    this.fruit.name = '';
    this.fruit.opis = '';
  }

  ngOnInit(): void {
    this.fruitId = this.route.snapshot.paramMap.get('id');
    this.getFruit();
  }

  getFruit(){
    this.fruitService.getDetails(this.fruitId).subscribe(
      success => {
          this.fruit = success;
      })
  }

}
