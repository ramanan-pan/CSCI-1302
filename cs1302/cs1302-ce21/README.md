# cs1302-ce21 Fun with Components and Containers

![Approved for: Spring 2020](https://img.shields.io/badge/Approved%20for-Spring%202020-blue)
![Instruction: Online](https://img.shields.io/badge/Instruction-Online-important)

> Words, words, words.
> **-- William Shakespeare, _Hamlet_**

This class exercise explores creating custom JavaFX components by extending (inheriting from) existing
JavaFX components. 

## Course-Specific Learning Outcomes
* **LO2.a:** Identify redundancy in a set of classes and interfaces, then refactor
using inheritance and polymorphism to emphasize code reuse.
* **LO7.a:** (Partial) Design and implement a graphical user interface in a software project.

## References and Prerequisites

* [CSCI 1302 JavaFX 8 Bookmarks and Notes](http://cobweb.cs.uga.edu/~mec/cs1302/gui/)
* [CSCI 1302 JavaFX Custom Component Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/components/components.md)

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Nike server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Nike into a subdirectory called `cs1302-ce21`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce21.git
   ```

1. Change into the `cs1302-ce21` directory that was just created and look around. There is 
   pretty much nothing there! That's intentional. Continue on to the 
   [Exercise Steps](#exercise-steps) below.
   
### Exercise Steps

1. Copy over your work from the `src/cs1302/gui` directory of `cs1302-components`
   (from the [CSCI 1302 JavaFX Custom Component Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/components/components.md))
   into the `src/cs1302/ce21` directory of `cs1302-ce21` and update the package
   statements accordingly (i.e., make sure the package is `cs1302.ce21`). 
   **You should create `src/cs1302/ce21` if it does not exist.**
   
1. If you did not finish 
   [CSCI 1302 JavaFX Custom Component Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/components/components.md), 
   then finish that work in the code you just copied over. Remember, in the custom
   component tutorial, you used custom components to reduce the containment heirarchy from this:
   
   ```
                                                             --|
                         Stage                                 |
                           |                                   |
                         Scene                                 |
          |--              |                                   |
          |               HBox                                 |
          |                |\                                  |
          |                | \------------------\              |
          |                |                    |              |
          |               VBox                 VBox            | Overall
          |               / \                  / \             | Containment
   Scene  |              /   \                /   \            | Hierarchy
   Graph  |            HBox  ImageView      HBox  ImageView    |
          |            / \                  / \                |
          |           /   \                /   \               |
          |    TextField  Button    TextField  Button          |
          |--                                                --|
   ```   
   
   to something like this:
   
   ```
                                                             --|
                         Stage                                 |
                           |                                   |
                         Scene                                 |
          |--              |                                   | Overall
          |               HBox                                 | Containment
   Scene  |                |\                                  | Hierarchy
   Graph  |                | \------------------\              |
          |                |                    |              |
          |           ImageLoader          ImageLoader         |
          |--                                                --|
   ```
   
1. **Compile and run your code without any errors or warnings,
   make sure it passes a `checkstyle` audit, 
   then stage and commit your changes.**
   
1. Tag your commit so that it's easier to checkout at a later
   point in time:
   
   ```
   $ git tag tutorial
   ```
   
   [Tagging](https://git-scm.com/book/en/v2/Git-Basics-Tagging) allows us
   to give the commit a more convenient name to a commit than its
   hexademical checksum.

![CP](https://img.shields.io/badge/Checkpoint-1-success?style=for-the-badge)   
   
1. Now, read the class-level API documentation for the
   [`TilePane`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/TilePane.html)
   class, then adapt your code to replace the highest `HBox` in the 
   containment hiearchy with a `TilePane` object.
   
   * The `TilePane` object's `prefColumns` should be set to `4` using the appropriate setter
     method.
     
   * The `TilePane` object should have four `ImageLoader` objects as its children.
   
   Here is the corresponding containment hierarchy for what is expected:
   
   ```
                                                             --|
                              Stage                            |
                                |                              |
                              Scene                            |
          |--                   |                              | Overall
          |                 TilePane                           | Containment
   Scene  |                    /|\                             | Hierarchy
   Graph  |          /--------/ | \--------\                   |
          |         /          / \          \                  |
          |      ImageLoader  /   \        ImageLoader         |
          |                  /     \                           |
          |        ImageLoader     ImageLoader                 |
          |--                                                --|
   ```
   
1. **Compile and run your code without any errors or warnings,
   make sure it passes a `checkstyle` audit, 
   then stage and commit your changes.**
   
1. Now, increase the number of `ImageLoader` objects to `8`. This
   should be easy if you used a loop.
   
1. Commit these changes then tag your commit so that it's easier to checkout 
   at a later point in time:
   
   ```
   $ git tag tilepane
   ```
      
![CP](https://img.shields.io/badge/Checkpoint-2-success?style=for-the-badge)

1. Now, read the class-level API documentation for the
   [`TabPane`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TabPane.html)
   and [`Tab`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Tab.html)
   classes, then adapt your code to replace the `TilePane` in the 
   containment hiearchy with a `TabPane` object.
    
   * The `TabPane` object should have four `Tab` objects, each containing an `ImageLoader` object
     as its child.
   
   Here is the corresponding containment hierarchy for what is expected:
   
   ```
                                                             --|
                              Stage                            |
                                |                              |
                              Scene                            |
          |--                   |                              | Overall
          |                  TabPane                           | Containment
   Scene  |                    /|\                             | Hierarchy
   Graph  |          /--------/ | \--------\                   |
          |        Tab          |          Tab                 |
          |        /           / \           \                 |
          |     ImageLoader  Tab Tab         ImageLoader       |
          |                  /     \                           |
          |        ImageLoader     ImageLoader                 |
          |--                                                --|
   ```
   
1. **Compile and run your code without any errors or warnings,
   make sure it passes a `checkstyle` audit, 
   then stage and commit your changes.**
   
1. Tag your commit so that it's easier to checkout at a later
   point in time:
   
   ```
   $ git tag tabpane
   ```

1. View the condensed, graphical version of your Git log.
   Since you tagged each relevant commit with a name, you
   can go back in time by checking out those commits more
   easily. For example,
   
   ```
   $ git checkout tutorial
   $ rm -rf bin/*
   ```
   
   Then, compile and run to see what your exercise looked like
   at that point in time!

![CP](https://img.shields.io/badge/Checkpoint-3-success?style=for-the-badge)

**Each student needs to individually submit their own work.**

1. Create a plain text file called `SUBMISSION.md` directly inside this exercise
   directory with the following information:

   1. Your name and UGA ID number;
   1. Collaborator names, if any; and
   1. The weekly code (listed with the exercise on eLC).
   
   Here is an example:
   
   ```
   1. Sally Smith (811-000-999)
   2. Collaborators: Joe Allen, Stacie Mack
   3. Weekly Code: replace-with-actual-code
   ```

1. Add and commit `SUBMISSION.md`. Also, do a final check to ensure your code 
   passes the `checkstyle` audit, then stage and commit all changes, if needed.

1. Change into the parent directory and use the `submit` command to submit this exercise to `cs1302a`:
   
   ```
   $ submit cs1302-ce21 cs1302a
   ```
   
![CP](https://img.shields.io/badge/Checkpoint-Submission-success?style=for-the-badge)

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
