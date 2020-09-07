import { Deserializable } from './deserializable.model';
export class Zemljiste implements Deserializable {
    phVrednost: number;
    kalcijumKarbonat: number;
    region: string;

    constructor(phVrednost: number, kalcijumKarbonat: number, region: string) {
        this.phVrednost = phVrednost;
        this.kalcijumKarbonat = kalcijumKarbonat;
        this.region = region;
    }

    deserialize(input: any) {
        Object.assign(this, input);
        return this;
    }
}