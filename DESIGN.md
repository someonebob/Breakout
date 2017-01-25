
Jesse Yue 
jty4

My design goals were to have a separate class for each object in the game, and to keep it dry. Going into the project I had zero design knowledge and had everything in one java file. At one of the UTA office hours, the TA told me that I should have separate java files for each of my classes and each class should be like a person that is a part of the whole group. So I then restarted from scratch and made a class for the ball, paddle, bricks etc. I also tried my best to not repeat any code but there were some issues that I didn't know how to solve without a little bit of repetition. 

To add new features, one would have to go to the particular class of the object they would add a feature to, implement the feature, then create a method to access that feature from the levels class. Then they would probably have to go into the levels class and add an if statement in the step function.

Really my only major design choice was to have classes in separate files. The pros are that organization was much easier, I didn't have to scroll through a thousand lines to find what I wanted, and changing a particular object was much easier. The con was that I had to write a bunch more methods to get certain things from each class that I used to be able to access much more easily since everything was under the same parent class.

To resolve ambiguities I had a new instance variable of the object I wanted to use for each level of my game. This is where I had issues with repetition because I couldn't figure out how to make my game work without having to create a new object for each level.