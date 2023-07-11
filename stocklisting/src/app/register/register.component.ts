import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { TrailService } from '../service/trail.service';
import { Form, FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
// declare username and password variables
username!: string;
password!: string;
// declare errorMessage variable
errorMessage!: string;



  constructor(private router:Router, private service:TrailService) { }
 
  ngOnInit(){
  }

// call register api and navigate to login page
register() {

  this.service.register(this.username, this.password).subscribe((data) => {
    console.log(data);
    this.router.navigate(['/login']);
  },
  // if error occurs, display error message
  (error: HttpErrorResponse) => {
    if (error.status === 409) {
      this.errorMessage = 'Invalid';
    } else {
      this.errorMessage = 'An error occurred. Please try again later.';
    }
  }
);
}
}
