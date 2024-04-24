import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const baseUrl:string="http://localhost:3000/clients/";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient: HttpClient) { }


  save(client :any){

    return this.httpClient.post(baseUrl,client);
  }
}
