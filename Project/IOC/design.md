## Design 

**Agenda:** Sette opp design for hvordan sidene skal se ut på websiden, det brukeren vil se 

Mathias skal ha oversikt over design og tegner 
Emilie kan laste opp diagrammene etter møte og skrive referat  

**Deltakere:** Olav, Sebastian, Daniel og Mathias (+ Emilie)

#### Logikk: 
- Main - hovedside 
- Login - brukeren kan logge inn 
- Logout - når brukeren logger ut, vil hen komme tilbake til Main med en beskjed om at du er logget ut 
- Create user - opprette en ny bruker 
- Admin - hvis du logger inn som admin, tilgang her
    - styre bruker settings 
    - styre rettigheter 
    - slette / legge til sanger 
    - banne brukere 
- Library - hvis du logger inn som admin eller moderator, tilgang her 
    - slette / legge til sanger 
    - banne brukere 

Sider som ikke trenger sin egen side, trenger man bare refreshe main siden med evt en beskjed 

#### Pages (jsp/html): 

Skisse av alle sidene ligger under Project/Diagram 

***User settings:*** 
når bruker er logget inn, får hen tilgang til en user settings side hvor endringer kan gjøres: 
- endre brukernavn 
- passord 
- email 

***Forgot password:***
redirected fra ***Login page***
sendt videre til en side, hvor du kan skrive inn mail og en submit knapp (få tilsendt nytt passord på mail)

***Login page:***
username, password + submit button  

***Create user:***
username, email, password x2 + submit(register) button 

to brukere kan ha samme username, fordi hver bruker får et unikt username 

email må være unik 

***Admin page:***
liste med alle brukere (endre rolle, banne)
søke etter bruker 

button som redirecter til ***Library***

***Library:***
Moderator siden 
liste med alle sanger 
søke etter sanger slik at du kan gjøre endringer 
add/remove 

***Main page:***
[Inspirasjon hentet fra Songsterr](https://www.songsterr.com)

**til venstre på siden:**
- søke etter sanger´
- liste med Top 10 
redirected til ***Song***

**til høyre på siden:**
- settings 
- library
- admin 
- logout/login 

***Song***
noter eller pdf 
play knapp 


