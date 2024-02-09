import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TravelFormComponent } from '../travel-form/travel-form.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    TravelFormComponent
    ],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  // Vous pouvez ajouter des propriétés et méthodes nécessaires ici
}