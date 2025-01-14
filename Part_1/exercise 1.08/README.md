The same version of Project:v0.4 which passes environment variable to the deployment resource which is
port 8811 for tomcat server 

while the service targetport is 8811 too.

finally the ingress resource translates any request to the service through the port we specified in the service resource 
which is 2345.