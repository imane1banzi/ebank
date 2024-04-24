
import { HttpClient, HttpHeaders } from '@angular/common/http'; 
import { Injectable } from '@angular/core'; 
import { Observable } from 'rxjs';


const headerDict = {

  'Access-Control-Allow-Origin': 'Allow',
}
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  
  private url = 'http://jsonplaceholder.typicode.com/posts';
  private baseUrl = "http://localhost:1988/ebank";

  constructor(private http: HttpClient) { }


 

  login():Observable<any> {
    //console.log("Service login");
      //return this.http.get("http://localhost:8000/ebank/login",{headers: new HttpHeaders(headerDict)});
      return this.http.get("http://localhost:8000/ebank/login");
 
  }

 
}
