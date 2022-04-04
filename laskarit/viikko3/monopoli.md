```mermaid
 classDiagram
      Monopoli --> "1" Pelilauta
      Monopoli --> "2" Noppa
      Monopoli --> "2..8" Pelaaja
      Pelilauta "1" --> "40" Ruutu
      Pelaaja "1" --> "1" Pelinappula
      Pelinappula "*" --> "1" Ruutu
      class Ruutu{
      seuraavaRuutu
      edellinenRuutu
      }
```
