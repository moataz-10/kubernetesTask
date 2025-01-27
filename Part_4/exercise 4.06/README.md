Project:v2.0


In this exercise:-


->   I modified the backend by adding a new service responsible to connect to NATS
and send the todo after saving or updating it to the message queue controlled by NATS

->   I also implemented the broadcaster service independently and added the manifests and the 
secrets("encrypted using SOPS and AGE") responsible to run the service in an organized way.

