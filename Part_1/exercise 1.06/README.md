I'm using a spring boot as a framework

specifically I'm using a tomcat server which runs by default on port 8080

But I created an env variable in src/main/resources/application.properties labeled "PORT" 

and I added the env variable in the manifests/deployment.yaml

I added the service.yaml file in the manifests to project:v0.4

while the target port for the service.yaml in the deployment is the same which we passed as an environment variable for our simple project which is 8811