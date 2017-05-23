COMA-Cultivation Of Mind Abilities
Anisha Chandra (P1), Reet Mishra (P5), Thanh Luong (P5)
5/4/2017

1. DESCRIPTION

Imagine driving straight into an open sewer. The next thing you know (but you actually do not) is that you have fallen into a coma and have damaged your entire brain! This is a major problem because you need your brain for basic abilities such as vision, hearing, cognition, and perception. To regain these abilities, you must navigate through the four lobes of the brain: the frontal lobe, temporal lobe, occipital lobe, and parietal lobe, all of which are responsible for basic brain functions. You will activate these areas by playing games that stimulate each lobe of the brain. Ultimately, COMA strengthens your natural abilities through entertaining mini games and engages your brain by providing the incentive to wake up from a coma.


The player has to complete each of the four mini games to win the game and “wake up.” After players wake up, they can still continue to play each of the games to score higher. Each mini-game has different rules based on the lobe it corresponds to.

   1. Occipital Lobe - “Sightseeing”
      The lobe is largely responsible for processing visual information from the 	eyes. This game tests field of view, which is how much an individual can see at any given moment. 
   2. Temporal Lobe - “Locked”
      This lobe of the brain coordinates auditory information. This game will use several similar sounds to test the player’s ability to distinguish between different sounds.
   3. Parietal Lobe - “Hole in the Wall”
      This lobe coordinates sensation and perception such as touch. The game tests control of touch because players have to match up shapes to holes in the wall by moving the wall steadily.  
   4. Frontal Lobe - “Flying Arrows”
      This lobe is responsible for cognition such as task switching, memory, and problem solving. This game tests the ability to quickly switch between different tasks and control impulses by remembering the actions of the different tasks. 


People take IQ tests all the time because they are curious to know how intelligent they are. Similarly, COMA will give people an idea of their brain’s capabilities, but delve in deeper than just intelligence. This is because it integrates skills such as vision, hearing, logic, speed, touch control, and memory all in one game. Along with relaxing and having fun, all users can strengthen their mental abilities through this game. Therefore, since it is not a regular IQ test it would even interest those who have no desire to know their mind aptitude. 


The primary features of our program includes the four mini games that incorporate the different lobes of our brain (occipital, temporal, parietal, and frontal). Another primary feature of the program is that the user has to win all the mini games by waking up each lobe in order to win the entire game and wake up the entire brain.


1. INSTRUCTIONS

   1. On the home screen, press the spacebar to continue. 
   2. Story Screen will let you know how you got in a coma and that you have to wake up your brain. Press “Menu” on the top right corner to continue. 
   3. The menu has four buttons for the four games and a brain in the center to communicate which lobes of the brain have been woken up by far. 
   4. By pressing a game button, the rules of the game are explained, and then press “Begin” to play the game. Exit the game at any time by pressing “Menu” to go back to the menu or “Back” to go back to the rules. 
   5. Flying Arrows
      The screen will show several arrows on the same screen with the same color (green, red, or blue) and and pointing in the same direction (left, right, up, or down). They will also be moving in the same direction. Press different keys depending on the color of the arrows
         1. If the arrows are green, press the arrow on the keyboard that corresponds to the direction the arrows are moving in.
         2. If the arrows are red, press the arrow on the keyboard that corresponds to the direction the arrows are pointing to.
         3. If the arrows are blue, press the arrow on the keyboard that corresponds to the opposite direction the arrows are moving in.
   6. Hole in the Wall
      The screen will show three shapes arranged on the right side of the screen: a circle, a triangle, and a square. These same three shapes will shoot from the right side of the screen. Ensure that each shape that shoots meets the appropriate space on the wall. Use up and down arrow keys to move the wall so that the shapes fit accordingly.
   7. Locked
      The screen will show a keypad of number 0-9. Start by clicking “play” at the top of the screen to listen to four distinct sounds strung together. Each number of the keypad corresponds to a different piece of the larger sound. Players need to press numbers of the keypad to find a code of four digits that produces the same sound as the sound they initially heard.
   8. Sightseeing
      An airplane and a symbol will be on a city background for a second. Helicopters also pop up on the screen as a distraction. After, the city and all objects on it will disappear, so click the location where the object had been and then select the symbol that was on the screen with the airplanes and helicopters. 
   9. All mini games will also explain the winning requirement for each game. Once you win a game, you cannot play it again without restarting the entire game! You need to wake up the four lobes of the brain.


