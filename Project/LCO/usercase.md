### User case module 

It has been decided to split the user cases into modules, this will allow us to create a structure with overview and at the same time give us a better understanding of the overall picture.
The class diagram and domain model will be included in the second iteration. This decision was made because we wish to have a meeting with the customer first so that we have a understanding of what the customer expects. It will also help us create a more accurate domain model and class diagram once the overall architecture is ready.

 #### Overall module
 * Display COMP module (html) 
 * Import COMP module (download) 
 * Log in module 
 * Log out module
 * Create user module 
 * Admin page module 
 * Search module (search for desired song) 
 * Most played songs module 

 ##### Display COMP module 
 A request to controller to fetch the data. 
 1. User wants to see something on the page 
 2. The servlet send a request for the desired action 
 3. The customer is transferred to a new page, or the page they are on is being updated. 

 ##### Import COMP module 
 1. How to download all the songs from the Dropbox file 

 ##### Log in module 
 1. The user writes their username and password and submits with the 'log in' button. A request will then be sent to the GET-Servlet. 
 2. If the submitted data is invalid, either username does not exist, or the password is incorrect the user will be redirected and asked to try again.
 3. If the user typed in correct username and password, the user will be forwarded and gain access to the main page, this will also create a unique session ID.

 ##### Log out module 
 1. The user presses the 'log out' button on the screen 
 2. A request is sent to a log out servlet 
 3. The session will be invalidated, and the customer will be redirected to the log in page. 

 ##### Register module 
 1. If the user does not have an account, they need to press the 'register' button. 
 2.The user will be redirected to the “register user” servlet. 
 3. The user will be asked to type in some information (first name, surname, address, phone, mail, username and password). 

 ##### Admin page module 
 1. A page for administrators which is used to make changes to the application.
 2. The admin can fetch lists with all the songs and customers. The administrators can also make changes to the application:
 •	add new songs
 •	remove songs
 •	filter songs into categories.

 ##### Search module 
 1.	The customer types the name of a given song in the search bar and then searches by pressing the “search” button.

 2.	A request will then be sent to find out if the artist of the song exists in the database.
 3.    If the song does not exist, the page will be redirected with a message stating the song does not exist.
 4.If the song does exist, the customer will be forwarded to a servlet with a dynamic jsp file where the chosen song is displayed. 

 ##### Search by category module 
 1.	The user checks a category and then presses search
 2.	A list of all the songs in the given category will then be displayed.


 ##### Most played songs module 
 1. On the main page a chart with most played/popular songs will be displayed to the user. 
 2. This chart will be updated every day.
