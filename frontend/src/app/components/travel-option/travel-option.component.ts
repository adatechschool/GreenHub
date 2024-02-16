import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TravelOption } from '../../models/travel-option.model';

@Component({
  selector: 'app-travel-option',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './travel-option.component.html',
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