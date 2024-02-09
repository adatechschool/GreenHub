import { Injectable } from '@angular/core';
import { GlobalTravelOption } from '../models/travel-option.model';

@Injectable({
  providedIn: 'root',
})
export class TravelOptionService {
  url = 'http://localhost:3000/results';

  async getAllGlobalTravelOptions(): Promise<GlobalTravelOption[]> {
    const data = await fetch(this.url);
    return await data.json() ?? [];
  }
}