1. FEATURES 
   1. Must-have
      1. Pass or fail system by defined scoring thresholds
      2. Four mini games stimulating the brain
      3. Home screen, written rules page
      4. Menu and back buttons
      5. Game over after winning mini games
   1. Want-to-have
      1. Advanced/aesthetic graphics
      2. Brain map of progress
      3. Interactive walkthrough of mini games
      4. Multiple levels of each mini-game
      5. Everything (text, pictures, buttons) resizable
   1. Stretch
      1. User and saved progress
      2. More games in each lobe so that each time user plays there is a different game to play for that lobe
      3. Instead of just stimulating the lobe, address certain parts of each lobe
      4. User-specific scenarios; creating a character
      5. Depending on the month, have different background/scenes in each mini-game
         I.e in summer all games must have background of summer items such as beaches because the user’s brain will most likely be thinking of summer things during the summer
1. CLASS LIST
   1. Rules - superclass for the rules of each game (each rule screen has same features except for text)
   2. Lobe - superclass for the JPanel of each game 
   3. Occipital - sets the scene for each round of the “Sightseeing” game 
   4. Symbol - object for a symbol (6 possible symbols) that shows up in the city
   5. SymbolPanel - extends Lobe, shows 6 buttons of each of the 6 symbols 
   6. Airplane - extends FlyingObject; appears in a random location on the screen and then disappears
   7. FlyingObject - superclass for objects in the sky 
   8. Helicopter - extends FlyingObject; appears on the screen simultaneously with airplane to act as a distraction
   9. OccipitalRules - extends from Rules, describes rules for “Sightseeing”
   10. Temporal - extends Lobe, sets the scene for the “Locked” game
   11. Button - represents a button with a sound on the keypad 
   12. Keypad - extends JPanel; a panel with buttons for “0-9” on it 
   13. Sound - a sound that can play 
   14. TemporalRules - extends from Rules, describes rules for “Locked”
   15. Parietal - extends Lobe, the panel of the “Hole in the Wall” game with the drawn background and objects needed.
   16. Shape (abstract class)
   17. Circle - represents the circle that is shot from one side of the screen
   18. Square - represents the square that is shot from one side of the screen
   19. Triangle - represents the triangle that is shot from one side of the screen
   20. Wall - the destination of the shapes; consists of the configuration that the player uses arrow keys to move
   21. ParietalRules - extends from Rules, describes rules for “Hole in the Wall”
   22. Frontal - extends Lobe, controls the “Flying Arrows” game
   23. Arrow - represents an arrow displayed on the screen
   24. FrontalRules - extends from Rules, describes rules for “Flying Arrows”
   25. Home - extends JPanel; represents the Home Screen with an image on it
   26. Story Screen - extends JPanel; tells user how they got a coma and what they need to do to get out of it
   27. Menu - extends JPanel; represents the Menu which has JButtons to play a certain game
   28. Game Over - extends JPanel; communicates to the player that they have woken up the four lobes of the brain
   29. COMA - main class for the entire game 
1. RESPONSIBILITY LIST 
   1. Anisha 
      1. Occipital package
      2. Menu 
      3. Sound, Temporal 
   1. Reet 
      1. Frontal package
      2. Rules 
      3. Lobe
      4. Button, Keypad, Temporal
   1. Thanh 
      1. Parietal package
      2. Coma, Home
      3. StoryScreen
      4. TemporalRules
   1. All 
      1. GameOver