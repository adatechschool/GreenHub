import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { GlobalTravelOption } from '../models/travel-option.model';

@Injectable({
  providedIn: 'root'
})
export class ResultsService {
  private _globalTravelOptionsSource = new BehaviorSubject<GlobalTravelOption[]>([]);
  globalTravelOptions$ = this._globalTravelOptionsSource.asObservable();

  constructor() { }

  setGlobalTravelOptions(options: GlobalTravelOption[]) {
    this._globalTravelOptionsSource.next(options);
  }
}
