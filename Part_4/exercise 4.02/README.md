Project:v1.7

In this exercise I added a readiness probe and liveness probe so that If
the backend cannot connect to the database it can't recieve requests and at the sametime it can
kill and restart the pod if it still didn't connect.