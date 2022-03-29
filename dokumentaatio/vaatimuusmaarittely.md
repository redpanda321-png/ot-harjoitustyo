# Vaatimuusmäärittely
## Sovelluksen tarkoitus

  Sovelluksen tarkoituksena on olla peli. Pelissä rakennetaan torneja puolustautuakseen hirviöiltä, jotka haluavat tuhota tukikohtasi. Sovelluksessa pidetään myös kirjaa huippupisteistä, jotka voi nähdä erillisestä näkymästä.

## Käyttöliittymäluonnos

Sovelluksessa on näin alustavasti 3 näkymää. Sovellus aukeaa päävalikkoon, josta voi siirtyä Pistenäkymään (high scores). Päävalikosta voi myös aloittaa uuden pelin, mistä siirrytään pelinäkymään.

  Pelinäkymästä näkee kaikki pelin kulkuun ja toiminnallisuuteen liittyvät olennaiset asiat, kuten mm.
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

#### Aloitettuaan pelin
- peliä ohjataan hiiren avulla
- voi rakentaa torneja
  - tornit maksavat rahaa, ja ovat valmiita välittömästi
- hirviöt marssivat tiheässä jonossa ennaltamäärättyä polkua pitkin tukikohtaan päin
- hirviöitä kaatamalla ansaitsee rahaa
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

- vaikeustason valinta (helppo, normaali, vaikea)
- torneja on erityyppisiä
- torneja voi parannella eri tavoin
- hirviöitä on erityyppisiä
  - esim. nopeampia tai joillekin torneille heikkoja
- tornit eivät rakennu välittömästi, vaan rakennuksessa kestää
- erilaisia äänieffektejä kuten esimerkiksi
  - kun taso alkaa
  - kun taso päättyy
  - kun hirviö pääsee tukikohtaan
- taustamusiikkia
- mahdollisia animaatioita torneille tai hirviöille
- rajoitettu ohjattavuus näppäimistölle 
  - rakennusvalikon valintoja voi tehdä näppäimistöllä
