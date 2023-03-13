# group6-tetris

## Group 6, TCSS 305 Section A

### Group Members:

- David Hoang
- Avinash Bavisetty
- Yonas Omega
- Jose Rodriguez

### Sprint 1 Contribution:

- David: Added file menu with user options that have event handlers.
- Yonas: Running the GUI in a main class, and creating the GUI window.
- Jose : South and West Components
- Avi: Center and East Branch


### Sprint 1 comments:
Will make changes in implementation where some components are in different classes, and a seperate class running the gui and functionality.

### Sprint 2 Contribution:

- David: Model Update, improving on  checkstyle errors, checking code on other members to fit requirements.
- Yonas: Determine the top-most GUI class (JFrame or JPanel) Instantiate and add a reference to the primary model object (Board). Instantiate and add a reference to a javax.swing.Timer object. Determine how often the Timer should "tick". Add an ActionListener that calls an appropriate method from in the Interface defined in Model Update. Add a KeyListener to the JPanel that represent the top-most GUI class.
- Jose :  In the GUI class that contains the visual representation of the Next Tetris Piece (JPanel)
Implement PropertyChangeListener
Add the instantiated object of this class to the list of PropertyChangeListeners in the Board object
When this object is informed by the Board of a "next piece" state change
Paint/draw/fill ANYTHING on this panel
- Avi: Made a new class to have the centerpiece implemented in, made a grid that can be displayed in the center panel with one box on the grid in the top left corner completely covered in red. Also implemented a propertychangelistener and instantiated the object of this class to the list of the propertychangelisteners in the Board object. If there’s any information that’s changed it will be reflected in the center panel class.

### Sprint 2 Meetings 
- https://docs.google.com/document/d/1Hq2A3zF28I5R794mcIX3-NElclsdM7Mi9it_RWHOGXo/edit?usp=sharing
- Meeting times: 3/2/2023 (12:40pm),3/5/2023 (12:00pm), met on discord both times.
- We had smaller meetings in class and it was regarding the discussion of our output on the centerpanel and in regards to our PropertyChangeListener implmentation.
- Primary form of communication for everyone was on our own discord server for the project.


### Sprint 2 comments:
will make centerplanel class listen to key events in guiwindow and update for the tetris piece when user clicks wasd.

### Sprint 3 Contribution:

- David:  Helped implement the color, location of frozen and current pieces on the board.
- Yonas: added more helper methods in the timer such as speedUpTimer which decreases the delay and speeds up the timer which is called whenever the user levels up. Also made the tetris piece go down based on the timer delay. I also made a sound class and added background music to the game. Also added sound effects for moving pieces. Also changed the implementation of the controlKeyListener class.
- Jose: Worked on getting the south and west panels working; with the timers for keeping track of Points, Levels, Lines, Next Piece, and Next Level in as a  part of those panels.
- Avi: Helped with finishing up the centerpanel.java and putting the finishing touches on the gui such as implementing the backgrounds for the panels.

### Sprint 3 Meetings 
- https://docs.google.com/document/d/1Hq2A3zF28I5R794mcIX3-NElclsdM7Mi9it_RWHOGXo/edit?usp=sharing
- Meeting times: 3/2/2023 (12:40pm),3/5/2023 (12:00pm), met on discord both times.
- We had smaller meetings in class and it was regarding the discussion of our output on the centerpanel and in regards to our PropertyChangeListener implmentation.
- Primary form of communication for everyone was on our own discord server for the project.


### Sprint 3 comments:
-Checkstyle: Method buildUserOptions length is 104 lines (max allowed is 100) in GUIWINDOW needs to be ignored because this was caused by additional lines that were added to a print statement in the "About" Section in regards to the resources we used in our project.
-Scoring algorithm can be found under the File Options
#### Changes to Board Class: 
-Made board lass implements PropertyChangeEnabledControls interface, which is designed to be used
  in the Observer Design pattern through the propertyChangeSupport class. 
- made local variables to see the old sequence index, the old game over status and my drop fields when they changed
- fired the new values when they were updated in newGame method. 
- made local variable to see the   myCurrentPiece field when they changed and fired them in the down method. 
- made local variables to see the old myCurrentPiece fields, and  old myDrop fields when they changed and fired them in the move method.
- made local variables to see the old myGameOver, old myNextPiece and old myNonRandomPieces fields when they changed
- fired the new values when they were updated in prepareNextMovablePiece method
- Overriden the add and remove propertyChangeListener methods to implement the observer design pattern.
- fired new value of completeRows, when it updated in checkRows method.
- fired new value of myGameOver, when it updated in setPoint method.
- add a public method to the board class to end game
