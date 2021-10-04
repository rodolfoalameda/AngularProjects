import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HeaderComponent } from './header/header.component';
import { PainelComponent } from './painel/painel.component';
import { TentativasComponent } from './tentativas/tentativas.component';
import { ProgressoComponent } from './progresso/progresso.component';
import { TesteBootstrapComponent } from './teste-bootstrap/teste-bootstrap.component'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PainelComponent,
    TentativasComponent,
    ProgressoComponent,
    TesteBootstrapComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
