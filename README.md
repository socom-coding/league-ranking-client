# league-ranking-client

The league-ranking-client is a springboot console client that takes input from the user and calls the league-ranking-service api.

    #SpringBoot Microservice
    #Postman testing collection
    #Postman DEV and QA environments

    #NOTE: 
    DEV - The "dev" profile  will run out of the box without any config changes or setup required. It uses an h2 embedded database with schema that runs at runtime. This will       only be available in the 'dev" env for development.

    QA - "qa" profile requires a MySQL database and the inserted scripts needs to be ran to create the tables and the datasource config in the application-qa.properties need                to be changed where necesary.

    PROD - "prod" profile requires prod environment setup and config to be made in the application-prod.properties file.

The user will be asked to input login credentials to validate which function he/she may use.

    There are two users allowed to access these endpoints:

      Admin user: Can access both api calls.
        Username: admin
        Password: p@55w0rd

        Guest user: Can only access view api call.
        Username: guest
        Password: p@55w0rd1

NOTE:
    
    The client and service package builds must correspond to map to the basepaths of the environments.

  dev profile:
  
      Note: to run the dev profile, build using the following command:
        mvn clean install -P dev or,
        specify dev in the run configuration "Active Profiles"
        
        After build has completed, run the following command in the target folder:
         
        java -jar target/league-ranking-client-1.0-SNAPSHOT.jar
        
  qa profile:
  
      Note: to run the qa profile, build using the following command:
        mvn clean install -P qa or,
        specify dev in the run configuration "Active Profiles"
        
        After build has completed, run the following command in the target folder:
         
        java -jar target/league-ranking-client-1.0-SNAPSHOT.jar
        
  prod profile:
  
      Note: to run the prod profile, build using the following command:
        mvn clean install -P prod or,
        specify dev in the run configuration "Active Profiles"
        
        After build has completed, run the following command in the target folder:
         
        java -jar target/league-ranking-client-1.0-SNAPSHOT.jar
        
    
