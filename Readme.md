Small Fastwritten Demoapplication :

- Starts a Producer which creates Messages 
- Consumer is realised with DefaultMessageListenerContainer

Start Sample: 
mvn clean compile exec:java -Dexec.mainClass=de.mgm.activemqtest.App
 
Start ActiveMQ : 
mvn org.apache.activemq.tooling:maven-activemq-plugin:5.4.3:run
  