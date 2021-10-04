import { Component, Input, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { Coracao } from '../shared/coracao.model';

@Component({
  selector: 'app-tentativas',
  templateUrl: './tentativas.component.html',
  styleUrls: ['./tentativas.component.css']
})
export class TentativasComponent implements OnChanges {

  @Input() public tentativas!: number

    public coracoes: Array<Coracao> = [
      new Coracao(true), new Coracao(true), new Coracao(true)
    ]

  constructor() {
    
  }

  ngOnChanges(changes: SimpleChanges): void {
    if(this.tentativas !== this.coracoes.length){
      let index = this.coracoes.length - this.tentativas
      this.coracoes[index - 1].cheio = false
    }
    
  }

  ngOnInit(): void {
  }
}
