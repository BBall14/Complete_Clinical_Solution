import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TrailService } from '../service/trail.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Trail } from '../model/trail';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  hide: boolean = true;

  constructor(private router:Router, private service:TrailService) { }
  
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
this.service.getTrailById().subscribe((response)=>
{
  console.log(response);
  this.trail=response;  

  this.trailForm.patchValue({

    name:this.trail.name,
    description:this.trail.description,
    // duration:this.trail.duration,
    targetPopulation:this.trail.targetPopulation,
    status:this.trail.status});
});



  }
    //write a method to update a medical record
    updateRecord() : void {

      this.trail.id = this.trailForm.value.id!;
      this.trail.name = this.trailForm.value.name!;
      this.trail.description = this.trailForm.value.description!;
      this.trail.duration = this.trailForm.value.duration!;
      this.trail.targetPopulation = this.trailForm.value.targetPopulation!;
      this.trail.status = this.trailForm.value.status!;

      this.service.updateTrail(this.trail).subscribe(data => { 
        console.log(data);
        this.router.navigate(['/home']);
    });
  }

}
