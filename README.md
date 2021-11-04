# KEYCLOAK_WORKSHOPS


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
