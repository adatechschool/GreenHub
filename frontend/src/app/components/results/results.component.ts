import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GlobalTravelOption } from '../../models/travel-option.model';
import { GlobalTravelOptionComponent } from '../global-travel-option/global-travel-option.component';
import { FormService } from '../../services/form-service.component';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-results',
  standalone: true,
  imports: [
    CommonModule,
    GlobalTravelOptionComponent  ],
  template: `
      <section class="results">
        <app-global-travel-option
          *ngFor="let globalTravelOption of globalTravelOptions"
          [globalTravelOption]="globalTravelOption">
        </app-global-travel-option>
       </section>
  `,
  styleUrls: ['./results.component.css'],
})

export class ResultsComponent implements OnInit {
  globalTravelOptions: GlobalTravelOption[] = [];

  constructor(private formService: FormService) { }

  ngOnInit() {
    this.globalTravelOptions = this.formService.getGlobalTravelOptions();
  }
}
