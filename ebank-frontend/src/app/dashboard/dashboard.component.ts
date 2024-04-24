import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ClientService} from "../services/client.service";
import {CompteService} from "../services/compte.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{


  listProfiles: any ={ listProfilesFieldTitle:"Liste Profiles " ,idFieldTitle:"Profile ID ", profileNameFieldTitle:"Profile Name "};
  listOperations :any = {listOperationFieldTitle:"Liste Opérations",operationIDFieldTitle:"Opération ID  ",operationDateFieldTitle:"Date Opération ",typeOperationFieldTitle:"Type Opération :"};
  listComptes : any ={listComptesFieldTitle:"liste Comptes",compteIDFieldTitle:"Compte ID",soldeFieldTitle:"Solde ",ribFieldTitle:"RIB", userIdFieldTitle:"USER ID", statusFieldTitle:"status"};



  listeClients :Array<any>=[];
  userIdFieldTitle: any = "User ID";
  nomFieldTitle: string = "Nom  ";
  prenomFieldTitle: string = "Prénom ";
  loginFieldTitle: string = "Login  ";
  passwordFieldTitle: string = "Password ";
  passwordValidationFieldTitle: string = "Password validation  ";
  dateAnniversaireFieldTitle: string = "Date Anniversaire  ";
  adresseMmailFieldTitle: string = "Adresse mail  ";
  adressePostaleFieldTitle: string = "Adresse Postale";
  numeroIdentiteFieldTitle: string = "Numéro Identité ";

  options :Array<any>=[];
  constructor(private httpClient:HttpClient
    ,private formBuilder :FormBuilder,
              private clientService:ClientService, private jsonDataService: CompteService ){

  }
  ngOnInit() {
    this.jsonDataService.getJsonData().subscribe(data => {
      this.options = data;
    });
    this.initClientForm();
    this.chargerListClients();

  }
  clientFormGroup! : FormGroup;
  initClientForm(){
    this.clientFormGroup= this.formBuilder.group(
      {
        userIdClient:this.formBuilder.control("",Validators.required),
        nomClient:this.formBuilder.control("",Validators.required),
        prenomClient:this.formBuilder.control("",Validators.required),
        loginClient: this.formBuilder.control("",Validators.required),
        passwordClient: this.formBuilder.control("",Validators.required),
//passwordValidationClient : this.formBuilder.control("",Validators.required),
        profileClient :this.formBuilder.control("",Validators.required),
        dateAnniversaireClient: this.formBuilder.control("",Validators.required),
        adresseMmailClient : this.formBuilder.control("",Validators.required),
        adressePostaleClient:  this.formBuilder.control("",Validators.required),
        numeroIdentiteClient:this.formBuilder.control("",Validators.required),

      }
    )

  }
//nomClient :string ="";
  creerNouveauClient(nouveauClient:any){


    let clientForm = JSON.stringify(nouveauClient.value);

    this.clientService.save(clientForm).subscribe(
      {
        next :reponse => {
          console.log("client bien créer",reponse);
          this.chargerListClients();
        }

        ,
        error :err =>    {
          console.log("Error client création",err)
        }


      }
    )
  }

  chargerListClients(){
    this.httpClient.get<any>(`http://localhost:3000/clients`).subscribe(

      {
        next :reponse => this.listeClients=reponse
        ,error :err =>{
          console.log("Error chargement liste clients")
        }
      }

    )
  }
  chargerListCompte(){
    this.httpClient.get<any>(`http://localhost:3000/clients`).subscribe(

      {
        next :reponse => this.listComptes=reponse
        ,error :err =>{
          console.log("Error chargement liste clients")
        }
      }

    )
  }

}
