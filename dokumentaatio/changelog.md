# Changelog
## Viikko 3
- Lisätty Scene-luokka, joka vastaa pelinäkymästä.
- Käyttäjä näkee toistaiseksi vain kokoelman ruutuja, jotka ovat määritelty matriisin avulla
- Lisätty TileType-enum, jossa määritellään erityyppisiä ruutuja


## Viikko 4
- Otettu käyttöön Tiled tilemap-editori, jolla voidaan luoda pelikartta tileseteistä
- Hankittu (ilmainen/vapaa) ulkoinen tileset/asset pack, jota käytetään hyödyksi käyttöliittymässä ja pelin muissa grafiikoissa
- Lisätty Game-luokka, joka vastaa hiiren ja näppäimistön kuuntelemisesta. Tämän lisäksi luokka vastaa tällä hetkellä vielä kameran ja tilemapin asettamisesta.
- Lisätty Tower-luokka, joka vastaa tornien eri toiminnoista, kuten mm. niiden rakennuksesta
- Lisätty Monster-luokka, jossa määritellään hirviöt. Tällä hetkellä luokka myös vastaa niiden animaatiosta
- Eritelty luokkia eri pakkauksiin


## Viikko 5
- Lisätty Checkpoint systeemi liikuttaakseen Monster-olioita eri reittipisteiden kautta
- Lisätty Menu ja tapa siirtyä peliin Menu:sta, sekä pelin voi sulkea nyt näppäimistön avulla
- Checkstyle

## Viikko 6
- Korjattu filepath ongelma, joka oli kaatanut ohjelman, kun käynnistää jar-tiedostosta
- Lisätty nappi alkuun
- Lisätty Projectile-luokka, jossa määritellään tornien ammukset
