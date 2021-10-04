import { Observable } from 'rxjs';
import { Injectable } from "@angular/core"
import { HttpClient, HttpHeaders, HttpRequest } from "@angular/common/http"
import { Pedido } from "./shared/pedido.model"
import { map } from 'rxjs/operators';

import { URL_API } from './app.api';

@Injectable()
export class OrdemCompraService {

    constructor(private http: HttpClient) {}

    public efetivarCompra(pedido: Pedido): Observable<number> {

        let headers: HttpHeaders = new HttpHeaders()

        headers.append('Content-type', 'application/json')

        return this.http.post(
            `${URL_API}/pedidos`,
             pedido,
             { headers: headers }
        )
        .pipe(map((resposta: any) => { return resposta.id })) 
    }
}