import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comptes',
  templateUrl: './comptes.component.html',
  styleUrls: ['./comptes.component.css']
})
export class ComptesComponent implements OnInit{

  listeComptes :Array<any>=[ ];

compteFieldsTitles : any ={listComptesFieldTitle:"liste Comptes",
  compteIDFieldTitle:"Compte ID",
  soldeFieldTitle:"Solde",
  ribFieldTitle:"RIB",
  userIdFieldTitle :"User ID" ,
  statusFieldTitle :"Status"};


  constructor(private httpClient:HttpClient){


  }
  ngOnInit(): void {
    this.httpClient.get<any>(`http://localhost:3000/comptes`).subscribe(

    {
      next :reponse => this.listeComptes=reponse
      ,error :err =>{
        console.log("Error charfgement liste Comptes")
      }
    }


    )

}
}
