the same manifests in the final version of the project:

-->   https://github.com/moataz-10/todo-project.git


and after that we apply this query:


kubectl get -n "{staging} or {production}" deploy -o yaml \
    | linkerd inject - \
    | kubectl apply -f - 