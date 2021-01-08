MAIN_CLASS = cs1302.ce29.ChartDriver

run: compile
	export MAVEN_OPTS=-Dprism.order=sw; \
	mvn exec:java -Dexec.mainClass="$(MAIN_CLASS)"

compile:
	mvn -e compile

clean:
	mvn clean

doc:
	mvn javadoc:javadoc
