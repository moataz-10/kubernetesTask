
for this exercise: I added a Stateful resource for the database and I used Postgres db 


I passed the env variable for the db through a configMap and the password through secret resource and I encrypted it using SOPS

I also modified the code of the java spring boot app to make the endpoint listens on the db.