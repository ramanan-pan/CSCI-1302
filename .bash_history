cd ..
cd .
cd ..
cd projects/
ls
git clone --depth 1 https://github.com/cs1302uga/cs1302-gallery.git
ls
cd cs1302-gallery/
ls
find src
cp ../../cs1302/cs1302-ce25 compile.sh .
cp ../../cs1302/cs1302-ce25/compile.sh .
ls
emacs compile.sh 
./compile.sh 
emacs compile.sh 
emacs pom.xml 
./compile.sh 
find src
check1302 src
emacs src/main/java/cs1302/gallery/GalleryDriver.java 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
check1302 src
emacs src/main/java/cs1302/gallery/GalleryApp.java 
check1302 src
clear
ls
emacs src/main/java/cs1302/gallery/GalleryApp.java 
emacs src/main/java/cs1302/gallery/ToolBar.java
./compile.sh 
cd ../..
cd cs1302/
git clone --depth 1 https://github.com/cs1302uga/cs1302-ce26.git
cd cs1302-ce26
ls
find src
emacs pom.xml 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
check1302 src
emacs src/main/java/cs1302/ce26/TTTSolver.java 
cd cs1302/cs1302-ce26
clear
find src
ls
emacs src/main/java/cs1302/ce26/TTTSolver.java 
cp ../cs1302-ce25/compile.sh .
emacs compile.sh 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTUtility.java 
check1302 src
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
mvn clean
mvn compile
check1302 src
git add .
git commit -am "implemented isCat method in TTTUtility.java"
git tag checkpoint-1
git adog
git status
emacs src/main/java/cs1302/ce26/TTTSolver.java 
check1302 src
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
clear
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
check1302 src
emacs src
emacs src/main/java/cs1302/ce26/TTTSolver.java 
check1302 src
./compile.sh 
git add .
git commit -am "implemented printAllBoards method in TTTSolver.java"
git tag checkpoint-2
git adog
git status
list
emacs src/main/java/cs1302/ce26/TTTSolver.java 
cd cs1302/cs1302-ce26
emacs src/main/java/cs1302/ce26/TTTSolver.java 
exit
cd cs1302/cs1302-ce26
emacs src/main/java/cs1302/ce26/TTTSolver.java 
cd cs1302/cs1302-ce26
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
mvn exec:java -Dexec.mainClass="cs1302.ce26.TTTSolver"
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
emacs src/main/java/cs1302/ce26/TTTSolver.java 
./compile.sh 
check1302 src
git add .
git commit -am "implemented countAllWinningBoards method in TTTSolver.java"
git tag checkpoint-3
git adog
git status
emacs SUBMISSION.md
git add SUBMISSION.md 
git commit -am "added SUBMISSION.md file"
git status
check1302 src
cd ..
cd cs1302-ce26
git adog
cd ..
submit cs1302-ce26 cs1302a
ls
git config --global user.name
git config --global user.email
cat ~/.ssh/id_rsa.pub
mvn -B archetype:generate -DartifactId=cs1302-ce27-ce28 -DgroupId=cs1302.sorting -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
ls
cd cs1302-ce27-ce28/
ls
rm -f src/main/java/cs1302/sorting/App.java
rm -rf src/test
find src
git init
emacs .gitignore
git add .gitignore 
git commit -am "added .gitignore"
emacs pom.xml 
git add pom.xml 
git commit -am "updated pom.xml"
touch src/main/java/cs1302/sorting/BubbleSort.java
touch src/main/java/cs1302/sorting/SelectionSort.java
git add src
git commit -am "added blank source code files"
git status
check1302 src
git status
git remote add origin git@github.com:ramanan-pan/cs1302-ce27-ce28.git
git push -u origin master
git status
emacs src/main/java/cs1302/sorting/BubbleSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.BubbleSort"
ls
check1302 src
git add .
git commit -am "added skeleton code to BubbleSort.java"
git status
git push origin master
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.SelectionSort"
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.SelectionSort"
check1302 src
git add .
git commit -am "added skeleton code for SelectionSort.java"
git commit --amend
git adog
git status
git push origin master
git adog
emacs src/main/java/cs1302/sorting/BubbleSort.java 
mvn clean
mvn compile
emacs src/main/java/cs1302/sorting/BubbleSort.java 
mvn clean
mvn compile
emacs src/main/java/cs1302/sorting/BubbleSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/BubbleSort.java 
mvn compile
mvn exec:java -Dexec.mainClass"cs1302.sorting.BubbleSort"
mvn exec:java -Dexec.mainClass="cs1302.sorting.BubbleSort"
check1302 src
emacs src/main/java/cs1302/sorting/BubbleSort.java 
check1302 src
emacs src/main/java/cs1302/sorting/BubbleSort.java 
check1302 src
mvn clean
mvn compile
check1302 src
git add .
git commit -am "checkpoint-2"
git adog
git status
git checkout 35e570b
git tag checkpoint-1
git adog
git checkout master
git tag checkpoint-2
git adog
git status
git push origin master
emacs src/main/java/cs1302/sorting/BubbleSort.java 
mvn clean
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.BubbleSort"
check1302 src
emacs src/main/java/cs1302/sorting/BubbleSort.java 
mvn clean
mvn compile
check1302 src
git add .
git commit -am "checkpoint-3"
git tag checkpoint-3
git push origin master
git adog
ls
emacs NOTES.md
ls
git add .
git commit -am "checkpoint-4"
git tag checkpoint-4
emacs NOTES.md 
git adog
git push origin master
emacs SUBMISSION.md
ls
git add .
git commit -am "added SUBMISSION.md file"
git status
check1302 src
git push origin master
ls
git adog
cd ..
submit cs1302-ce27-ce28/ cs1302a
ls
emacs cs1302-ce27-ce28/
cd cs1302-ce27-ce28/
cleare
clear
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.SelectionSort"
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.SelectionSort"
check1302 src
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
check1302 src
git add .
git commit -am "28-checkpoint-1"
git tag 28-checkpoint-1
git status
git adog
git push origin master
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn clean
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.SelectionSort"
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn clean
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.SelectionSort"
mvn exec:java -Dexec.mainClass="cs1302.sorting.BubbleSort"
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.SelectionSort"
mvn exec:java -Dexec.mainClass="cs1302.sorting.BubbleSort"
emacs src/main/java/cs1302/sorting/SelectionSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.BubbleSort"
mvn exec:java -Dexec.mainClass="cs1302.sorting.SelectionSort"
git adog
check1302 src
git add .
git commit -am "28-checkpoint-2"
git tag 28-checkpoint-2
git push origin master
git status
ls
emacs NOTES.md 
git add .
git commit -am "28-checkpoint-3"
git tag 28-checkpoint-3
git status
git push origin master
emacs src/main/java/cs1302/sorting/QuickSort.java
mvn clean
mvn compile
emacs src/main/java/cs1302/sorting/QuickSort.java
mvn compile
exit
cd cs1302/cs1302-ce27-ce28/
emacs src/main/java/cs1302/sorting/QuickSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/QuickSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.QuickSort"
emacs src/main/java/cs1302/sorting/QuickSort.java 
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.QuickSort"
emacs src/main/java/cs1302/sorting/QuickSort.java 
mvn clean
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.sorting.QuickSort"
check1302 src
emacs src/main/java/cs1302/sorting/QuickSort.java 
mvn compile
check1302 src
git add .
git commit -am "28-checkpoint-4"
git tag 28-checkpoint-4
git status
git push origin master
git adog
emacs src/main/java/cs1302/sorting/QuickSort.java 
check1302 src
mvn compile
emacs src/main/java/cs1302/sorting/QuickSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/QuickSort.java 
mvn compile
emacs src/main/java/cs1302/sorting/QuickSort.java 
mvn exec:java -Dexec.mainClass="cs1302.sorting.QuickSort"
check1302 src
git add .
git commit -am "28-checkpoint-5"
git tag 28-checkpoint-5
git status
git push origin master
git adog
emacs NOTES.md 
git add .
git commit -am "28-checkpoint-6"
git tag 28-checkpoint-6
git status
check1302 src
git push origin master
emacs SUBMISSION.md
git status
git add ..
git add .
git commit -am "SUBMISSION.md"
git adog
ls
cd ..
submit cs1302-ce27-ce28/ cs1302a
ls
ls cs1302-ce27-ce28/
exit
cd cs1302/cs1302-ce27-ce28/
emacs NOTES.md 
exit
cd cs1302/
git clone --depth 1 git@github.com:ramanan-pan/cs1302-ce29.git cs1302-ce29
cd cs1302-ce29
ls
git remote add skeleton https://github.com/cs1302uga/cs1302-ce29.git
ls
git pull skeleton master
ls
git push origin master
find src
ls
emacs pom.xml 
cd cs1302/cs1302-ce29/
ls
find src
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
ls
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
check1302 src
emacs src/main/java/cs1302/ce29/ChartUtility.java 
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
check1302 src
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
check1302 src
git add .
git commit -am "checkpoint-1"
git tag checkpoint-1
git push origin master
git adog
cd cs1302/cs1302-ce29
ls
git status
emacs src/main/java/cs1302/ce29/ChartUtility.java 
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
git add .
git commit -am "step 1"
emacs Notes.md
git add Notes.md 
emacs Notes.md
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
mak
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
emacs Notes.md 
fg %1
check1302 src
git add .
git commit -am "checkpoint-2"
git tag checkpoint-2
git push origin master
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
emacs Notes.md 
check1302 src
git add .
git commit -am "checkpoint-3"
git tag checkpoint-3
git push origin master
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
emacs  Notes.md 
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs src/main/java/cs1302/ce29/ComplexityClasses.java 
make
emacs Notes.md 
check1302 src
git add .
git commit -am "checkpoint-4"
git tag checkpoint-4
git push origin master
git status
emacs SUBMISSION.md
emacs Notes.md 
git add SUBMISSION.md 
git commit -am "added SUBMISSION.md"
git status
check1302 src
emacs SUBMISSION.md 
ls
cd ..
cd cs1302-ce29
git push origin master
cd ..
submit cs1302-ce29 cs1302a
ls cs1302-ce29
cd projects/cs1302-gallery/
clear
ls
emacs compile.sh 
find src
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryPane.java
emacs src/main/java/cs1302/gallery/ToolBar.java 
emacs src/main/java/cs1302/gallery/GalleryPane.java
emacs src/main/java/cs1302/gallery/GalleryApp.java 
emacs src/main/java/cs1302/gallery/ToolBar.java 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
ls ../../cs1302/cs1302-ce20/resources/
cp ../../cs1302/cs1302-ce20/resources/ .
ls
cp -r ../../cs1302/cs1302-ce20/resources/ .
ls
ls resources/
rm resources/actual-size-50.png 
rm resources/zoom-out-50.png 
rm resources/zoom-in-50.png 
ls resources/
emacs src/main/java/cs1302/gallery/Gallery
emacs src/main/java/cs1302/gallery/GalleryPane.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs ../../cs1302/cs1302-ce20/src/cs1302/ce20/ImageApp.java 
./compile.sh 
emacs ../../cs1302/cs1302-ce20/src/cs1302/ce20/ImageApp.java 
cd projects/cs1302-gallery/
ls
find src
./compile.sh 
clear
ls
find src
emacs src/main/java/cs1302/gallery/GalleryPane.java 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
emacs src/main/java/cs1302/gallery/GalleryPane.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryPane.java 
./compile.sh 
cd projects/cs1302-gallery/
clear
emacs compile.sh 
emac src/main/java/cs1302/gallery/ToolBar.java 
emacs src/main/java/cs1302/gallery/ToolBar.java 
mvn clean
mvn compile
emacs src/main/java/cs1302/gallery/ToolBar.java 
mvn compile
emacs src/main/java/cs1302/gallery/ToolBar.java 
mvn compile
emacs src/main/java/cs1302/gallery/ToolBar.java 
mvn compile.sh 
mvn compile
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
cd projects/cs1302-gallery/
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryPane.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
exit
cd projects/cs1302-gallery/
ls
find src
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
fg %1
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
cd projects/cs1302-gallery/
emacs src/main/java/cs1302/gallery/ToolBar.java 
clear
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
clear
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
fg %1
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
check1302 src
emacs src/main/java/cs1302/gallery/ToolBar.java 
check1302 src
emacs src/main/java/cs1302/gallery/GalleryPane.java 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
emacs src/main/java/cs1302/gallery/ToolBar.java 
clear
check1302 src
cd projects/cs1302-gallery/
clear
ls
ls resources/
rm resources/default.png 
find src
emacs src/main/java/cs1302/gallery/GalleryDriver.java 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
cd projects/cs1302-gallery/
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
clear
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
cd projects/cs1302-gallery/
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
./compile.sh 
exit
cd projects/cs1302-gallery/
./compile.sh 
check1302 src
emacs src/main/java/cs1302/gallery/ToolBar.java 
check1302 src
clear
./compile.sh 
exit
cd projects/cs1302-gallery/
./compile.sh 
exit
./compile.sh 
cd projects/cs1302-gallery/
./compile.sh 
cd projects/cs1302-gallery/
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
check1302 src
emacs src/main/java/cs1302/gallery/GalleryApp.java 
find src
emacs src/main/java/cs1302/gallery/AboutStage.java
./compile.sh 
emacs src/main/java/cs1302/gallery/AboutStage.java
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/AboutStage.java 
ls resources/
rm resources/about.jpg 
ls resources/
emacs src/main/java/cs1302/gallery/AboutStage.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/AboutStage.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
check1302 src
emacs src/main/java/cs1302/gallery/AboutStage.java 
check1302 src
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
check1302 src
ls
ls resources/
emacs ../cs1302-minesweeper-alpha-fixed/EXTRA.md 
emacs EXTRA.md
ls
git add .
git commit -am "commit 1"
git status
find src
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/GalleryApp.java 
./compile.sh 
emacs src/main/java/cs1302/gallery/AboutStage.java 
./compile.sh 
check1302 src
git add .
git commit -am "commit 2"
git status
git adog
ls
cd ..
cd cs1302-gallery/
mkdir doc
ls
javadoc -d doc -sourcepath src -subpackages cs1302
find src
javadoc -d doc -sourcepath src/main/java/ -subpackages cs1302
ln -s $(pwd)/doc ~/public_html/cs1302-gallery-doc
emacs src/main/java/cs1302/gallery/ToolBar.java 
javadoc -d doc -sourcepath src/main/java/ -subpackages cs1302
clear
ls
git add .
git commit -am "generated doc"
git status
git adog
cd ..
cd cs1302-gallery/
./compile.sh 
emacs src/main/java/cs1302/gallery/ToolBar.java 
git status
cd ..
submit cs1302-gallery/ cs1302a
ls cs1302-gallery/
cd cs1302-gallery/
exit
cd projects/cs1302-gallery/
./compile.sh 
ls
check1302 src/
exit
cd projects/cs1302-gallery/
ls
./compile.sh 
git status
cd cs1302/
git clone --depth 1 https://github.com/cs1302uga/cs1302-ce32.git
ls
cd cs1302-ce32/
clear
ls
emacs pom.xml 
find src
make
clear
find src
emacs src/main/resources/sample1.txt 
emacs src/main/java/cs1302/ce32/MyFaceDriver.java 
make
emacs src/main/java/cs1302/ce32/MyFaceDriver.java 
exit
cd cs1302/cs1302-ce23/
clear
ls
cd cs1302-ce23-mvn/
ls
find src
emacs src/main/java/cs1302/ce23/StreamPractice.java 
cd ../../cs1302-ce24
ls
find src
emacs src/main/java/cs1302/ce24/Fac.java 
cd ../cs1302-ce25
ls
find src
emacs src/main/java/cs1302/ce25/Find.java 
cd ../cs1302-ce26
ls
find src
emacs src/main/java/cs1302/ce26/TTTSolver.java 
cd ../cs1302-ce27
cd ..
ls
cd cs1302-ce27-ce28/
ls
find src
emacs src/main/java/cs1302/sorting/BubbleSort.java 
cd ..
ls
cd cs1302-generic-types/
ls
find src
emacs src/cs1302/generics/Driver.java 
cd ..
ls
cd cs1302-ce27-ce28/
ls
emacs NOTES.md 
cd ..
cd cs1302-ce27-ce28/
emacs NOTES.md 
cd ..
ls
cd cs1302-streams/
ls
find src
emacs src/cs1302/timestream/TimeStreamDriver.java 
javac -d bin src/cs1302/timestream/TimeStreamDriver.java 
javac -d bin src/cs1302/timestream/Dates.java 
javac -d bin -cp bin src/cs1302/timestream/TimeStreamDriver.java 
java -cp bin TimeStreamDriver.java
java -cp bin TimeStreamDriver
java -cp bin cs1302.timestream.TimeStreamDriver
emacs src/cs1302/timestream/TimeStreamDriver.java 
javac -d bin -cp bin src/cs1302/timestream/TimeStreamDriver.java 
java -cp bin cs1302.timestream.TimeStreamDriver
emacs src/cs1302/timestream/TimeStreamDriver.java 
javac -d bin -cp bin src/cs1302/timestream/TimeStreamDriver.java 
java -cp bin cs1302.timestream.TimeStreamDriver
emacs src/cs1302/timestream/TimeStreamDriver.java 
javac -d bin -cp bin src/cs1302/timestream/TimeStreamDriver.java 
java -cp bin cs1302.timestream.TimeStreamDriver
cd ..
ls
cd cs1302-ce27-ce28/
ls
find src
emacs src/main/java/cs1302/sorting/InsertionSort.java
ls
mvn compile
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn clean
mvn compile
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target cs1302.sorting.InsertionSort
find src
ls
find target/
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
java -cp target/classes/ cs1302.sorting.InsertionSort
pwd
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
emacs src/main/java/cs1302/sorting/InsertionSort.java
mvn compile
ls
emacs notes.txt 
ls cs1302/
ls projects/
ls public_html/
git
ls
git init
echo "# cs1302" >> README.md
ls
git add README.md 
git add
git status
git stage
git add -a
git add -all
git add -A
git status
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/ramanan-pan/cs1302.git
git push -u origin main
git config -l | grep url
git remote set-url origin "https://ramanan-pan@github.com/ramanan-pan/cs1302.git"
git config -l | grep url
git push -u origin main
