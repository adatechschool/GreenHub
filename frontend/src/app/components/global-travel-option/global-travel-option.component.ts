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
  templateUrl: './global-travel-option.component.html',
  styleUrls: ['./global-travel-option.component.css'],
})
export class GlobalTravelOptionComponent {
  @Input() globalTravelOption!: GlobalTravelOption;
}
