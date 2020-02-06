# Whitewater Centre Safety and Renting Application

A safety and renting tool to be used by receptionists at whitewater centre. 

## Table of Contents
* [Features](#Features)
* [Technologies](#Technologies)
* [Usage](#Usage)
* [Status](#Status)
* [DevOps](#DevOps)

<a name="Features"></a>
## Features:

* **Create** - The receptionist is able to create an entry for a customer entering the whitewater centre.
* **Read** - Customers information is retrieved from the database and displayed in a table.
* **Update** - The recepetionist is able to update a customer's information, assigning them equipment.
* **Delete** - All customers are able to be deleted individually or all at once.


<a name="Technologies"></a>
## Technologies Used:

* **RESTful API**: Java SpringBoot 2.2.2
* **Database** - embedded H2 SQL database
* **Front-end** - HTML5/JavaScript
* **Build Tool** - Apache Maven 3.6.3
* **Server** - Apache Tomcat 8.5.5

### Browser Support
![Chrome](https://github.com/alrra/browser-logos/blob/master/src/chrome/chrome_48x48.png) | ![Firefox](https://github.com/alrra/browser-logos/blob/master/src/firefox/firefox_48x48.png) 
--- | --- |
Latest ✔ | Latest ✔ |


<a name="Usage"></a>
## Usage

To demo the app yourself, go to:

`http://3.9.36.142:8181/KayakProject/`

NOTE: The appilication is hosted on a AWS EC2 instance, as such the link may not work as the instance may not be running.



<a name="Status"></a>
## Status

* **Build** - Passing 
* **Test Coverage** - 93% 

If you wish to clone the code, feel free to do so using the below clone url:

`git clone https://github.com/matt-dg-farrow/kayak_project/`

<a name="DevOps"></a>
# DevOps Project
Matthew Farrow and Jess Layton

## Brief

To create a fully-deployed version of a full-stack OOP application, with utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.

## Solution

Incorporated a CI/CD pipeline for the project, using Jenkins as a CI server, maven to build and run tests, nexus as a place to store our back-end dependencies and jar files, docker as a way to create images of our application to be stored and used to create containers, AWS EC2 instances to host the docker containers and AWS RDS as our storage for our app.

## Authors

Matthew Farrow

Jess Layton

## Links

[Trello board](https://trello.com/b/cUgbPKCz/devops-project)

[Front-end github repository](https://github.com/matt-dg-farrow/kayak-project-front-end)


