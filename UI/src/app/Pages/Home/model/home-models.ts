export interface VenueModel
  {
    id: string,
    name: string,
    description: string,
    category: string,
    address: string,
    latitude: number,
    longitude: number,
    createdAt: string,
    updatedAt: string,
    owner:User,
    city:City
    area:Area
    suspended: boolean
    services: [],
    bookings: [],
    reviews: [],
  }
  export interface User {
    id: number,
    userName: string,
    email: string,
    firstName: string,
    lastName: string,
    createdAt: string,
    updatedAt: string,
    role: string,
    banned: boolean
}

export interface City{
  id: number,
    name: string,
    state: string,
    country: string
}

export interface Area{
  id: number,
    name: string,
    city: City
  }
