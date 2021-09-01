import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { API_URL } from 'src/app/app.constants';

export class HelloWorldBean{
  constructor(public message:string){

  }
}

@Injectable({
  providedIn: 'root'
})
export class WeelcomeDataService {

  constructor(
    private http:HttpClient
  ) { }

  executeHelloWorldBeanSevice(){
    return this.http.get<HelloWorldBean>('http://localhost:8080/hello-world-bean');
  }
  executeHalloWorldServiceWithPathVariable(name:any){
    return this.http.get<HelloWorldBean>(`${API_URL}/hello-world/path-veriable/${name}`);
  }
}
