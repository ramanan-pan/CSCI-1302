#!/bin/bash -ex
mvn clean
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.ce24.SplitString"
