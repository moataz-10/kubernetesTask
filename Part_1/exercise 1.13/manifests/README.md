I used in this exercise node.js which will serve as a frontend

I also used a persistent volume on the host agent0 "/tmp/img" which serves as image cash

I implemented the ingress,service,deployment resources 

hit this URL http://localhost:8081 and make sure you mapped the 8081:80 in the proxy

and the proxy will reach the -> service on (2345) and the service will reach 

the --> deployment on the targetport 3000 which node server runs on!