# Assignment 2 - Rook in a maze
B-OOP 2021

Your task is to create a java window application with the Swing library. The user interface of the application must consist of:
* canvas
* side menu (you can choose the location of this side menu freely)

When the application starts, generate a maze using the [randomized depth first search](https://www.baeldung.com/cs/maze-generation#dfs-maze) algorithm and draw it onto the canvas.
The grid containing the maze must be at least 11x11 tiles large (including wall tiles). The entire maze must be surrounded by walls (no paths in the maze can touch the borders of the window).

In the generated maze choose in any way a starting and a goal point. Place the player figure on the starting point. The player can move their figure in 3 ways:
* by using the arrows keys on their keyboard. Always by one tile in the specified direction. They cannot enter a tile that contains a wall.
* by using the mouse. When the player figure is clicked, it can be moved like a rook chess piece (i.e. any number of tiles in the horizontal, or vertical directions).
The destination is chosen by a second mouse click. Tiles that can be moved to in this manner must be highlighted, when the mouse hovers over them. When moving in this manner, the player cannot jump over walls.
* by using buttons on the side menu, that represent the arrow keys. The rules for moving in this manner are the same, as for the movement by the arrow keys on the keyboard.

When the player reaches the goal point, the application should generate a new maze and the game starts over.

The side menu must contain:
* a counter of successfully completed mazes
* a button that resets the counter and generates a new maze
* buttons representing the arrow keys, which can be used to move the player. These buttons must be placed in the same way, they are placed on a regular keyboard.



## Grading
You can get 15 points for this assignment. **The program must be able to compile, otherwise 0 points are given for the assigment**.
The github pipeline checks whether the program can be compiled. The main focus during grading is put on object-oriented approach and OOP principles used by the solution.
Including, but not limited to:
* appropriate naming of classes, methods and variables in a single language (class names starting with a capital letter, method names starting with a lowercase letter),
* appropriate use of access modifiers (public, private, or protected) when restricting access to class methods and attributes,
* the use of inheritance and polymorphism,
* usage of exceptions when handling undesired behavior (do not catch or throw the instances of the generic Exception class),
* don't use nested classes,
* don't use static methods, or non-constant static variables (you don't need them to complete the assignment),
* don't put any logic into the main method and its class. The main method should only be used to create a new object,
* you can use the lombok library and its annotations in your solution. The neccessary dependency is already present in the _pom.xml_ file.

## Handing in the assigment
Clone the assignment from the repository created from this template by the provided link trough GitHub Classroom (if you create your own repository with the "use this template" button, we won't be able to see your repository and we won't be able to grade it!). Upload your solutions to your repository using the Git version control system (git commit + git push).
Make sure, that your repository was created under the **Interes-Group** group, otherwise we won't be able to access your repository, and the assignment will not be graded.
You can push commits to the repository while you work - you don't have to push everything at once. Only the code in the _master_ branch will be graded. You have until **23.4.2021 23:00** to complete the assignment.

Only edit files in the _src/main_ folder or its sub-folders. You mustn't change any other files in the repository (especially the _pom.xml_ file, and the github pipeline files).

You have to have your name set in your github account (settings > profile > name), so that we can match students with their assignments. **If we are unable to match a student with their assignment, the student will receive 0 points for the assignment!**
