import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppComponent } from '../app.component';
import { WeelcomeDataService } from '../service/data/weelcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  message="cao druze"
  welcomeMessageFromService='';
  name='';

  constructor(private route:ActivatedRoute,
    private service:WeelcomeDataService) { }

  ngOnInit(): void {
    console.log(this.message)
    this.name=this.route.snapshot.params['name']
  }

  getWelcomeMessage(){

    this.service.executeHelloWorldBeanSevice().subscribe(
      response=>this.handleSuccessfulResponse(response),
      error=>this.handleErrorResponse(error)
      

    
    );

  }

  handleSuccessfulResponse(response:any){
    this.welcomeMessageFromService=response.message;
  }

  handleErrorResponse(error :any){
    
    
    this.welcomeMessageFromService=error.error.message;
    
  }
  getWelcomeMessageWithParametar(){

    this.service.executeHalloWorldServiceWithPathVariable(this.name).subscribe(
      response=>this.handleSuccessfulResponse(response),
      error=>this.handleErrorResponse(error)
      

    
    );

  }
}
