# cs1302-ce100000_2 Streams / Recursion Practice

In this class exercise, students will further explore the use of the Java Stream API and
recursion.

## References and Prerequisites

* Basic understanding of Java Streams
* Basic understanding of recursion.

## Questions

In your notes, clearly answer the following questions. These instructions assume that you are
logged into the Nike server.

**NOTE:** If a step requires you to enter in a command, please provide in your notes the full
command that you typed to make the related action happen. If context is necessary (e.g., the
command depends on your present working directory), then please note that context as well.

### Getting Started

1. Use Git to clone the repository for this exercise onto Nike into a subdirectory called `cs1302-ce32`:

   ```
   $ git clone --depth 1 https://github.com/cs1302uga/cs1302-ce32.git
   ```

1. Change into the `cs1302-ce32` directory that was just created and look around. There are couple
   files distributed with the exercise to get you started on the questions below.

## Exercise Steps

For this first checkpoint, we encourage you to make use of the Java 8 Stream API
instead of recursion when asked to implement an iterative process without using
loops. The `MyFaceDriver` target is provided for you in the `Makefile` for your
convenience.

1. Open `MyFaceDriver.java`. Most of the code should look familiar from previous exercises.
   Read through the `main` method and make sure you have a good idea of what it does.
   You should also familiarize yourself with the other methods in the file.

1. In `MyFaceDriver.java`, implement the method called `countLargeWords`
   **without using loops**. This method takes a `MyFaceUser` as an
   argument and returns the total number of words with  `5` or more
   characters across all of their messages. You may need to reference the
   [MyFace Message API](http://csweb.cs.uga.edu/~mec/cs1302-mvn-site/cs1302-myface/apidocs/index.html).

1. In `main`, use the array returned by `sort.getSorted()` to ensure that
   your `countLargeWords` method is working properly. For each user in the
   array, you should print the following **without using loops**:

   * the contents of all messages owned by the user; and
   * the count of large words.

   Feel free to write this code in a method instead of directly in `main`.
   Make your print statements clear so that you can easily check that your
   method is working.

   **NOTES:**

   * Each user has a random number of messages between `0` and the
     social network size divided by `10`. That is [`0`, `50/10`].

   * You are reading people's messages. **We don't encourage this
     behavior, in general.** I know it says we can do it in the
     [EULA](https://en.wikipedia.org/wiki/End-user_license_agreement),
     but we know that most MyFace users don't read that thing. Also, some of
     the messages might be a bit odd (people write weird stuff sometimes) -- the
     contents of the messages were populated from the
     [Fortune Cookie Database](https://github.com/bmc/fortunes).

1. Stage and commit your changes locally.

**CHECKPOINT**

For this second checkpoint, we encourage you to make use of recursion instred of
the Java 8 Stream API when asked to implement an iterative process without using
loops. The `SweetTartsDriver` target is provided for you in the `Makefile` for your
convenience.

1. **Sweet Tarts** are a hard candy similar to Life Savers. They come in a roll
   with `n` Sweet Tarts per roll and there are four flavors (`A`, `B`, `C`, and
   `D`). The package is clear so you can see the order of the flavors in the roll.
   **You can only get a Sweet Tart from either end of the roll**; no breaking
   open the package in the middle. Furthermore, you are compelled to immediately
   eat a Sweet Tart once you remove it from the package.

   It's not surprising that you have a definite preference for the flavors and
   like to save your favorites until the end. Being the computer science type,
   you’ve come up with a score for the order in which you eat the candies. You
   give each of the flavors a number from `1` through `4`, depending on your
   preference (`4` is most favored, `1` is least). The score for eating a Sweet
   Tart is the product of its preference number with the turn you ate it. For
   example if you eat flavor `B` as the fifth Sweet Tart, and `B` has a
   preference number of `3`, then its score would be `15`.

   After you've eaten the entire roll, the overall score is the sum of all the
   individual Sweet Tart scores. **Of course, you’d like to maximize the
   score.** Given a particular roll of Sweet Tarts and the preference order of
   the four flavors, you’ll compute the maximum score of the roll -- there may
   be more than one way of realizing the score.

1. Open `sample2.txt` in `src/main/resources`. This file describes zero or more
   Sweet Tarts scenarios. Each non-empty scenario has the following format:

   1. Line 1: Number of sweet tarts in package, say `n`.

   1. Line 2: Flavor preference from low to high (always four)..

   1. Line 3: The ordering for the `n`-many sweet tarts.

   The last scenario is always empty (i.e., `n = 0`).

   **How many non-empty scenarios are described in this file?**

1. Open `SweetTartsDriver.java`. Read through the `main` method and make sure
   you have a good idea of what it does. You should also familiarize yourself
   with the other methods in the file.

1. In `SweetTartsDriver.java`, inspect the method called `score`.
   The initial call to this method is in `main` -- you may assume
   valid initial input.

   1. Before you can write the code, you need to understand how to decompose
      the problem recursively. Attempt to draw the recursion tree for the
      following small example scenario:

      ```
      5
      ABCD
      CAADB
      ```

      The initial call is:

      ```java
      score(value, 0, 4, 1)
      ```

      You may find it easier to abbreviate this as `(0,4,1)` -- subsequent
      recursive calls can be abbreviated similarly `[i]+(l,ht)` where
      `i` denotes the sweet tart index to consume and `l`, `h`, and `t` are
      the abbreviated method parameters. The idea is that `[i]+(l,h,t)`
      represents the value of consuming index `i` on turn `t-1` plus the
      maximum score for the remaining sweet tarts (which will likely
      need to be further decomposed). To help you get started,
      here is the beginning of the tree:

      ```
              (0,4,1)
                 |
                max
               /   \
              /     \
             /       \
            /         \
      [4]+(0,3,2) [0]+(1,4,2)
      ```

      In the example provided,

      * `[4]+(0,3,2)` represents consuming the
        sweet tart value at index `4` on turn `1` plus the maximum score for
        the _remaining_ sweet tarts -- since index `4` was consumed, this
        decreases `h` from `4` to `3`; and

      * `[0]+(1,4,2)` represents consuming the
        sweet tart value at index `0` on turn `1` plus the maximum score for
        the _remaining_ sweet tarts -- since index `0` was consumed, this
        increases `l` from `0` to `1`.

   1. Given your recursion tree, **how do you characterize the
      base case(s)?**

   1. Given your recursion tree, **how do you characterize the
      recursive case(s)?**

1. In `SweetTartsDriver.java`, implement the method called `score`
   **without using loops.** Draw on the problem decomposition you
   derived via your recursion tree to help you write the code.

   To test your code, here is the expected outpur for `sample2.txt`:

   ```
   NumCandies: 14
   14321432143214
   Max Value: 279

   NumCandies: 8
   33333333
   Max Value: 108
   
   NumCandies: 10
   4133333333
   Max Value: 162
   ```

1. Stage and commit your changes locally.

**CHECKPOINT**

1. **[TRICKY]** Write a non-recursive, non-stream method to compute the
   overall maximum score for a sweet tarts problem **using a single
   two-dimensional array** of size `n`-by-`n` in addition to the `values`
   array of length `n = values.length`.

   1. Implement the method.

   1. Provide clear code that demonstrates that it works.

1. Stage and commit your changes locally.

**CHECKPOINT**

1. **[HARD]** Write a non-recursive, non-stream method to compute the
   overall maximum score for a sweet tarts problem **using a single
   one-dimensional array** of length `n` in addition to the `values` array
   of length `n = values.length`.

   1. Implement the method.

   1. Provide clear code that demonstrates that it works.

1. Stage and commit your changes locally.

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell, Brad Barnes, and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
