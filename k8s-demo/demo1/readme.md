


```sh

docker build . -t jyasu/hellok8s:v1
docker images

docker run -p 3000:3000 --name hellok8s -d jyasu/hellok8s:v1

curl localhost:3000 

docker push jyasu/hellok8s:v1

kubectl apply -f nginx.yaml        
# pod/nginx-pod created

kubectl get pods
# nginx-pod         1/1     Running   0           6s

kubectl port-forward nginx-pod 4000:80
# Forwarding from 127.0.0.1:4000 -> 80
# Forwarding from [::1]:4000 -> 80

curl localhost:4000

kubectl exec -it nginx-pod /bin/bash

echo "hello kubernetes by nginx!" > /usr/share/nginx/html/index.html

kubectl port-forward nginx-pod 4000:80

kubectl logs -f nginx-pod
                              
kubectl exec nginx-pod -- ls

kubectl delete pod nginx-pod
# pod "nginx-pod" deleted

kubectl delete -f nginx.yaml
# pod "nginx-pod" deleted

kubectl apply -f hellok8s.yaml

kubectl get pods

kubectl port-forward hellok8s 3000:3000

kubectl apply -f deployment.yaml

kubectl get deployments
#NAME                  READY   UP-TO-DATE   AVAILABLE   AGE
#hellok8s-deployment   1/1     1            1           39s

kubectl get pods --watch

kubectl get pods             
#NAME                                   READY   STATUS    RESTARTS   AGE
#hellok8s-deployment-77bffb88c5-qlxss   1/1     Running   0          119s

kubectl delete pod hellok8s-deployment-5d968bd797-ds4jw 
#pod "hellok8s-deployment-77bffb88c5-qlxss" deleted

kubectl get pods                                       
#NAME                                   READY   STATUS    RESTARTS   AGE
#hellok8s-deployment-77bffb88c5-xp8f7   1/1     Running   0          18s

docker build . -t jyasu/hellok8s:v2
docker push jyasu/hellok8s:v2

kubectl apply -f deployment.yaml
# deployment.apps/hellok8s-deployment configured

kubectl get pods                
# NAME                                   READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-66799848c4-kpc6q   1/1     Running   0          3s
# hellok8s-deployment-66799848c4-pllj6   1/1     Running   0          3s
# hellok8s-deployment-66799848c4-r7qtg   1/1     Running   0          3s

kubectl port-forward hellok8s-deployment-5d46d55c9b-qd4qp  3000:3000
# Forwarding from 127.0.0.1:3000 -> 3000
# Forwarding from [::1]:3000 -> 3000

# open another terminal
curl http://localhost:3000
# [v2] Hello, Kubernetes!


kubectl rollout undo deployment hellok8s-deployment

kubectl get pods                                    
# NAME                                   READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-77bffb88c5-cvm5c   1/1     Running   0          39s
# hellok8s-deployment-77bffb88c5-lktbl   1/1     Running   0          41s
# hellok8s-deployment-77bffb88c5-nh82z   1/1     Running   0          37s

kubectl describe pod hellok8s-deployment-77bffb88c5-cvm5c | grep Image
# Image: guangzhengli/hellok8s:v1

kubectl rollout history deployment hellok8s-deployment
kubectl rollout undo deployment/hellok8s-deployment --to-revision=2

kubectl apply -f deployment.yaml


docker build . -t jyasu/hellok8s:liveness
docker push jyasu/hellok8s:liveness


kubectl apply -f deployment.yaml

kubectl get pods
# NAME                                   READY   STATUS    RESTARTS     AGE
# hellok8s-deployment-5995ff9447-d5fbz   1/1     Running   4 (6s ago)   102s
# hellok8s-deployment-5995ff9447-gz2cx   1/1     Running   4 (5s ago)   101s
# hellok8s-deployment-5995ff9447-rh29x   1/1     Running   4 (6s ago)   102s

kubectl describe pod hellok8s-68f47f657c-zwn6g

# ...
# ...
# ...
# Events:
#  Type     Reason     Age                   From               Message
#  ----     ------     ----                  ----               -------
#  Normal   Scheduled  12m                   default-scheduler  Successfully assigned default/hellok8s-deployment-5995ff9447-rh29x to minikube
#  Normal   Pulled     11m (x4 over 12m)     kubelet            Container image "guangzhengli/hellok8s:liveness" already present on machine
#  Normal   Created    11m (x4 over 12m)     kubelet            Created container hellok8s-container
#  Normal   Started    11m (x4 over 12m)     kubelet            Started container hellok8s-container
#  Normal   Killing    11m (x3 over 12m)     kubelet            Container hellok8s-container failed liveness probe, will be restarted
#  Warning  Unhealthy  11m (x10 over 12m)    kubelet            Liveness probe failed: HTTP probe failed with statuscode: 500
#  Warning  BackOff    2m41s (x36 over 10m)  kubelet            Back-off restarting failed container

docker build . -t jyasu/hellok8s:bad

docker push jyasu/hellok8s:bad

kubectl apply -f deployment.yaml

kubectl get pods                
# NAME                                   READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-66799848c4-8xzsz   1/1     Running   0          102s
# hellok8s-deployment-66799848c4-m9dl5   1/1     Running   0          102s
# hellok8s-deployment-9c57c7f56-rww7k    0/1     Running   0          26s
# hellok8s-deployment-9c57c7f56-xt9tw    0/1     Running   0          26s


kubectl describe pod hellok8s-deployment-9c57c7f56-rww7k
# Events:
#   Type     Reason     Age                From               Message
#   ----     ------     ----               ----               -------
#   Normal   Scheduled  74s                default-scheduler  Successfully assigned default/hellok8s-deployment-9c57c7f56-rww7k to minikube
#   Normal   Pulled     73s                kubelet            Container image "guangzhengli/hellok8s:bad" already present on machine
#   Normal   Created    73s                kubelet            Created container hellok8s-container
#   Normal   Started    73s                kubelet            Started container hellok8s-container
#   Warning  Unhealthy  0s (x10 over 72s)  kubelet            Readiness probe failed: HTTP probe failed with statuscode: 500


docker build . -t jyasu/hellok8s:v3

docker push jyasu/hellok8s:v3

kubectl apply -f deployment.yaml

kubectl apply -f service-hellok8s-clusterip.yaml

kubectl get endpoints
# NAME                         ENDPOINTS                                          AGE
# service-hellok8s-clusterip   172.17.0.10:3000,172.17.0.2:3000,172.17.0.3:3000   10s

kubectl get pod -o wide
# NAME                                   READY   STATUS    RESTARTS   AGE    IP           NODE 
# hellok8s-deployment-5d5545b69c-24lw5   1/1     Running   0          112s   172.17.0.7   minikube 
# hellok8s-deployment-5d5545b69c-9g94t   1/1     Running   0          112s   172.17.0.3   minikube
# hellok8s-deployment-5d5545b69c-9gm8r   1/1     Running   0          112s   172.17.0.2   minikube
# nginx                                  1/1     Running   0          112s   172.17.0.9   minikube

kubectl get service
# NAME                         TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)    AGE
# service-hellok8s-clusterip   ClusterIP   10.104.96.153   <none>        3000/TCP   10s

kubectl get pods
# NAME                                   READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-5d5545b69c-24lw5   1/1     Running   0          27m
# hellok8s-deployment-5d5545b69c-9g94t   1/1     Running   0          27m
# hellok8s-deployment-5d5545b69c-9gm8r   1/1     Running   0          27m
# nginx                                  1/1     Running   0          41m

kubectl get service
# NAME                         TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)    AGE
# service-hellok8s-clusterip   ClusterIP   10.104.96.153   <none>        3000/TCP   10s

kubectl exec -it nginx-pod /bin/bash
# root@nginx-pod:/# curl 10.104.96.153:3000
# [v3] Hello, Kubernetes!, From host: hellok8s-deployment-5d5545b69c-9gm8r
# root@nginx-pod:/# curl 10.104.96.153:3000
#[v3] Hello, Kubernetes!, From host: hellok8s-deployment-5d5545b69c-9g94t

kubectl apply -f service-hellok8s-nodeport.yaml

kubectl get service
# NAME                         TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
# service-hellok8s-nodeport    NodePort    10.109.188.161   <none>        3000:30000/TCP   28s

kubectl get pods
# NAME                                   READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-5d5545b69c-24lw5   1/1     Running   0          27m
# hellok8s-deployment-5d5545b69c-9g94t   1/1     Running   0          27m
# hellok8s-deployment-5d5545b69c-9gm8r   1/1     Running   0          27m

curl http://192.168.59.100:30000
# [v3] Hello, Kubernetes!, From host: hellok8s-deployment-5d5545b69c-9g94t

curl http://192.168.59.100:30000
# [v3] Hello, Kubernetes!, From host: hellok8s-deployment-5d5545b69c-24lw5

curl http://$(minikube ip):30000

minikube addons enable ingress

kubectl delete deployment,service --all

kubectl apply -f hellok8s.yaml                 
# service/service-hellok8s-clusterip created
# deployment.apps/hellok8s-deployment created

kubectl apply -f nginx.yaml   
# service/service-nginx-clusterip created
# deployment.apps/nginx-deployment created

kubectl get pods            
# NAME                                   READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-5d5545b69c-4wvmf   1/1     Running   0          55s
# hellok8s-deployment-5d5545b69c-qcszp   1/1     Running   0          55s
# hellok8s-deployment-5d5545b69c-sn7mn   1/1     Running   0          55s
# nginx-deployment-d47fd7f66-d9r7x       1/1     Running   0          34s
# nginx-deployment-d47fd7f66-hp5nf       1/1     Running   0          34s

kubectl get service
# NAME                         TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)    AGE
# service-hellok8s-clusterip   ClusterIP   10.97.88.18      <none>        3000/TCP   77s
# service-nginx-clusterip      ClusterIP   10.103.161.247   <none>        4000/TCP   56s

kubectl apply -f ingress.yaml
# ingress.extensions/hello-ingress created

kubectl get ingress          
# NAME            CLASS   HOSTS   ADDRESS   PORTS   AGE
# hello-ingress   nginx   *                 80      16s

# replace 192.168.59.100 by your minikube ip
curl http://$(minikube ip)/hello
# [v3] Hello, Kubernetes!, From host: hellok8s-deployment-5d5545b69c-sn7mn

curl http://$(minikube ip)/
# (....Thank you for using nginx.....)

kubectl apply -f namespaces.yaml    
# namespace/dev created
# namespace/test created


kubectl get namespaces          
# NAME              STATUS   AGE
# default           Active   215d
# dev               Active   2m44s
# ingress-nginx     Active   110d
# kube-node-lease   Active   215d
# kube-public       Active   215d
# kube-system       Active   215d
# test              Active   2m44s

kubectl apply -f deployment.yaml -n dev

kubectl get pods -n dev

docker build . -t jyasu/hellok8s:v4
docker push jyasu/hellok8s:v4

kubectl delete deployment,service,ingress --all

kubectl apply -f hellok8s-config-dev.yaml -n dev
# configmap/hellok8s-config created

kubectl apply -f hellok8s-config-test.yaml -n test 
# configmap/hellok8s-config created

kubectl get configmap --all-namespaces
NAMESPACE         NAME                                 DATA   AGE
dev               hellok8s-config                      1      3m12s
test              hellok8s-config                      1      2m1s

kubectl apply -f hellok8s.yaml -n dev             
# pod/hellok8s-pod created

kubectl apply -f hellok8s.yaml -n test
# pod/hellok8s-pod created

kubectl port-forward hellok8s-pod 3000:3000 -n dev

curl http://localhost:3000
# [v4] Hello, Kubernetes! From host: hellok8s-pod, Get Database Connect URL: http://DB_ADDRESS_DEV

kubectl port-forward hellok8s-pod 3000:3000 -n test

curl http://localhost:3000
# [v4] Hello, Kubernetes! From host: hellok8s-pod, Get Database Connect URL: http://DB_ADDRESS_TEST

echo "db_password" | base64
# ZGJfcGFzc3dvcmQK

echo "ZGJfcGFzc3dvcmQK" | base64 -d
# db_password


docker build . -t jyasu/hellok8s:v5

docker push jyasu/hellok8s:v5

kubectl apply -f hellok8s-secret.yaml

kubectl apply -f hellok8s.yaml

kubectl port-forward hellok8s-pod 3000:3000


kubectl apply -f hello-job.yaml

kubectl get jobs                  
# NAME        COMPLETIONS   DURATION   AGE
# hello-job   5/5           19s        83s

kubectl get pods                      
# NAME                                   READY   STATUS      RESTARTS   AGE
# hello-job--1-5gjjr                     0/1     Completed   0          34s
# hello-job--1-8ffmn                     0/1     Completed   0          26s
# hello-job--1-ltsvm                     0/1     Completed   0          34s
# hello-job--1-mttwv                     0/1     Completed   0          29s
# hello-job--1-ww2qp                     0/1     Completed   0          34s

kubectl logs -f hello-job--1-5gjjr 
# 1
# ...

kubectl delete -f hello-job.yaml

kubectl describe pod hello-job-2wz67


kubectl apply -f hello-cronjob.yaml
# cronjob.batch/hello-cronjob created

kubectl get cronjob                
# NAME            SCHEDULE    SUSPEND   ACTIVE   LAST SCHEDULE   AGE
# hello-cronjob   * * * * *   False     0        <none>          8s

kubectl get pods   
# NAME                                   READY   STATUS      RESTARTS   AGE
# hello-cronjob-27694609--1-2nmdx        0/1     Completed   0          15s

helm repo add hellok8s https://guangzhengli.github.io/k8s-tutorials/
# "hellok8s" has been added to your repositories

helm install my-hello-helm hellok8s/hello-helm --version 0.1.0
# NAME: my-hello-helm
# NAMESPACE: default
# STATUS: deployed
# REVISION: 1


kubectl get pods
# NAME                                  READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-f88f984c6-k8hpz   1/1     Running   0          15h
# hellok8s-deployment-f88f984c6-nzwg6   1/1     Running   0          15h
# hellok8s-deployment-f88f984c6-s89s7   1/1     Running   0          15h
# nginx-deployment-d47fd7f66-6w76b      1/1     Running   0          15h
# nginx-deployment-d47fd7f66-tsqj5      1/1     Running   0          15h

kubectl get deployments
# NAME                  READY   UP-TO-DATE   AVAILABLE   AGE
# hellok8s-deployment   3/3     3            3           15h
# nginx-deployment      2/2     2            2           15h

kubectl get service
# NAME                         TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)    AGE
# kubernetes                   ClusterIP   10.96.0.1        <none>        443/TCP    13d
# service-hellok8s-clusterip   ClusterIP   10.107.198.175   <none>        3000/TCP   15h
# service-nginx-clusterip      ClusterIP   10.100.144.49    <none>        4000/TCP   15h

kubectl get ingress
# NAME               CLASS   HOSTS   ADDRESS     PORTS   AGE
# hellok8s-ingress   nginx   *       localhost   80      15h

kubectl get configmap
# NAME               DATA   AGE
# hellok8s-config    1      15h

kubectl get secret
# NAME                                  TYPE                                  DATA   AGE
# hellok8s-secret                       Opaque                                1      15h
# sh.helm.release.v1.my-hello-helm.v1   helm.sh/release.v1

curl http://$(minikube ip)/hello
# [v6] Hello, Helm! Message from helm values: It works with Helm Values[v2]!, From namespace: default, From host: hellok8s-deployment-598bbd6884-ttk78, Get Database Connect URL: http://DB_ADDRESS_DEFAULT, Database Connect Password: db_password

helm uninstall my-hello-helm


helm create hello-helm
tree hello-helm
# hello-helm
# ├── Chart.yaml
# ├── charts
# ├── templates
# │   ├── NOTES.txt
# │   ├── _helpers.tpl
# │   ├── deployment.yaml
# │   ├── hpa.yaml
# │   ├── ingress.yaml
# │   ├── service.yaml
# │   ├── serviceaccount.yaml
# │   └── tests
# │       └── test-connection.yaml
# └── values.yaml


docker build . -t jyasu/hellok8s:v6

docker push jyasu/hellok8s:v6


helm upgrade --install hello-helm --values values.yaml .
# Release "hello-helm" does not exist. Installing it now.
# NAME: hello-helm
# NAMESPACE: default
# STATUS: deployed
# REVISION: 1

curl http://$(minikube ip)/hello
# [v6] Hello, Helm! Message from helm values: It works with Helm Values!, From namespace: default, From host: hellok8s-deployment-57d7df7964-m6gcc, Get Database Connect URL: http://DB_ADDRESS_DEFAULT, Database Connect Password: db_password

kubectl get pods
# NAME                                  READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-f88f984c6-k8hpz   1/1     Running   0          32m
# hellok8s-deployment-f88f984c6-nzwg6   1/1     Running   0          32m
# hellok8s-deployment-f88f984c6-s89s7   1/1     Running   0          32m
# nginx-deployment-d47fd7f66-6w76b      1/1     Running   0          32m
# nginx-deployment-d47fd7f66-tsqj5      1/1     Running   0          32m

➜  helm upgrade --install hello-helm --values values.yaml .
# Release "hello-helm" has been upgraded. Happy Helming!
# NAME: hello-helm
# LAST DEPLOYED: Sat Mar 18 05:44:29 2023
# NAMESPACE: default
# STATUS: deployed
# REVISION: 2
# TEST SUITE: None

curl http://$(minikube ip)/hello
# [v6] Hello, Helm! Message from helm values: It works with Helm Values[v2]!, From namespace: default, From host: hellok8s-deployment-598bbd6884-4b9bw, Get Database Connect URL: http://DB_ADDRESS_DEFAULT, Database Connect Password: db_password


helm ls
# NAME            NAMESPACE       REVISION          STATUS          CHART                   APP VERSION
# hello-helm      default         2                 deployed        hello-helm-0.1.0        1.16.0 

helm rollback hello-helm 1
# Rollback was a success! Happy Helming!

helm ls
# NAME            NAMESPACE       REVISION          STATUS          CHART                   APP VERSION
# hello-helm      default         3                 deployed        hello-helm-0.1.0        1.16.0 

curl http://$(minikube ip)/hello
# [v6] Hello, Helm! Message from helm values: It works with Helm Values!, From namespace: default, From host: hellok8s-deployment-57d7df7964-482xw, Get Database Connect URL: http://DB_ADDRESS_DEFAULT, Database Connect Password: db_password


helm upgrade --install hello-helm -f values.yaml -f values-dev.yaml -n dev .

# Release "hello-helm" does not exist. Installing it now.
# NAME: hello-helm
# NAMESPACE: dev
# STATUS: deployed
# REVISION: 1

curl http://192.168.59.100/hello
# [v6] Hello, Helm! Message from helm values: It works with Helm Values values-dev.yaml!, From namespace: dev, From host: hellok8s-deployment-f5fff9df-89sn6, Get Database Connect URL: http://DB_ADDRESS_DEV, Database Connect Password: db_password_dev

kubectl get pods -n dev
# NAME                                 READY   STATUS    RESTARTS   AGE
# hellok8s-deployment-f5fff9df-89sn6   1/1     Running   0          4m23s
# hellok8s-deployment-f5fff9df-tkh6g   1/1     Running   0          4m23s
# hellok8s-deployment-f5fff9df-wmlpb   1/1     Running   0          4m23s
# nginx-deployment-d47fd7f66-cdlmf     1/1     Running   0          4m23s
# nginx-deployment-d47fd7f66-cgst2     1/1     Running   0          4m23s

helm upgrade --install hello-helm -f values.yaml -f values-dev.yaml --set application.hellok8s.message="It works with set helm values" -n dev .


helm package hello-helm
# Successfully packaged chart and saved it to: /Users/guangzheng.li/workspace/k8s-tutorials/hello-helm/hello-helm-0.1.0.tgz

helm repo index .

helm upgrade --install hello-helm hello-helm-0.1.0.tgz
```

