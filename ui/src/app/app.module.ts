import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { GameselectorComponent } from './gameselector/gameselector.component';

import { Routes, RouterModule } from '@angular/router';
import { GameAComponent } from './game-a/game-a.component';
import { HomeComponent } from './home/home.component';
import { LearnMoreComponent } from './learn-more/learn-more.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'game-a', component: GameAComponent},
  {path: 'info', component: LearnMoreComponent},
  {path: '**', redirectTo: '/home', pathMatch: 'full'},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
];


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    GameselectorComponent,
    GameAComponent,
    HomeComponent,
    LearnMoreComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    // FormsModule
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
