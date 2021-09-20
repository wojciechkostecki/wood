# Wood
> Tree model building application

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Setup](#setup)
* [Project Status](#project-status)
* [Contact](#contact)


## General Information
- Project created in Java according to REST API.
- Each Tree has a Trunk that has Branches and Leaves.
- A Branch may have other Branches.
- A Branch can be assigned to a Trunk or another Branch. It depends on the Id passed.
- Endpoint grow is responsible for increasing the elements of the Tree by the assumed factor, which depends on the age of the Tree.


## Technologies Used
- Java
- Spring Boot
- PostgreSQL
- H2
- Junit 5
- MockMvc
- Lombok
- Mapstruct

## Setup
Use the commands:

```git clone https://github.com/wojciechkostecki/wood.git```

```cd wood```

```docker-compose --file src/main/docker/app-local-dev.yml up```

```mvn spring-boot:run```

## Project Status
Project is: _in progress_

The next step is to write tests for other endpoints.

The endpoint responsible for Tree growth should be extended to add Tree elements randomly.

## Contact
Created by [@wojciechkostecki](https://www.linkedin.com/in/wojciech-kostecki-7816411a4/)
