# PressCentric Application

Welcome to the PressCentric Application documentation! This document provides an overview of the PressCentric Application, its components, and how to get started.

## Table of Contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Components](#components)
  - [Service](#service)
  - [Repository](#repository)
  - [Mapper](#mapper)
  - [Validation](#validation)
- [GraphQL Resolvers](#graphql-resolvers)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [GraphQL Playground](#graphql-playground)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The PressCentric Application is a simple GraphQL-based API that manages user data. It allows you to perform CRUD operations on user objects with fields like `id`, `name`, and `email`. This documentation will help you understand the structure of the project and how to work with its components.

## Getting Started

To get started with the PressCentric Application, follow these steps:

1. Clone the repository to your local machine:
git clone https://github.com/urosthegreat/graphql-project.git

2. Install the necessary dependencies using Gradle or your preferred build tool.

3. Configure the application properties, database connection, and other settings as needed.

4. Build the project to generate the application's WAR file.

## Project Structure

The project follows a structured layout for easy navigation. Here's an overview of the main package names:

- `com.example.presscentricapp`: Main package for the application.
- `resolver`: Contains GraphQL resolvers.
- `service`: Contains service classes for business logic.
- `repository`: Contains repository interfaces for database operations.
- `mapper`: Contains data mapper interfaces and classes.
- `validation`: Contains validation classes.
- `model`: Contains model classes, including entities, DAOs, and input classes.

## Components

### Service

The service layer contains classes responsible for managing user-related operations. It includes methods for retrieving, creating, updating, and deleting users.

### Repository

The repository layer contains repository interfaces for database operations. It interfaces with the database using Spring Data JPA.

### Mapper

The mapper package contains classes for mapping between entity and DTO classes. These classes use MapStruct for automatic mapping.

### Validation

The validation package contains a utility class for validating input parameters. It checks the validity of integer parameters.

## GraphQL Resolvers

GraphQL resolvers are defined in the `resolver` package. Resolvers handle GraphQL queries and mutations and interact with the service layer to fetch or manipulate data.

## Database Setup

The application uses a database to store user information. You can configure the database connection in the application properties.

## Running the Application

To run the PressCentric Application, follow these steps:

1. Build the project to generate the application's WAR file.

2. Deploy the WAR file to a Tomcat 7+ container.

3. Access the GraphQL API at `http://localhost:8080/graphql`.

## GraphQL Playground

The application provides a GraphQL Playground for exploring the GraphQL API. You can use it to send queries and mutations to the API and test the functionality.

## Contributing

We welcome contributions from the community. Feel free to submit issues or pull requests to help improve the application.
