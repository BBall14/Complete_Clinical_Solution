import { Component, OnInit } from '@angular/core';
import { TrailService } from '../service/trail.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


// declare variable to store trailDetails
  trailDetails: any;

   // variable to store test id
   trailId!: string;

    // constructor to inject TrailService, Router and MatSnackBar 
  constructor(private service:TrailService, private snackBar: MatSnackBar,private router: Router) { }


  // on init method to get all trailsDetails by calling getTrails() method of TrailService

  ngOnInit(): void {
    this.service.getTrails().subscribe((data) => {
      console.log(data);
      this.trailDetails = data;
    })
   
  }

 // method to navigate to post page
 update(){
  this.router.navigate(['update']);
}



  getTrail(){
    // call get api
    this.service.getTrailById().subscribe((data) => {
      this.trailDetails = data;
      console.log(this.trailDetails);
    });
  }
  
}
