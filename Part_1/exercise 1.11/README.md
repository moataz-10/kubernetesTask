I made a local Persistent Volume between the two different Deployments (ping-pong,log-output)

note: the docker images of the app is on DockerHub you just need to apply the manifests 

and make sure that the proxy maps the 8081 to the open port 80

To request the ping-pong --> http://localhost:8081/pingpong

To request the log-output --> http://localhost:8081/

These paths were specified before through the ingress resource.