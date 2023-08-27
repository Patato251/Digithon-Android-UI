# Digithon Android Mobile UI Prototype

## Description

- Repository is to contain all code relevant to the Android Prototype base for the Digithon Hackathon event 2023
- The following codebase is offered as a base template for any participants to actively use at their own discretion
- Support will be provided when necessary for some debugging, however participants are assumed to be able to resolve many technical challenges via their own methods and research

- For further issues, contact the Digithon Technical team for any queries or questions

## Technical Outline

- The repository sample will follow an MVVM coding paradigm, with three main layers setup for the demonstration code:
  - Data - All direct data integrations and interactions will occur within this layer
  - Domain - Middle layer for interactions and all state value calculations to occur for UI interactions and actions
  - Presenter - UI screens and all presentational features of the code should be within
  - Core - Shared UI Components layer

- Gradle configurations have been setup to have base level application operational
- Recommended JDK version: **17.0.6**
- Gradle Version for project: **8.1.1**

## FAQ

*The application is not correctly compiling, with gradle errors, what should I do?*

- Please run the following command, and re-execute the build instances of the application via the build button or sync within gradle files after a change
``pkill -f '.*GradleDaemon.*'``
