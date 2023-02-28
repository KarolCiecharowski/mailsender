# Email Microservice
This is a microservice for managing email addresses and sending messages to all email recipients in the database.

## Description
The Email Microservice is designed to store email addresses of recipients and allow sending messages to all of them at once. The service provides REST APIs to perform CRUD operations on user email addresses and send email messages to all recipients in the database.

## How to Use
Requirements
- Java 11 or higher
- MySQL server
- Postman or similar tool for making HTTP requests
## Installation
### 1. Clone the repository or download the source code.
### 2. Open the project in IntelliJ or any Java IDE.
### 3. Running the SQL Server.
Before running the Email Microservice, you need to make sure that the SQL server is running. Here are the steps to run SQL server by MySQL:
- Open the command prompt (Windows) or terminal (Mac/Linux).
- Type the following command to start the MySQL server:
```sql
    Start-Service mysql
```
- If the server is already running, you can skip this step.
### 4. Create the Database:
To create the database for your microservice, you can use any relational database management system (RDBMS) that is supported by Spring Boot. Some popular choices include MySQL, PostgreSQL, Oracle, and Microsoft SQL Server. Here are the general steps for creating a new database in MySQL:
- Create a new database using the CREATE DATABASE command. For example, to create a database named mail_service, you can use the following command:
    
```sql
{
    CREATE DATABASE mail_service;
}
```
- Create a new table named emails in database using the CREATE TABLE command, you can use the following command:
    
```sql
{
 CREATE TABLE `mail_service`.`emails`(
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  subject VARCHAR(255) NOT NULL,
  text TEXT NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)); 
}
```
- Configure the database connection in the application.properties file located in the root directory of your project:
    
```php
{
spring.datasource.url=jdbc:mysql://localhost:<PORT>/mail_service
spring.datasource.username=<USERNAME>
spring.datasource.password=<PASSWORD>
}
```
__Modify the values above according to the information you provided when creating the database.__

### 5. Configure the email sender
The **EmailConfig** class located in the **emailservice.Configuration** package is responsible for configuring the email sender used by the microservice. To use it, you need to update the following properties:

1. **mailSender.setUsername("your_email_address");**: replace your_email_address with your Gmail address.
2. **mailSender.setPassword("your_email_password");**: replace your_email_password with your Gmail password.
You can also customize the email sender configuration by modifying the **properties** in the Properties object. For example, you can change the email server host and port by updating the **mailSender.setHost()** and **mailSender.setPort()** methods.

**Note**: To use your Gmail account as the email sender, you need to enable two-factor authentication for your account and generate an app password to use in the EmailConfig class. To generate an app password, go to your Google account settings, select "Security," and then select "App passwords." Follow the instructions to generate a new app password and use it in the mailSender.setPassword() method in the EmailConfig class.

### 6. Run the EmailServiceApplication class to start the microservice.
REST API
The microservice provides the following REST APIs:

**GET /emails/getAll**: Get all email messages with id, subject, text, email and recipment for every email address stored in the database.

**GET /emails/getById/{id}**: Get an email messages with id, subject, text, email and recipment by ID.

**POST /emails/add**: Add a new email message with id, subject, text, email and recipment to the database.

**PUT /emails/updateById/{id}**: Update an email messages with id, subject, text, email and recipment by ID.

**DELETE /emails/deleteById/{id}**: Delete an email messages with id, subject, text, email and recipment by ID.

**POST /emails/send?subject={subject}&text={text}**: Send an email message to all recipients in the database with the specified subject and text.

## Example of using the CRUD API using POSTMAN:
**CREATE**: To add a new email to the database, use the HTTP POST method with the URL http://localhost:8080/emails/Add. Set the Content-Type header to application/json, and in the request body (raw) , provide the email details in JSON format, like this:

```perl
{
    "subject": "New email subject",
    "text": "This is the body of the new email",
    "email": "recipient@example.com"
}
```
Press SEND button

**READ**: To retrieve all emails from the database, use the HTTP GET method with the URL http://localhost:8080/emails/getAll. Set the Content-Type header to application/json.

Press SEND button

**UPDATE**: To update an existing email in the database, use the HTTP PUT method with the URL http://localhost:8080/emails/UpdateById/{id}, where {id} is the ID of the email to be updated. Set the Content-Type header to application/json, and in the request body, provide the updated email details in JSON format, like this:

```perl
{
    "subject": "Updated email subject",
    "text": "This is the updated body of the email",
    "email": "recipient@example.com"
}
```
Press SEND button

**DELETE**: To delete an email from the database, use the HTTP DELETE method with the URL http://localhost:8080/emails/DeleteById/{id}, where {id} is the ID of the email to be deleted. Set the Content-Type header to application/json.

Press SEND button

**Note**: Before starting the microservice, make sure that the application is running on the correct port (8080) by checking the application.properties file in the root directory of your project. If the port is different, update it to 8080 to ensure the microservice is available on the expected port.

## Technologies and Libraries
The Email Microservice is built using the following technologies and libraries:

- Spring Boot
- MySQL
- JPA
- Maven
## Running Tests
To run the unit and integration tests for the microservice, you can use the following command:

```bash
mvn test
```
## Logging
The Email Microservice generates two log files: integration.log and general.log. The integration.log file contains integration logs, while the general.log file contains general application logs. Both files are stored in the logs directory located in the root directory of the project.

To configure logging, modify the logback.xml file located in the src/main/resources directory. You can change the log file names and patterns by updating the <file> and <pattern> elements in the configuration file.

## Contributing
If you would like to contribute to the Email Microservice, please follow these guidelines:

- Submit an issue describing the problem or feature you would like to add.
- Fork the repository and make your changes on a new branch.
- Submit a pull request with your changes.

## Using the REST APIs in other programming languages
To use the REST APIs in other programming languages, you can make HTTP requests to the appropriate endpoints using libraries such as requests in Python or axios in Node.js. Here's an example of how to use the GET /emails/getAll endpoint in Python:

```python
import requests

url = "http://localhost:8080/emails/getAll"

response = requests.get(url)

print(response.json())
```

## FAQs
Q: Can I send an email to multiple recipients at once?

A: Yes, you can send an email to all recipients in the database using the POST /emails/send endpoint.

## Performance and Scalability
The Email Microservice is designed to handle a large number of requests and can be easily scaled horizontally by deploying multiple instances behind a load balancer. However, the actual performance and scalability may vary depending on factors such as server resources and network latency. To optimize the performance of the microservice, we recommend using a caching solution such as Redis or Memcached to cache frequently accessed data.
