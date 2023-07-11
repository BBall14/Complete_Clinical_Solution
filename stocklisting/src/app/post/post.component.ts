import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TrailService } from '../service/trail.service';
import { FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { Trail } from '../model/trail';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  hide: boolean = true;

  // add constructor 
  constructor(private router: Router, private service: TrailService) { }


  trailForm = new FormGroup({
    id: new FormControl(null, Validators.required),
    name: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    duration: new FormControl(null, Validators.required),
    targetPopulation: new FormControl('', Validators.required),
    status: new FormControl('', Validators.required),
  });

  trail: Trail = new Trail();

  ngOnInit(): void {
  }

  // method to submit the form
  onSubmit(formGroupDirective: FormGroupDirective): void {
    this.trail.id = this.trailForm.value.id!;
    this.trail.name = this.trailForm.value.name!;
    this.trail.description = this.trailForm.value.description!;
    this.trail.duration = this.trailForm.value.duration!;
    this.trail.targetPopulation = this.trailForm.value.targetPopulation!;
    this.trail.status = this.trailForm.value.status!;

    console.log(this.trail);

console.log("I m here!!!!!");

    this.service.addTrail(this.trail).subscribe((response: any) => {
      console.log(response);
      localStorage.setItem("id", response.id);
      console.log("Record Added Sucessfully !!!!!");
      this.router.navigate(['/home']);
    })
  }

}
