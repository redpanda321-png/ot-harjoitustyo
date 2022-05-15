# Käyttöohje
Lataa viimeisimmän releasen lähdekoodi [täältä](https://github.com/redpanda321-png/ot-harjoitustyo/releases) valitsemalla Source code.zip Assets-osiosta

## Ohjelman käynnistäminen
Komento
```
mvn clean package
```
generoi hakemistoon target suoritettavan jar-tiedoston TowerDefence-jar-with-dependencies.jar


Mac OS X:llä tarvitaan lisäkomento "-XstartOnFirstThread"

  Siis komennoilla
```
mvn clean package
java -XstartOnFirstThread -jar target/TowerDefence-jar-with-dependencies.jar
```
voi luoda jar tiedoston, sekä suorittaa ohjelman mac OS X:llä




## Ohjelman hallinta
Sovellus käynnistyy alkunäkymään:

Alkunäkymästä voi aloittaa pelin painamalla nappia, jossa lukee "Click here to begin", tai sitten sulkea sovelluksen painamalla nappia, jossa lukee "Exit"

Pelinäkymässä vasemmalla hiirinäppäimellä voi laittaa vapaille ruuduille tornin, joka aloittaa ampumisen tornista oikealle. Hetken kuluttua aloittamisesta hirviöitä alkaa kävelemään polkua pitkin.

Tällä hetkellä hirviöt ainoastaan katoavat, kun ne pääsevät polun loppuun.
Kun tornin ampuma nuoli osuu hirviöön, hirviö katoaa ja saat yhden pisteen.

Painamalla Esc-näppäintä pääset takaisin alkunäkymään, josta voi sulkea sovelluksen.
