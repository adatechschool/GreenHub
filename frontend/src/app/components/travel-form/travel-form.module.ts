import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TravelFormComponent } from './travel-form.component';
import { CityService } from '../../services/city-service.component';
import { FormService } from '../../services/form-service.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    TravelFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    HttpClientModule
  ],
  providers: [
    CityService,
    FormService
  ],
  exports: [
    TravelFormComponent
  ]
})
export class TravelFormModule { }