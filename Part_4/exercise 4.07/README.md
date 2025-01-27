
for this exercise: 

->  I set a workflow for each app and the kustomization resource for each one so that when commiting it will 
build the image and push it to the docker hub registry and then editing the kustomization with the new image and tag

->  And as ARGO/CD is watching the kustomization file in the repo it will update the deployment as soon as it's edited with the new image.