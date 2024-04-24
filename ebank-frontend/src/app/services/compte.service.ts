import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CompteService {


  constructor(private http: HttpClient) { }

  getJsonData(): Observable<any> {
    return this.http.get<any>('http://localhost:3000/comptes');
  }
}
