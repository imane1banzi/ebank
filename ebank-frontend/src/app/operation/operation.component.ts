import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-operation',
  templateUrl: './operation.component.html',
  styleUrls: ['./operation.component.css']
})
export class OperationComponent implements OnInit{


  listeOperations :Array<any>=[ ];

  operationFieldsTitles : any ={listOperationsFieldTitle:"liste Operations",
    operationIDFieldTitle:"operation ID",
    typeoperationFieldTitle:"type",
    montantFieldTitle:"Montant",
    daterealisationFieldTitle :"date" ,
    motifFieldTitle :"motif",
    userIdFieldTitle :"user ID"
  };


  constructor(private httpClient:HttpClient){


  }
  ngOnInit(): void {
    this.httpClient.get<any>(`http://localhost:3000/operations`).subscribe(

      {
        next :reponse => this.listeOperations=reponse
        ,error :err =>{
          console.log("Error charfgement liste Operations")
        }
      }


    )
  }

}
