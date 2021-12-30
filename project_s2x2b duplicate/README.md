# My Personal Project player

## AdLib Audio *SoundBoard*

This application will allow users to play some of my favourite AdLibs 
from some of my favourite musical artists. This is done through a simple command pad where
users can click on an image of the chosen artist and when clicked, that chosen Artists AdLib will play. This application acts in 
similar fashion to a sound board. This application provides great use for DJ's and mc's who would like to add a little flair when mixing live for 
an audience. These sounds can add a nice transition between tracks and lets listeners here some of their favourite artists iconic AdLibs. Over the course 
of the Covid-19 pandemic I took upon myself to learn how to DJ. Being a university student at UBC I figured that learning how 
to DJ would be an amazing skill to entertain my friends. I bought one of the cheapest DJ controllers, but it lacked the
software to play quick bits of sound on my que. My project is a cheap an easy use solution to the problem I encountered.

### User Stories
- As a user, I want to be able to play a selected sound 
- As a user, I want to add a sound to a sound compilation
- As a user, I want to be play a sound compilation
- As a user, I want to be able to view my most listened sounds
- As a user, I would like to save my sound compilation
- As a user, I would like to load my sound compilation
- As a user, I would like to play/pause a Beat

### Phase 4: Task 3
In hindsight my project could have benefited from a lot of refactoring. I wish I had taken more time to refactor my UI package.
A lot of my classes and methods do not follow the single-design principle where I tried to do everything in one class/method. Now that I have learned
some of the design principles, I would break up each individual swing component to its own class rather than creating and instantiating swing components 
within a class. There is also a lot of repetitive code in my button classes. Specifically my doAction() and createIcon() methods where Instead of having them
as abstract methods I could have implemented them in the abstract button method and pass in a song and an Icon as parameters. Another place in my project where 
I have ton of duplicate code are my action Listener classes which each add a song to the compilation and then display the song added
to the compilation list display. By refactoring my buttons and action listener classes it would make it a lot less tedious to add new sounds/songs
in my Sound Board. In the current state of my code it becomes strenuous and very repetitive adding new sounds to the app. If I would like to have a lot of sounds which in my app,
something that I do wish to have, refactoring the above classes and methods is necessary.

Other places I wish to refactor:
- refactor LoseSo class to extend the Sound class
- Make an abstract sound buttons display class with an abstract method for adding action Listeners to buttons
- refactor abstract button class such that its inputs are a Sound and IconImage



