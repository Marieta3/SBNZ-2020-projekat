import { Component, OnInit } from '@angular/core';
import { Fruit } from 'src/app/models/fruit.model';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { FruitService } from '../../services/fruit.service';

@Component({
  selector: 'app-list-all-fruit',
  templateUrl: './list-all-fruit.component.html',
  styleUrls: ['./list-all-fruit.component.scss']
})
export class ListAllFruitComponent implements OnInit {

  fruit: Fruit[];

  dataSource: MatTableDataSource<Fruit>;

  constructor(
    private fruitService: FruitService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this._getData();
  }

  _getData(){
    console.log('getting data');
    this.fruitService.getAll().subscribe((res: Fruit[]) => {
      if (res != null) {
        this.fruit = res;
        console.log(res);
        this.initializeDataSource();
      }
    });
  }

  initializeDataSource() {
    this.dataSource  = new MatTableDataSource<Fruit>();
    this.dataSource.data = this.fruit || [];
  }

  getDisplayedColumns(){
    return ['Index', 'Name', 'Details'];
  }

  

}
