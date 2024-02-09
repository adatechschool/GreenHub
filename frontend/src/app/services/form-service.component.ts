import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { GlobalTravelOption } from '../models/travel-option.model';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  private apiUrl = 'http://localhost:8080/api/post'; // Remplacez par l'URL de votre backend

  globalTravelOptions: GlobalTravelOption[] = [];

  constructor(private http: HttpClient) { }

  // Méthode pour envoyer les données du formulaire
  submitForm(formData: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, formData).pipe(
      catchError(error => {
        // Gérer les erreurs ici si nécessaire
        throw 'Erreur lors de l\'envoi des données du formulaire';
      })
    );
  }

  setGlobalTravelOptions(options: GlobalTravelOption[]) {
    this.globalTravelOptions = options;
  }
  
  getGlobalTravelOptions() {
    return this.globalTravelOptions;
  }
}
