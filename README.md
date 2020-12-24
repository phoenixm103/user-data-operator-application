# user-data-operator-application
user-data-operator-application is a simple crud application that stores user data. 
### The app has following basic features.
- Data is composed of first name, last name, address (street, city, state and zip)
- The app creates the following User types (Parent, Child). The child cannot have an address and Must belong to a parent
- App have API to:
	- Delete user data
	- Create user data
	- Update user data
- Data is saved in a DB (MongoDB)
- Readme file describing how to install/run the application
- Unit Test
### Preparing Environment to run the application
#### Install java 8
To run user-data-operator-application system must have java environment(Java 8). To install java 8 in your Linux environment
```
sudo apt-get update
sudo apt-get install openjdk-8-jdk
``` 
To check java is installed or not, run
```
java -version
```
#### Install maven
user-data-operator-application is a maven project. To build the jar file system must have maven installed. To install maven, run
```$xslt
sudo apt -y install maven
sudo maven -version
``` 
#### Installing git
It is recommended to install git in the system. To install git
```$xslt
sudo apt install git
git --version
``` 
#### Installing Docker
If anyone wants to run the project on Docker engine, it is must to install Docker. In this application we are going to use MongoDB which also going to run on Docker engine. So it is highly recommended to install docker.
```$xslt
$ sudo apt-get remove docker docker-engine docker.io containerd runc
$ sudo apt-get update
$ sudo apt-get install \
      apt-transport-https \
      ca-certificates \
      curl \
      gnupg-agent \
      software-properties-common
$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
$ sudo apt-key fingerprint 0EBFCD88

$ sudo add-apt-repository \
     "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
     $(lsb_release -cs) \
     stable"
$ sudo apt-get update
$ sudo apt-get install docker-ce docker-ce-cli containerd.io
$ sudo apt-get install docker-ce=5:20.10.0~3-0~ubuntu-bionic docker-ce-cli=5:20.10.0~3-0~ubuntu-bionic containerd.io
```
Run ```sudo docker images```. If it runs then Docker is installed and running.

#### Installing MongoDB
user-data-operator-application uses MongoDB database. To run mongo in container
```$xslt
$ docker pull mongo
$ sudo docker run -d -p 27017:27017 --name mongo-container mongo
$ sudo docker exec -it mongo-container mongo
```
At this point our environment is ready and we are good to go to run the application.

### Running the application in Docker
There are two ways to run the application in Docker.
#### 1. Building image, Running container in the docker 
- clone the code from github
``` 
$ git clone https://github.com/phoenixm103/user-data-operator-application.git
```
- in the root directory of the application where Dockerfile is available run build command to create the jar file
```$xslt
mvn clean install 
```
- .jar file will be created in ./target folder. To build the image and running the app in desired port, run
```
$ sudo docker build -t user-data-operator-application .
$ sudo docker run -d -p 6099:6099 --name user-data-operator-application-container user-data-operator-application

```
The application is now running in the 6099 port of the host machine.
##### 2. Pulling from Docker hub and running in the docker
This is the easiest way to run the application. I have build an image and deploy it to my Docker hub account. Just pull it and run.
To do so-
```$xslt

```

### Running .jar file in the host machine
If anybody is not comfortable with containerization he could run the application  by ruuning the .jar file in his host machine
- Clone the code from github
``` 
$ git clone https://github.com/phoenixm103/user-data-operator-application.git
```
- In the target folder .jar file is available. To run the application, go to the target folder and open a terminal. then
```$xslt
java -jar user-data-operator-application-0.0.1-SNAPSHOT.jar 
```
### Documentation

- [Api Documentation](./docs/api_documentation.md)

- [Unit Test Documentation](./docs/unit_test_documentation.md)
