## Intro
Example JAVA EE rest API project, using:
* JAVA-RS
* JPA
* CDI

## How to run
**Require:** Java EE 7 container, like GlassFish, Wildfly, etc.   
You could also use TomcatEE but since it not support JTA transaction, you have to use standalone transaction manager
like Atomikos, JOTM, Bitronix, SimpleJTA, etc.

1. Config Wildfly container  
   In standalone.xml:
```xml
<datasources>
    <datasource jta="true" jndi-name="java:/jdbc/Test" pool-name="Test" enabled="true" use-ccm="true">
        <connection-url>your-connection-url</connection-url>
        <driver-class>oracle.jdbc.driver.OracleDriver</driver-class>
        <driver>oracle</driver>
        <security>
            <user-name>your-username</user-name>
            <password>your-password</password>
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
2. Run the application  
    1. Build the project
    ```shell
    mvn clean install
    ```
    2. Copy to war file in target folder to {wildfire-home}/standalone/temp folder
    3. Run the {wildfire-home}/bin/standalone.bat or {wildfire-home}/bin/standalone.sh
