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
  name=''

  constructor(private route:ActivatedRoute,
    private service:WeelcomeDataService) { }

  ngOnInit(): void {
    console.log(this.message)
    this.name=this.route.snapshot.params['name']
  }

  getWelcomeMessage(){
    //console.log(this.service.executeHelloWorldBeanSevice());

    this.service.executeHelloWorldBeanSevice().subscribe(
      response=>this.hadleSuccessfulResponse(response),
      error=>this.hadleSuccessfulResponse(error)
      

    
    );
   // console.log('last line of getWwlcomeMessage');
//console.log('get welcome message');

  }

  hadleSuccessfulResponse(response:any){
    this.welcomeMessageFromService=response.message;
    // console.log(response);
    // console.log(response.message);
  }

  handleErrorResponse(error :any){
    
    
    this.welcomeMessageFromService=error.error.message;
    
  }
  getWelcomeMessageWithParametar(){
    //console.log(this.service.executeHelloWorldBeanSevice());

    this.service.executeHalloWorldServiceWithPathVariable(this.name).subscribe(
      response=>this.hadleSuccessfulResponse(response),
      error=>this.hadleSuccessfulResponse(error)
      

    
    );
   // console.log('last line of getWwlcomeMessage');
//console.log('get welcome message');

  }
}
