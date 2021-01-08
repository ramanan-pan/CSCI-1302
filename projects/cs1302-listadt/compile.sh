#!/bin/bash -x
javac -d bin -cp listadt.jar src/cs1302/list/AbstractStringList.java
javac -d bin -cp listadt.jar:bin src/cs1302/list/ArrayStringList.java
javac -d bin -cp listadt.jar:bin src/cs1302/list/LinkedStringList.java
