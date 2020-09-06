import { Deserializable } from './deserializable.model';
export class Fruit implements Deserializable {
  name: string;
  id: number;
  opis: string;

  constructor(name: string, opis: string) {
    this.name = name;
    this.opis = opis;
  }

  deserialize(input: any) {
    Object.assign(this, input);
    return this;
  }
}