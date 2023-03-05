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
- Yonas: Determine the top-most GUI class (JFrame or JPanel)
Instantiate and add a reference to the primary model object (Board)
Make the instance variables type the Interface defined in Model Update
- Jose :  In the GUI class that contains the visual representation of the Next Tetris Piece (JPanel)
Implement PropertyChangeListener
Add the instantiated object of this class to the list of PropertyChangeListeners in the Board object
When this object is informed by the Board of a "next piece" state change
Paint/draw/fill ANYTHING on this panel
- Avi: Made a new class to have the centerpiece implemented in, made a grid that can be displayed in the center panel with one box on the grid in the top left corner completely covered in red. Also implemented a propertychangelistener and instantiated the object of this class to the list of the propertychangelisteners in the Board object. If there’s any information that’s changed it will be reflected in the center panel class.

### Sprint 2 Meetings 
- https://docs.google.com/document/d/1Hq2A3zF28I5R794mcIX3-NElclsdM7Mi9it_RWHOGXo/edit?usp=sharing\=
- We had smaller meetings in class and it was regarding the discussion of our output on the centerpanel and in regards to our PropertyChangeListener implmentation.
- Primary form of communication for everyone was on our own discord server for the project.

### Sprint 2 comments:
