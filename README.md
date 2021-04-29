# BORSCHT project

Simple fast-boot object storage

## Start Dev

```shell script
./mvnw quarkus:dev
```

## Build 

```shell script
./mvnw install
```

curl -X POST -v -F 'file=@\"C:/Users/ashcheulovmr/mercurial.ini\"' 127.0.0.1:8080/api/upload/