# ce08 A Great Inheritance 

![Approved for: Spring 2020](https://img.shields.io/badge/Approved%20for-Spring%202020-blue)
![Max Group Size: 3](https://img.shields.io/badge/Max%20Group%20Size-3-important)

> I fully expected to find a Constable in the kitchen, waiting to take me up. 
> But not only was there no Constable there, but no discovery had yet been made of the robbery.
> **--_Great Expectations_ by Charles Dickens**

This class exercise explores how to utilize inheritance in Java to create new classes
that are directly based on existing ones, with an emphasis on code reuse and design
implications. 

## Prerequisite Knowledge

* A basic understanding of inheritance in Java.
* CSCI 1302 [Inheritance Tutorial](https://github.com/cs1302uga/cs1302-tutorials/blob/master/inheritance/inheritance.md)

## Course-Specific Learning Outcomes

* **LO3.b:** Create class, interface, method, and inline documentation that satisfies a 
set of requirements.
* **LO3.c:** Generate user-facing API documentation for a software solution.
* **LO4.c:** (Partial) Design, create and use inheritance relationships in a software solution.
* **LO4.d:** Utilize inheritance-based polymorphism in a software solution.

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are 
logged into the Nike server. 

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full 
command that you typed to make the related action happen. If context is necessary (e.g., the 
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Nike into a subdirectory called `cs1302-ce08`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce08.git
   ```

1. **[ALL GROUP MEMBERS]**
   If you did not setup your Git username and email on Nike when working on `cs1302-ce07`,
   then please revist that exercise and follow the instructions presented [here](https://github.com/cs1302uga/cs1302-ce07#getting-started).

1. Change into the `cs1302-ce08` directory that was just created and look around. There should be
   multiple Java files contained within the directory structure. To see a listing of all of the 
   files under the `src` subdirectory, use the `find` command as follows:
   
   ```
   $ find src
   ```
   
   For each Java file under the `src` subdirectory, fill out a table similar to the following:
   
   | Name of the Java file | Abstract or Concrete Class? | Fully Qualified Name (FQN) | Depends On |
   |-----------------------|-----------------------------|----------------------------|------------|
   |-----------------------|-----------------------------|----------------------------|------------|
   |-----------------------|-----------------------------|----------------------------|------------|
   |-----------------------|-----------------------------|----------------------------|------------|

   The "Depends On" column should list any Java types under the `cs1302.shapes` package that the file
   is dependent upon. 
   
1. Make sure you are in the `cs1302-ce08` directory.
   Individually compile each `.java` specifying `bin` as the default package location for compiled code.
   Only specify the class path option when absolutely necessary.
   You may need to create the `bin` directory if it does not already exist.
   Write down the commands that you used in the order that you used them.
   
1. Inspect the source code provided with the exercise. For each of the `.java` files, list in your notes
   the signature of each method, excluding any constructors. Make sure to include abstract methods.
   
   For readability, you might find it helpful to build a table similar to the one below in your notes:
   
   |                       | `Shape.java`        | `Ellipse.java`        | `Circle.java`        |
   |-----------------------|---------------------|-----------------------|----------------------|
   | Method signatures     |||
   
1. Make sure that all Java files pass the `checkstyle` audit. Then, generate the API documentation website 
   for all of the code in the `cs1302` package into the `doc` directory. You may need to create the `doc` 
   directory if it does not already exist. Host the documentation on Nike using `cs1302-ce08-doc` as the 
   name for your symbolic link. Write the full URL of your API documentation website in your notes.
   
1. On the API documentation website, go to the webpage for the `Circle` class. In your notes, copy down the
   inheritance hierarchy listed near the top of the page under the text **Class Circle**. You may list the 
   simple class names for classes in the `cs1302.shapes` package. **Please write down the FQN for any classes
   in other packages.**

1. Answer the following short answer questions in your notes:
   1. How many methods does `Circle` inherit from `Ellipse`? Why isn't `getPerimeter` listed as being inherited
      from `Ellipse`?
   1. How many methods does `Circle` inherit from `Shape`? Why aren't all methods in `Circle` listed as being
      inherited from `Shape`?
   1. How many instance variables are contained in an object of type `Ellipse`? How many are directly accessible?
   1. How many instance variables are contained in an object of type `Circle`? How many are directly accessible?
   1. The `setName` method in `Shape` is declared to be `protected`. Explain how the `protected` access modifier
      differs from `public` and `private`.

**CHECKPOINT**

1. In your notes, recreate the following table:

   | Reference Type | Object Type | Valid? (Guess) | Valid? (Actual) | Explain |
   |----------------|-------------|----------------|-----------------|---------|
   | `Shape`        | `Shape`     |||
   | `Shape`        | `Circle`    |||
   | `Shape`        | `Ellipse`   |||
   | `Circle`       | `Shape`     |||
   | `Circle`       | `Ellipse`   |||
   | `Circle`       | `Circle`    |||
   | `Ellipse`      | `Shape`     |||
   | `Ellipse`      | `Circle`    |||
   | `Ellipse`      | `Ellipse`   |||

   Create a `ShapeDriver.java` program in the `cs1302.driver` package. Don't forget to import the classes from the 
   `cs1302.shapes` package. In the `main` method of `ShapeDriver.java`, do the following steps for each row in the table:
   
   1. Declare a reference variable called `obj` with the type denoted in the **Reference Type** column.
   1. On the same line, create an object of the type denoted in the **Object Type** column using `new` and an appropriate 
      constructor call and assign it to `obj`.
      The first declaration and instantiation would look like this:
      `Shape obj = new Shape();`
   1. Make an educated guess as to whether or not the line will successfully compile. Note this in the **Valid? (Guess)** 
      column of your table.
   1. Save the file, then attempt to compile `ShapeDriver.java`. 
      Note whether it compiled in the **Valid? (Actual)** column of your table.
   1. Now for the most important part! In the **Explain** column of your table, explain why the statement is valid or invalid.
      If the statement is invalid, do not simply copy the error message provided by the compiler--do your best to explain it
      in your own words.
   1. Delete the line of code before proceeding to the next row.

**CHECKPOINT**

1. In your notes, recreate the following table:

   | Reference Type | Object Type | Method Call                | Valid? (Guess) | Valid? (Actual) |Explain|
   |----------------|-------------|----------------------------|----------------|-----------------|-------|
   | `Shape`        | `Ellipse`   | `getPerimeter()`           |||
   | `Ellipse`      | `Circle`    | `getName()`                |||
   | `Ellipse`      | `Circle`    | `getSemiMajorAxisLength()` |||
   | `Shape`        | `Ellipse`   | `getSemiMinorAxisLength()` |||
   | `Shape`        | `Ellipse`   | `setName()`                |||   
   | `Ellipse`      | `Ellipse`   | `getDiameter()`            |||
   | `Shape`        | `Circle`    | `getRadius()`              |||
   | `Ellipse`      | `Circle`    | `getCircumference()`       |||
   | `Circle`       | `Circle`    | `getPerimeter()`           |||

   In the `main` method of `ShapeDriver.java`, do the following steps for each row in the table:
   
   1. Declare a reference variable called `obj` with the type denoted in the **Reference Type** column.
   1. On the same line, create an object of the type denoted in the **Object Type** column using `new` and an 
      appropriate constructor call and assign it to `obj`.
   1. On the next line, call the method listed in the **Method Call** column using `obj` as the calling object. 
      If the method has a return type other than `void`, then simply assign it to a new variable of the appropriate type.
   1. Make an educated guess as to whether or not the two lines of that you added code will successfully compile. 
      Note this in the **Valid? (Guess)** column of your table.
   1. Save the file, then attempt to compile `ShapeDriver.java`. 
      Note whether it compiled in the **Valid? (Actual)** column of your table.
   1. Now for the most important part! In the **Explain** column of your table, explain why the statement is valid or invalid.
      If the statement is invalid, do not simply copy the error message provided by the compiler--do your best to explain it
      in your own words. If the statement is valid, give the fully qualified name (FQN) of the class containing the implementation
      for the method.
   1. Delete the two lines of code before proceeding to the next row.
   
**CHECKPOINT**
   1. *Thought exercise*: Remember the `Drivable` interface in the previous class exercise. In that example,
      you wrote two or three classes that implemented `Drivable`. In those classes, the `speedUp` and `slowDown`
      methods were very similar. You may have even had similar instance variables. Spend a few minutes thinking
      about whether or not inheritance could have been used to simplify the code and to reduce redundancy. How 
      exactly would this work?
      
   1. For those of you who have read _Great Expectations_, impress your friends with the quote from the
      beginning of Chapter 4 seen at the top of this exercise. In those two sentences, Dickens provides
      the framework for the entire narrative:
      
      > I fully expected __SOME GREAT EXPECTATION__. 
      > But not only was there no __EXPECTED SOMETHING__, but no __REAL PLOT DEVELOPMENT OCCURED RELATED TO WHY I EXPECTED IT__.
   
   1. Also, the provenance of Pip's inheritance is a core question in the book's narrative, up until
      the very end. Whether we wanted it or not, we've stepped into a war with the Cabal on Mars. 
      So let's get to taking out their command, one by one. Valus Ta'aurc. From what I can gather he 
      commands the Siege Dancers from an Imperial Land Tank outside of Rubicon. He's well protected, 
      but with the right team, we can punch through those defenses, take this beast out, and break their 
      grip on Freehold.

**NOT A CHECKPOINT**
    
<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
