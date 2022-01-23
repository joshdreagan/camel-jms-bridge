# Camel JMS Bridge

## Requirements

- [Apache Maven 3.x](http://maven.apache.org)
- [Red Hat AMQ Broker 7.x](https://developers.redhat.com/products/amq/overview)
- [IBM MQ 9.x](https://www.ibm.com/products/mq)
  - [Docker Image](https://hub.docker.com/r/ibmcom/mq/)

## Preparing

Install and run Red Hat AMQ Broker [https://developers.redhat.com/products/amq/getting-started]

Install and run IBM MQ [https://www.ibm.com/docs/en/ibm-mq/9.0?topic=am-mq-90-quick-start-guide-long-term-support]

_Note: For my tests, I chose to run the docker image [https://hub.docker.com/r/ibmcom/mq/]. You can run it using the command `docker run --name ibmmq -e LICENSE=accept -e MQ_QMGR_NAME=QM1 -e MQ_ADMIN_PASSWORD=admin -p 1414:1414 -p 9443:9443 docker.io/ibmcom/mq:latest`. You can then open a browser window to https://localhost:9443/ibmmq/console` using admin/admin as your credentials._

Build the project source code

```
cd $PROJECT_ROOT
mvn clean install
```

## Running the example

```
cd $PROJECT_ROOT
mvn spring-boot:run
```