import { computed, Injectable } from '@angular/core';
import { ApiResponse, Character } from '../interface/character.interface';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { toSignal } from '@angular/core/rxjs-interop';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  constructor(private http: HttpClient) { }
  

  private readonly apiUrl = 'https://rickandmortyapi.com/api/character';

  private readonly charactersResponse = toSignal(
    this.http.get<ApiResponse>(this.apiUrl).pipe(
      map((response) => response.results)
    ),
        {
          initialValue: [] as Character[],
        }
  );
 
  readonly characters = computed(() => this.charactersResponse());

}
