
export interface ModeOfTransport {
  transportName: string;
  co2PerKilometer: number;
}

export class City {
  name: string;
  x: number;
  y: number;
  iataCode: string;

  constructor(name: string, x: number, y: number, iataCode: string) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.iataCode = iataCode;
  }
}

export interface TravelOption {
  traveler: {
    livingCity: City;
    numberOfTravelers: number;
    name: string;
  };
  trip: {
    departureCity: City;
    arrivalCity: City;
    distance: number;
    travelTime: number;
    budgetPerPerson: number;
    modeOfTransport: ModeOfTransport;
    co2: number;
  };
  budgetPerPerson: number;
  co2: number;
}

export interface GlobalTravelOption {
  globalTravelOption: TravelOption[];
  co2Quantity: number;
  destination: string;
}


export interface Traveler {
  name: string;
  livingCity: City;
  numberOfTravelers: number;
  maxTravelTime: number;
  maxBudgetPerPerson: number;
}