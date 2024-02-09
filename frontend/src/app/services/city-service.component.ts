import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { City } from '../models/travel-option.model';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor() { }

  getCities(): Observable<City[]> {
    const CITY_DATA = [
      { name: 'Marseille', x: 43.3046384916822, y: 5.380587512275412, iata: 'MRS' },
      { name: 'Lyon', x: 45.760673597664514, y: 4.8601696394378235, iata: 'LYS' },
      { name: 'Nantes', x: 47.216453500514525, y: -1.5442302747784624, iata: 'NTE' },
      { name: 'Montpellier', x: 43.611, y: 3.8767, iata: 'MPL' },
      { name: 'Bordeaux', x: 44.82529325038888, y: -0.5562017943285817, iata: 'BOD' },
      { name: 'Lille', x: 50.63917372791329, y: 3.076333755125906, iata: 'LIL' },
      { name: 'Limoges', x: 45.83576, y: 1.26816, iata: 'LIG' },
      { name: 'Dijon', x: 47.32301605689184, y: 5.027142558968659, iata: 'DIJ' },
      { name: 'Toulouse', x: 43.6044622, y: 1.4442469, iata: 'TLS' },
      { name: 'Tours', x: 47.388230866422326, y: 0.6947221708145873, iata: 'TUF' },
      { name: 'La Rochelle', x: 46.15251607685766, y: -1.145160124084134, iata: 'LRH' },
      { name: 'Clermont-Ferrand', x: 45.78391444391321, y: 3.1003471352476315, iata: 'CFE' },
      { name: 'Rennes', x: 48.10311582482322, y: -1.6728812853027912, iata: 'RNS' },
      { name: 'Brest', x: 48.38792979428025, y: -4.479243011743675, iata: 'BES' },
      { name: 'Caen', x: 49.17648361029503, y: -0.3482196689594141, iata: 'CFR' },
      { name: 'Strasbourg', x: 48.58287025395099, y: 7.731594953278422, iata: 'SXB' },
      { name: 'Nancy', x: 48.68970240344171, y: 6.174101796891322, iata: 'NCY' },
      { name: 'Reims', x: 49.23341625390808, y: 4.022706051740367, iata: 'RHE' },
      { name: 'Pau', x: 43.29193281962733, y: -0.369603787755675, iata: 'PUF' },
      { name: 'Perpignan', x: 42.696697424153996, y: 2.8802255331151128, iata: 'PGF' }
    ];

    const cities: City[] = CITY_DATA.map(data => new City(data.name, data.x, data.y, data.iata));
    return of(cities);
  }
}