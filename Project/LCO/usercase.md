### User case module 

We have chosen to divide our user cases into modules. In that way we create an overall structure where we get an overview idea what needs to be done. 

Other supplementary requirements (class diagram, domain model etc) will be included in Iteration 2. The reason for this decision is because we want to have a costumer meeting first. It is also more logical and less time consuming for us to start on this after the overall architecture of our program is done. 

#### Overall module
* Display COMP module (html) 
* Import COMP module (download) 
* Log in module 
* Log out module module 
* Create user module 
* Admin page module 
* Search module (search for desired song) 
* Most played songs module 

##### Display COMP module 
A request to controller to fetch the data. 
1. User wants to see something on the page 
2. The servlet send a request for the desired action 
3. The costumer is transferred to a new page, or the page they are on is being updated. 

##### Import COMP module 
1. How to download all the songs from the Dropbox file 

##### Log in module 
1. The user type in username and password, and press the 'log in' button. A request is being sent to the doGet servlet. 
2. If its not correct, the servlet will not proceed forward. Instead an error is shown and the user is asked to type in again 
3. But if the username and password was correct, the user is being forwarded to a new servlet (the main page) and is given a valid and unique session ID 

##### Log out module 
1. The user press the 'log out' button on the screen 
2. A request is sent to a log out servlet 
3. The session ID will be unvalid and the costumer will be redirected to the log in page again 

##### Create user module 
1. If the user does not have an account, they need to press the 'create user' button. 
2. A request is sent to a servlet where they get redirected to create user servlet. 
3. The user will be asked to type in some information (firstname, surname, address, phone, mail, username and password). 

##### Admin page module 
1. An admin page that have access doing changes on the page. 
2. The admin can fetch lists with all the songs and costumers. The admin can also do changes: add new songs, remove songs, add songs to categories etc. 

##### Search module 
1. The costumer type in desired song in a search bar and press the 'search song' button. 
2. A request is sent to a servlet, and logic to find out if the song exist in the database 
3. If the song does not exist, the costumer will get an error. 
4. If the song does exist, the costumer is forwarded to a servlet with a dynamic jsp file where the chosen song is displayed. 

##### Most played songs module 
1. On the main page a chart with most played/popular songs is displayed for the viewer. 
2. This chart will be updated from each day/or week.
3. A method or class that keeps track of the most popular songs of the day/or week.
4. A servlet with a dynamic jsp(?) that display the chart. 

##### Category module 
1. Possible for the costumer to get lists of songs in different categories 