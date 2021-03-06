# Use Oracle JDK Installation
export JAVA_HOME=/usr/local/alt-java/jdk1.8.0_192
# Update executable path
export PATH=$JAVA_HOME/bin:$PATH
# Use a custom prompt
export PS1='\u@\h:\w$ '
alias emacs='emacs -nw'
# setup checkstyle
export PATH=/usr/local/checkstyle:$PATH
alias check1302="checkstyle -c cs1302_checks.xml"
# Apache Maven
export MAVEN_HOME=/usr/local/maven/apache-maven-3.6.1
export PATH=$MAVEN_HOME/bin:$PATH
