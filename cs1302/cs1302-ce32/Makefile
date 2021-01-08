
MyFaceDriver: compile
	export MAVEN_OPTS=-Dprism.order=sw; \
	mvn -e exec:java -Dexec.mainClass="cs1302.ce32.MyFaceDriver"

SweetDriver: compile
	export MAVEN_OPTS=-Dprism.order=sw; \
	mvn -e exec:java -Dexec.mainClass="cs1302.ce32.SweetTartsDriver"

compile:
	mvn -e compile

clean:
	mvn clean

doc:
	mvn javadoc:javadoc
