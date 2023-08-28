# Quickstart Guide to Codebase

The following file is a quick start guide to allow any developer to pickup and start developing in the right places.
Please note the following details are assumed:

- Participants have personal device to operate with Android studio and have latest packages/gradle installations
- Some development understanding
- Knowledge of Kotlin and Compose

## Code Breakdown

- Main Src folder for all core logic and screens can be found in:
  - `app/src/main/java/digithon`
- Code is broken down into 4 main layers/sections
  - *Core* 
  - *Data*
  - *Domain*
  - *Presentation* 

### Core

- Core folder houses shared componentns and navigational utility
- Currently stored several default layout buttons and other layout UI elements
- Navigation is also stored within this and dictates what screens are available

### Data

- Houses components pertaining to database setup and dependency injection and repository implementations
- By default contains database folder, containing direct database setup code, di folder, containing dependecy injection code, related to repositories and setup for datbase, and repository implementation, implementation code for function interface
- Any new repositories need to be configured to be binded correctly in DataModule.kt
- AppModule has relevant code for database. A quick way to drop/modify Db schema is details inside AppModule.kt file

### Domain

- Middleware layer between the presentation and data layers
- Logic and code blocks pertaining to allowing the presentation layer to access data that is stored and set in the data layer as well as data layer to parse whatever information is required
- Contains Repository interface, UseCase definitions and classing, as well as any models for tracking of information and data to be stored
- Utility files also containing any relevant and useful code chunks for other functionality in UI

### Presentation

- Presentation layer where all Ui related logic and components are located. 
- Houses ViewModel files for presentation and state layer logic to allow for state changes and tracking to occur
- This is reflected in the Ui folder containing all screens and layouts of screens to be shown
- Event and Util folders to assist for ViewModel to correctly track state logic and any interactions occuring on the Screens in UI


- Main Resource file where images and other icon's are stored can be found:
  - `app/src/main/res`
- All images used for reference are found within this folder

## FAQ

*The application is not correctly compiling, with gradle errors, what should I do?*

- Please run the following command, and re-execute the build instances of the application via the build button or sync within gradle files after a change
  ``pkill -f '.*GradleDaemon.*'``

