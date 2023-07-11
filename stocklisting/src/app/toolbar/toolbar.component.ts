import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  //  constructor to inject Router
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  //  method to navigate to home page
  returnHome(){ 
    this.router.navigate(['home']);
  }

//  method to navigate to wishlist page
  register(){
    this.router.navigate(['register']);
  }

  // method to navigate to post page
  postTrail(){
    this.router.navigate(['post']);
  }

}
