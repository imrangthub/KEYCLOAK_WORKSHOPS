# KEYCLOAK_WORKSHOPS

App Info
-------------

keycloak-15.0.2

mysql-connector-java-8.0.20.jar

Run keycloak server

=>C:\keycloak-15.0.2\bin\standalone.bat


MySQL Config
---------------------------------------

Requirment

Keycloak 10.0.2, 
MySQL Community Server 8.0.20 
MySQL Connector for Java


Step 1: Create a database in MySQL

      =>CREATE DATABASE keycloakdb CHARACTER SET utf8 COLLATE utf8_unicode_ci;
      
Step 2: Create a database user for Keycloak

      =>CREATE USER 'keycloakadmin'@'%' IDENTIFIED WITH mysql_native_password BY 'keycloak123';

Step 3: Grant all privileges

      GRANT ALL PRIVILEGES ON keycloakdb.* TO 'keycloakadmin'@'%';
      FLUSH PRIVILEGES;
      
Step 4: Ensure that your databse engine is InnoDB


      --- Should output: default_storage_engine InnoDB
      =>SHOW GLOBAL variables like "default_storage%"

      --- If storage engine is not InnoDB, use this to set it
      =>SET GLOBAL default_storage_engine = 'InnoDB';
      
      
Step 5: Adding a module with the MySQL driver (Connector/J) to Keycloak


       C:\Z_MY_COMPUTER\MD_IMRAN_HOSSAIN\PROJECT\MY_PROD\KEYCLOAK_OWN\MY_KEYCLOAK\keycloak-15.0.2\modules\system\layers\keycloak\com\mysql\main\module.xml
       
                <?xml version="1.0" ?>
                <module xmlns="urn:jboss:module:1.3" name="com.mysql">
                 <resources>
                  <resource-root path="mysql-connector-java-8.0.20.jar" />
                 </resources>
                 <dependencies>
                  <module name="javax.api"/>
                  <module name="javax.transaction.api"/>
                 </dependencies>
                </module>
                
                
  Step 6: Defining a data source
  
First, go to your {Keycloak-Directory}\standalone\configuration\ and open the standalone.xml file in your text editor.
Search for the word KeycloakDS and you should see a section defining a data source and database driver for the default H2 database the XML snippet below.
You need to do two things - replace the KeycloakDS data source and the database connection driver defined for H2 with your MySQL database.



Step 7: Database configuration

Step 8: Restarting Keycloak server


Get Token
======================================

1) Set up a user

![image](https://user-images.githubusercontent.com/32607915/140270039-1332b2e8-c8e9-49f5-98a4-615f40959997.png)

3) Set up a client

![image](https://user-images.githubusercontent.com/32607915/140270093-6bb8c705-e465-4e8c-b712-d5d0be0b6753.png)

![image](https://user-images.githubusercontent.com/32607915/140270410-df3fd632-af02-479b-b42d-134e164943a6.png)




http://localhost:8080/auth/realms/SpringBootRealm/protocol/saml/descriptor


http://localhost:8080/auth/realms/SpringBootRealm/.well-known/openid-configuration


Get Token( Grant Types: password)

http://localhost:8080/auth/realms/SpringBootRealm/protocol/openid-connect/token

Request Body:

                  grant_type:password
                  client_id:spring-boot-client-app-cliendid
                  username:imranmdbar
                  password:12345
                  
![image](https://user-images.githubusercontent.com/32607915/140271841-e8eecc18-98ad-45d4-99ba-7618e661b7b7.png)



Get Token( Grant Types: client_credentials )

Create a client or update exist client
![image](https://user-images.githubusercontent.com/32607915/140301082-81555ed3-2715-496e-a64b-2a6c6cfd1aa4.png)


Use client secret

![image](https://user-images.githubusercontent.com/32607915/140301227-7499c2e0-859a-4def-8862-01926f1edebf.png)

Get Token: 

http://localhost:8080/auth/realms/SpringBootRealm/protocol/openid-connect/token


![image](https://user-images.githubusercontent.com/32607915/140301420-0fd117c7-4856-45a8-95f6-9c62d49a556d.png)



