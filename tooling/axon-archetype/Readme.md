# The Axon Simple Archetype v0.3

##  Introduction

   The Axon simple archetype intends to get you started with using the Axon framework quickly by providing you a ready to use
   Spring Boot based Axon application scaffold with the following capabilities
    
      Package structure for your Axon applications
      Axon Sample Artefacts
      Axon Sample Test Classes
      Axon Server Configuration
      
    It also bundles all the necessary dependencies required for your Axon application helping you focus on just using Axon

##  Installation

    git clone axon-archetype
    mvn install
    
## Usage

    mvn archetype:generate -DarchetypeGroupId=com.learnaxon -DarchetypeArtifactId=axon-simple-archetype -DarchetypeVersion=0.3
    -DgroupId=<<Your Group Id>> -DartifactId=<<Your Artifact Id>>

## Features

    The archetype will generate a complete Axon starter project for you. 
    
    This includes
    
    - Axon Artefacts
      
        SimpleAggregate (Aggregate)
        SimpleCreateCommand/SimpleModifyCommand (Commands) written in Kotlin
        SimpleEventCreated/SimpleEventModified (Events) written in Kotlin
        SimpleQuery (Event Handlers)
      
    - A recommended package/folder structure for putting in your Commands/Sagas/Upcasters/Data Classes/Queries/Event 
      Handlers for your Axon application
    
    - Axon Configurations. This will be further enhanced in subsequent versions of the archetype to accomodate 
      most of the possible configurations. As of now contains only the following configurations.
      
        Application Name (Defaults to SimpleApplication)
        Context Name (Defaults to SimpleContext)
    
    
## Testing

    There are two flows that need to be tested for the code that the archetype generates
    
    Simple Create Command  -> Simple Event Created -> Simple Event Created Handler
    Simple Modify Command  -> Simple Event Modified -> Simple Event Modified Handler
    
    
    The archetype provides two ways of testing the scenarios
    
    1. JUnit
    
       The archetype creates a JUnit Test class (SimpleCommandTest.java) which makes use of the
       AggregateTestFixture/FixtureConfiguration capabilities provided by the Axon framework itself
       
       Run mvn test to execute the test case
       
    2. REST API
    
        The archetype also creates a SimpleController which provides a REST API to execute the SimpleCommand(s).
        
        Download the Axon Server SE Edition v4.2 from (www.axoniq.io) and run it (as simple as java -jar axonserver.jar)
        OPen the Axon server console at http://localhost:8024
        Install and run your Spring Boot Application created from the archetype (assuming it runs on 8080)
        Open the Axon server console and click on Overview. You should see the "SampleApplication" connected to the Axon Server
        Open Postman and run the following POST command  "http://localhost:8080/commands?commandData=hello"
        You should start seeing the Commands and Events within the Console
        
        
        
        
        
        
        

      
