import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TravelFormModule } from '../travel-form/travel-form.module';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    TravelFormModule
    ],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  // Vous pouvez ajouter des propriétés et méthodes nécessaires ici
}