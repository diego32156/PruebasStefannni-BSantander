export interface ApiResponse {
    info: ApiInfo;
    results: Character[];
}

export interface ApiInfo {
    count: number;
    pages: number;
    next: string | null;
    prev: string | null;
}

export interface Character {
    id: number;
    name: string;
    status: string;
    species: string;
    type: string;
    gender: string;
    origin: CharacterOrigin;
    location: CharacterLocation;
    image: string;
    episode: string[];
    url: string;
    created: string;
}   

export interface CharacterOrigin {
    name: string;
    url: string;
}   

export interface CharacterLocation {
    name: string;
    url: string;
}

export type CharacterStatus = 'Alive' | 'Dead' | 'unknown';