# Vaatimuusmäärittely
## Sovelluksen tarkoitus

  Sovelluksen tarkoituksena on olla peli. Pelissä rakennetaan torneja puolustautuakseen hirviöiltä, jotka haluavat tuhota tukikohtasi. Sovelluksessa pidetään myös kirjaa huippupisteistä, jotka voi nähdä erillisestä näkymästä.

## Käyttöliittymäluonnos

Sovelluksessa on näin alustavasti 3 näkymää sovellus aukeaa päävalikkoon, josta voi siirtyä huippupiste (high scores) -näkymään, jossa nähdään huippupisteet. Päävalikosta voi myös tietenkin aloittaa uuden pelin, mistä siirrytään pelinäkymään.

  Pelinäkymästä näkee kaikki pelin kulkuun ja toiminnalisuuteen liittyvät olennaiset asiat, kuten mm.
- rakennetut tornit
- hirviöt
- oma tukikohta
- polku jota pitkin hirviöt kulkevat
- tornin rakentamisvalikon
- tiedon siitä kuinka paljon rahaa on
- kaadettujen hirviöiden lukumäärän
- pisteiden lukumäärä
- voi avata valikon, jossa voi poistua pelistä

Pistenäkymään tallentuvat aikaisemmat istunnot, josta näkee voittiko pelin ja pisteiden määrän. Pistenäkymästä voi palata päävalikkoon.

## Suunnitellut toiminnallisuudet

### Perusversio

#### Ennen pelin aloitusta
- voi nähdä aiempien sessioiden huippupisteet
  - alustavasti tyhjä lista, joka päivittyy sitä mukaan, kun peliä pelataan
- voi aloittaa pelin
  - vaikeustason valinta (helppo, normaali, vaikea)

#### Aloitettuaan pelin
- voi rakentaa torneja
- hirviöt marssivat tiheässä jonossa ennaltamäärättyä polkua pitkin tukikohtaan päin
- hirviöt marssivat ns. aalloittain
  - ensimmäinen aalto vastaa pelin ensimmäistä tasoa, jne.
- seuraava taso alkaa jonkin tietyn ajan kuluttua edellisen tason päätyttyä
  - taso päättyy kun hirviöt on kaadettu
- tornit ampuvat hirviöitä itsestään
- tasoja on rajallinen määrä
- kun hirviö pääsee tukikohtaan asti, menettää pelaaja yhden elämäpisteen
- peli päättyy, kun kaikki tasot läpäistään (voitto), tai jos elämäpisteet menevät nollaan (häviö)
- pelin päätyttyä tallennetaan tieto voitosta/häviöstä ja pistemäärä, jonka jälkeen käyttäjä viedään huippupistenäkymään

## Jatkokehitysideoita

- torneja on erityyppisiä
- torneja voi parannella eri tavoin
- hirviöitä on erityyppisiä
  - esim. nopeampia tai joillekin torneille heikkoja
