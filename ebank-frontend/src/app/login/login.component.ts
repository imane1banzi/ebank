import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  implements OnInit {
  ngOnInit(): void {
   // console.log("Hello")
  }
constructor(private authenticationService :AuthenticationService,private router: Router){

}


/*  login(){
    this.authenticationService.login()
    .subscribe({
      next : response => {
    console.log(response)
    // this.router.navigate(['/myPath']);
    }
  });
    console.log("Go to login page from component");
  }*/
  login(){
   
   // console.log("Go to login page from component");
    this.router.navigate(['/home']);
  }

 

}
