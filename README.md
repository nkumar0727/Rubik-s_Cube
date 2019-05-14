# old-rubiks-cube-solver
Rubik's Cube solving algorithm for a legal layout

UPDATE (5/14/19): This project was made when I was still learning programming. As such, it does not adhere to software development best-practices. In addition, no build system nor GUI has been used, so this is simply a program which needs to be run on the command line.

Current Functionality:

--Recieves faces of the cube with corresponding colors as input

--Outputs sequence of cube movements the user is to follow to reach a certain point in the solving process

Desired Functionality:

--Recieves faces of the cube as image files

--Displays the cube movements on a GUI for user to mimic

Necessary Updates:

--Finish current cube solving module: the middle layer

--Proper documentation for finalized modules

Files:

--CubeFace.java
  Models one face of a rubik's cube and its functions within the cube as a whole
  
--RubikCube.java
  Models the rubik'x cube as a whole and the functions that can be performed on it by the user
  
--CubeSolver.java
  File containing cube solving module algorithms

--rubik_test.java
  File used for debugging functionality of each new module added
