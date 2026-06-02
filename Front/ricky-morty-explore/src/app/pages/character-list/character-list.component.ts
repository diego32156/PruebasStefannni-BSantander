import { Component, computed, signal } from '@angular/core';
import { CharacterService } from '../../core/service/character.service';
import { Character } from '../../core/interface/character.interface';
import { NgClass } from "../../../../node_modules/@angular/common/index";

@Component({
  selector: 'app-character-list',
  standalone: true,
  imports: [],
  templateUrl: './character-list.component.html',
  styleUrl: './character-list.component.css',
})
export class CharacterListComponent {
  readonly searchTerm = signal('');
  readonly characters = this.characterService.characters;
  readonly filteredCharacters = computed(() => {
    const term = this.searchTerm().toLowerCase();

    if (!term) {
      return this.characters();
    }

    return this.characters().filter((character: Character) =>
      character.name.toLowerCase().includes(term),
    );
  });

  constructor(private characterService: CharacterService) {}

  onSearch(value: string):void {
    this.searchTerm.set(value);
  }

  getStatusClass(status: string): string {
    const normalizedStatus = status.toLowerCase();
    if (normalizedStatus === 'alive') {
      return 'bg-green-500';
    } else if (normalizedStatus === 'dead') {
      return 'bg-red-500';
    } else {
      return 'bg-gray-500';
    }
  }

}