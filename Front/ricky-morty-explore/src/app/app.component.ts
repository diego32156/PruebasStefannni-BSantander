import { Component } from '@angular/core';
import { CharacterListComponent } from './pages/character-list/character-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CharacterListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {}
