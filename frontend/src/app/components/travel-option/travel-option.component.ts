import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TravelOption } from '../../models/travel-option.model';

@Component({
  selector: 'app-travel-option',
  standalone: true,
  imports: [
    CommonModule
  ],
  template: `
  <div>
  <h4>{{ travelOption.traveler.name }}</h4>
  <ng-container *ngIf="travelOption.trip.departureCity.name === travelOption.trip.arrivalCity.name; else travelDetails">
    <p>Même pas besoin de bouger !</p>
  </ng-container>
  <ng-template #travelDetails>
    <p>{{ formatTravelTime(travelOption.trip.travelTime) }} en {{ formatTransportName(travelOption.trip.modeOfTransport.transportName) }}</p>
    <p>CO2 : {{ formatCO2Quantity(travelOption.trip.co2) }} kg</p>
  </ng-template>
</div>
  `,
  styleUrls: ['./travel-option.component.css'],
})
export class TravelOptionComponent {
  @Input() travelOption!: TravelOption;

  formatTravelTime(minutes: number): string {
    const hours = Math.floor(minutes / 60);
    const remainingMinutes = minutes % 60;
    const formattedMinutes = remainingMinutes.toString().padStart(2, '0');
    return `${hours}h${formattedMinutes}`;
  }

  formatTransportName(transportName: string): string {
    const transportNames: { [key: string]: string } = {
      Car: 'voiture 🚗',
      Train: 'train 🚃',
      Plane: 'avion ✈️',
    };
    return transportNames[transportName] || transportName;
  }

  formatCO2Quantity(co2: number): number {
    return Math.round(co2 / 1000);
  }
}