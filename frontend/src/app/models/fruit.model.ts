import { Deserializable } from './deserializable.model';
export class Fruit implements Deserializable {
  name: string;
  id: number;
  opis: string;

  deserialize(input: any) {
    Object.assign(this, input);
    return this;
  }
}