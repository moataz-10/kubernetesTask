Project:v2.0


In this exercise:-


->   I modified the backend by adding a new service responsible to connect to NATS
and send the todo after saving or updating it to the message queue controlled by NATS

->   I also implemented the broadcaster service independently and added the manifests and the 
secrets("encrypted using SOPS and AGE") responsible to run the service which is the NATS_URL and the api token of the EXTERNAL_SERVICE_URL

->   As for subscription and labeling, It's implemented inside the code of both applications with the help of NATS library in spring boot
you can check how the implementation is done by Roaming through the source code that I pushed too.

