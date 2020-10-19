# CodingChallengeGreenFieldBackEnd

## EnrolleeBackEnd
EnrolleeBackEnd is a Java and Spring Boot Web application's backend. This application provides data manipulation from a MongoDB database in a RESTful manor, while applying a simple client-service Eureka Microservice. This project is treated as the server portion in the microserver architecture.

## POSTMAN Documentation and Example Usage
[POSTMAN DOCS](https://documenter.getpostman.com/view/11861886/TVRrV4QX)

## Installation
For proper set-up, several things will be needed: 
- MongoDB Server
- Eclipse (or similar IDE for Java development)
- Client Server which can be found [here](https://github.com/markrubio632/GreenFieldClientServer/tree/master/CodingChallengeGreenFieldBackEnd)

Once these are installed, import the two maven projects into your workspace in the IDE.

### Database Configuration
Begin by creating your own MongoDB server. This can be either a localhost on a machine or using MongoDB Atlas, a cloud service provided by MongoDB. Once your server is properly configured to your liking, connect to the database by editing the application.properties file of this project (no change needed in the Client Server) to reflect your own database. Replace \<username\>, \<password\>, and \<DBAddress\> with your external MongoDB configuration.

## Deployment of Microservice
To Deploy and test the microservice, run the Spring Boot projects in your IDE. Begin by running this Service prior to running the Client version. Use a browser and go to `localhost:8761` to find further information about the status of the Service server. The port number can be changed to a different port in the application.properties file.

Next, run the client project, and then return to your browser tab with the Service status and refresh it. It will now contain an instance connected with the server. This client server can be deployed multiple times and all traffic will port through the Service microservice.

## Testing Application
Please Refer to the POSTMAN Documentation and Example Usage above for example of commands to be given.
