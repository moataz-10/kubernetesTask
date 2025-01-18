In the logs-app application I added a function to retrieve data
from an endpoint using RestTemplate because Iam using Spring boot

and in the URL request It was "http://pingpong-sve:2222/getCount" 

which is the name of the service and the port it listens on.

*Note: I added the two deployments into a namespace called ns-pong-output

for this exercise: I modified the image for the source code to read a file which I mounted using configMap

and also I passed the variable through config map too.