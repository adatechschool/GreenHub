import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { ResultsComponent } from './components/results/results.component';

const routeConfig: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'Home page'
  },
  {
    path: 'about',
    component: AboutComponent,
    title: 'A propos'
  },
  {
    path: 'results',
    component: ResultsComponent,
    title: 'Résultats'
  }
];

export default routeConfig;