I used a RestController which runs on 
a tomcat server by default port 8080.

I added the 8080 as a target port in the service which serves the deployment as well.

finally, I added the ingress manifest which maps any requests to the service to the port 2345 