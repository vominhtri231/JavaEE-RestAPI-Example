## Intro
Example JAVA EE rest API project, using:
* JAVA-RS
* JPA
* CDI

## Required
1. Maven
2. Java EE 7 container (preferred Wildfly 9)   
   You could also use TomcatEE but since it not support JTA transaction, you have to use standalone transaction manager
like Atomikos, JOTM, Bitronix, SimpleJTA, etc.
3. Database (preferred Oracle)
## How to run
1. Config Wildfly container  
   In `{wildfly-home}/standalone/configuration/standalone.xml`:
```xml
<datasources>
    <datasource jta="true" jndi-name="java:/jdbc/Test" pool-name="Test" enabled="true" use-ccm="true">
        <connection-url>db-url</connection-url>
        <driver-class>oracle.jdbc.driver.OracleDriver</driver-class>
        <driver>oracle</driver>
        <security>
            <user-name>db-username</user-name>
            <password>db-password</password>
        </security>
    </datasource>
    <drivers>
        <driver name="oracle" module="com.oracle">
            <driver-class>oracle.jdbc.driver.OracleDriver</driver-class>
            <xa-datasource-class>oracle.jdbc.driver.OracleDriver</xa-datasource-class>
        </driver>
    </drivers>
</datasources>
```
2. Migrate database
```shell
mvn "-Dflyway.user=db-user" "-Dflyway.password=db-password" "-Dflyway.url=db-url" "-Dflyway.schemas=db-schema" flyway:migrate
```
3. Run the application  
    1. Build the project
    ```shell
    mvn clean install
    ```
    2. Copy to war file in target folder to `{wildfire-home}/standalone/temp` folder
    3. Run the `{wildfire-home}/bin/standalone.bat` or `{wildfire-home}/bin/standalone.sh`
