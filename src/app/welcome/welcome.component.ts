import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppComponent } from '../app.component';
import { WeelcomeDataService } from '../service/data/weelcome-data.service';
import { OwlOptions } from 'ngx-owl-carousel-o';

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

url="./assets/profile-avatar.jpg"


onSelectFile(e:any){
  if(e.target.files){
    var reader = new FileReader();
    reader.readAsDataURL(e.target.files[0]);
    reader.onload=(event:any)=>{
      this.url = event.target.result;
    }
  }
}

customOptions: OwlOptions = {
  loop: true,
  mouseDrag: true,
  touchDrag: true,
  pullDrag: true,
  dots: true,
  navSpeed: 700,
  navText: ['', ''],
  responsive: {
    0: {
      items: 1
    },
    400: {
      items: 2
    },
    740: {
      items: 3
    },
    940: {
      items: 2
    }
  },
  nav: true
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
