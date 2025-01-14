I added an Ingress resource for the both programs:

ping-pong application and log_output application,

stating the path "/" to let the ingress controller forwards any requests starts with slash to 
port 2345 which is the log_output service port 

while stating the path "/pingpong" to let the ingress controller forwards any requests starts with this prefix to be forwarded to ping-pong service port which is 2222