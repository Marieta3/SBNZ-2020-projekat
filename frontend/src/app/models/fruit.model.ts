import { Deserializable } from './deserializable.model';
export class Fruit implements Deserializable {
  name: string;
  opis: string;
  id: number;
  nadmorskaVisina: number;
  prosecnaGodisnjaTemperatura: number;
  phCategory: string;
  calcCategory: string;
  

constructor(name: string, opis: string, nadmorskaVisina: number, prosecnaGodisnjaTemperatura: number, phCategory: string, calcCategory: string) {
  this.name = name;
  this.opis = opis;
  this.nadmorskaVisina = nadmorskaVisina;
  this.prosecnaGodisnjaTemperatura = prosecnaGodisnjaTemperatura;
  this.phCategory = phCategory;
  this.calcCategory = calcCategory;
}

deserialize(input: any) {
  Object.assign(this, input);
  return this;
}
}