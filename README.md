# Docker Backend Covid API
### (Mise en production TD2)
#### From Maxence COMANDINI

### HOW TO RUN WITH DOCKER IN LOCAL

1. Download this folder inside your docker, computer or server that has Docker installed and running
2. Go in folder
3. Run `docker-compose build`
4. Run `docker-compose up`
5. Access webpage with link 'localhost:8081/' then api endpoint like in the examples below

### WHAT CAN YOU TEST IN THIS API

When first starting the server, there will be no data inside it. You must add some data to test the API. You can add data by using the POST endpoints below.

There are some endpoints that can be used to test this API without authorization in this version of the API:

- POST Request : '[host]/user/save' with JSON body in raw like below :
````
{
  "userMail": "myDoctorMail@somemail.com",
  "firstName": "Jean",
  "lastName": "Dujardin",
  "role": "Médecin",
  "passwordHash": "test"
}
````
- GET Request : '[host]/user/' without anything inside the body to see all users registered
- DELETE Request : '[host]/user/delete?email=[user_mail]' to delete the user using the specified email
- POST Request : '[host]/center/save' with JSON body in raw like below :
````
{
    "name": "Robert Schuman",
    "address": "Rue des Champs Montoy Parvis Robert Schuman",
    "postalCode": "57000",
    "city": "Metz",
    "phone": "+33 3 99 99 99 99"
}
````
- GET Request : '[host]/center/' to see every center
- DELETE Request : '[host]/center/delete?id=[center_id]' to delete a center by its id
- GET Request : '[host]/center/addUser?idUser=[user_id]&idCenter=[center_id]' to link a center and a user (for a doctor working in a special center for example)

#### I recommend you to use Postman in order to test this API. If you do, the file Covid_API_Polytech contains the Postman collection that can be used to easily test this API

### HOW TO USE JENKINS-COMPOSE WITH THIS PROJECT

Use the version `jenkins-compose`, then on jenkins put the Jenkinsfile inside
After that you can run the Jenkins Pipeline that you created.

It may be necessary to add the path of the command `docker-compose` to run the pipeline.