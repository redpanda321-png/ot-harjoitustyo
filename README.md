# Otsikko
## Dokumentaatio
[Työaikamäärittely](https://github.com/redpanda321-png/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

  [Vaatimuusmäärittely](https://github.com/redpanda321-png/ot-harjoitustyo/blob/master/dokumentaatio/vaatimuusmaarittely.md)
  
  [Changelog](https://github.com/redpanda321-png/ot-harjoitustyo/blob/master/dokumentaatio/changelog.md)
  
  [Arkkitehtuurikuvaus](https://github.com/redpanda321-png/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)
  
  
## Komentorivitoiminnot

### Ohjelman suoritus

Ohjelman voi suorittaa komentoriviltä komennolla

```
mvn compile exec:java -Dexec.mainClass=org.wb.games.towerdefense.ui.TowerDefense
```
Huom. mac OS X:llä suorittaminen komentoriviltä ei suoraan onnistu, vaan täytyy luoda jar tiedosto ja sen jälkeen ohjelman voi suorittaa jar tiedoston avulla. Katso kohta "suoritettavan jarin generointi" myöhempänä tässä osiossa.

### Testaus
Testit suoritetaan komennolla

  ```
  mvn test
  ```
  
Testikattavuusraportti luodaan komennolla
  ```
  mvn jacoco:report
  ```
### Suoritettavan jarin generointi
Komento
```
mvn clean package
```
generoi hakemistoon target suoritettavan jar-tiedoston myJar-jar-with-dependencies.jar

Mac OS X:llä suorittaessa ohjelmaa tarvitaan lisäkomento "-XstartOnFirstThread"

  Siis komennoilla
```
mvn clean package
java -XstartOnFirstThread -jar target/myJar-jar-with-dependencies.jar
```
voi luoda, sekä suorittaa ohjelman mac OS X:llä

### Checkstyle
Checkstyle raportin voi luoda komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
### Javadoc
Javadoc on vielä toteuttamatta.
