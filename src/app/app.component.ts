import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ServiceService } from './service.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-file-upload-download';

  constructor(private service:ServiceService){}
  ngOnInit(): void {
    this.getAllUsers();
  }
  getAllUsers(){
    this.service.getAllUsers().subscribe(data=>{
      console.log("data=>",data)
    })
  }
}


