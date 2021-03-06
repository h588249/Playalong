### Variable tracking and summary

##### User session attributes:

> Logged in username:  
``user_username``  
Logged in email:  
``user_email``  
Logged in role:  
``user_role``  
List of song names:  
``songs``  
Name of chosen song:  
``song_name``  
Chosen song object:  
``song``  
Status message:  
``message``

##### Routing variables:

> previous page:  
``from``

##### Static routing variables:

> Index:  
``INDEX_URL``  
``INDEX_PATH``  
Admin:  
``ADMIN_URL``  
``ADMIN_PATH``  
Login:  
``LOGIN_URL``  
``LOGIN_PATH``  
Logout:  
``LOGOUT_URL``  
``LOGOUT_PATH``  
Register:  
``REGISTER_USER_URL``  
``REGISTER_USER_PATH``  
Search:  
``SEARCH_URL``  
Import:  
``IMPORT_URL``  
Display:  
``DISPLAY_URL``

##### Messages

> Message  
``Regular message``

#### File structure

```bash
./ (getServletContext().getRealPath(""))
├── WEB-INF/
│   ├── upload/
│   │   ├── song_name0/
│   │   │   ├── song.pdf
│   │   │   ├── images/ (image representation of the pdf)
│   │   │   │   ├── song0.png
│   │   │   │   └── song1.png
│   │   │   └── sound/
│   │   │       └── sound0.mp3  
│   │   ├── song_name1/
│   │   │   ├── song_type0.pdf
│   │   │   ├── song_type1.pdf
│   │   │   ├── images/
│   │   │   │   ├── song_type0/
│   │   │   │   │   ├── song_type00.png
│   │   │   │   │   └── song_type01.png
│   │   │   │   └── song_type1/    
│   │   │   │       └── song_type10.png
│   │   │   └── sound/
│   │   │       ├── sound0.mp3
│   │   │       └── sound1.mp3
│   │   │
... 
```