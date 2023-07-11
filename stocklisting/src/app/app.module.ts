import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';

import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { PostComponent } from './post/post.component';
import { UpdateComponent } from './update/update.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    ToolbarComponent,
    PostComponent,
    UpdateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // BrowserAnimationsModule to display animations
    BrowserAnimationsModule,
    // MatButtonModule to display buttons
    MatButtonModule,
    // FlexLayoutModule to display in flex layout
    FlexLayoutModule,
    // MatCardModule to dispaly cards
    MatCardModule,
    // HttpClientModule to make http requests
    HttpClientModule,
    // MatSnackBarModule to display snack bar
    FormsModule,
    FlexLayoutModule,
    MatButtonModule,
    ReactiveFormsModule,
    FormsModule,
    NgIf,
    MatIconModule,  
    MatSnackBarModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    FormsModule,
    FlexLayoutModule,
    MatSnackBarModule,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    MatDialogModule,
    MatSelectModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
