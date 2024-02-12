import { Component, OnInit } from '@angular/core';
import { Traveler, City, GlobalTravelOption } from '../../models/travel-option.model';
import { CityService } from '../../services/city-service.component';
import { FormService } from '../../services/form-service.component';
import { Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ResultsService } from '../../services/results.service';

@Component({
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    HttpClientModule
  ],
  selector: 'app-travel-form', 
  templateUrl: './travel-form.component.html',
  styleUrls: ['./travel-form.component.css']
})
export class TravelFormComponent implements OnInit {

  globalTravelOptions: GlobalTravelOption[] = [];
  maxTravelTime: number = 300; // Ajout de la propriété maxTravelTime

  travelers: Traveler[] = [{
    name: '',
    livingCity: { name: 'Sélectionnez une ville', x: 0, y: 0, iataCode: ' ' },
    numberOfTravelers: 1,
    maxTravelTime: this.maxTravelTime, 
    maxBudgetPerPerson: 1000
  }];
  cities: City[] = [];

  constructor(
    private cityService: CityService,
    private formService: FormService,
    private resultsService: ResultsService,
    private router: Router
  ) {}

  ngOnInit() {
    this.cityService.getCities().subscribe(cities => {
      this.cities = cities;
    });
  }

  submitForm() {
    const formData = this.travelers.map(traveler => ({
      name: traveler.name,
      livingCityName: traveler.livingCity.name,
      livingCityX: traveler.livingCity.x,
      livingCityY: traveler.livingCity.y,
      livingCityIataCode: traveler.livingCity.iataCode,
      numberOfTravelers: traveler.numberOfTravelers,
      maxTravelTime: this.maxTravelTime, // Utilisation de maxTravelTime global
      maxBudgetPerPerson: traveler.maxBudgetPerPerson
    }));

    console.log(formData);

    this.formService.submitForm(formData).subscribe(
      (response: GlobalTravelOption[]) => {
        this.resultsService.setGlobalTravelOptions(response); 
        this.router.navigate(['/results']); // Utilisation de this.router.navigate
      },
      error => {
        console.error('Erreur lors de l\'envoi de la requête :', error);
      }
    );
  }

  addTraveler() {
    // Ajouter un nouveau voyageur avec la ville par défaut
    this.travelers.push({
      name: '',
      livingCity: { name: 'Sélectionnez une ville', x: 0, y: 0, iataCode: ' ' },
      numberOfTravelers: 1,
      maxTravelTime: this.maxTravelTime, 
      maxBudgetPerPerson: 1000
    });
  }

  removeTraveler(index: number) {
    this.travelers.splice(index, 1);
  }
}
