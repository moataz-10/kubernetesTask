Project:v1.4.1

In this exercise It's all set up to be automatically deployed for each part the backend,frontend and database and also creating a new branch
will add a new namesapce to be deployed on.


NOTE* : The secrets for the database cannot be pushed to the version control untill it's encrypted
so I added sops and age in the workflow so that I can decrypt it with the "secrets.SOPS_AGE_KEY" -> the private key
which will be passed as a secret for github secrets of the repo. 