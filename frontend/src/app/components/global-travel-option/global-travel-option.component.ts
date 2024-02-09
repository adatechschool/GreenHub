import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GlobalTravelOption } from '../../models/travel-option.model'; 
import { TravelOptionComponent } from '../travel-option/travel-option.component';

@Component({
  selector: 'app-global-travel-option',
  standalone: true,
  imports: [
    CommonModule,
    TravelOptionComponent
  ],
  template: `
  <div class="container">
  <div class="global-travel-option">
  <!-- Image of the city with text overlay -->
  <div class="city-image-container">
  <img [src]="'assets/images/' + globalTravelOption.destination.toLowerCase() + '.jpeg'" alt="{{ globalTravelOption.destination }}">
    <div class="text-overlay">
      <div class="city-name">{{ globalTravelOption.destination }}</div>
      <!-- CO2 quantity below the image -->
      <div class="co2-quantity">CO2: {{ (globalTravelOption.co2Quantity / 1000).toFixed(0) }} kg</div>
    </div>
  </div>
  <!-- Travel information on the right side of the image -->
   <div class="travel-info">
    <h3>Informations de voyage</h3>
    <div class="travel-options">
      <app-travel-option *ngFor="let travelOption of globalTravelOption.globalTravelOption" [travelOption]="travelOption"></app-travel-option>
    </div>
  </div>
</div>
</div>
  `,
  styleUrls: ['./global-travel-option.component.css'],
})
export class GlobalTravelOptionComponent {
  @Input() globalTravelOption!: GlobalTravelOption;
}
