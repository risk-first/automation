Webhook to allow you to join people to the organisation when they star a repo within it.


## Deployment

Currently hosted on automation.riskfirst.org

- scp target/riskfirst-automation-0.0.1-SNAPSHOT.war deploy@automation.riskfirst.org:~
- cd  /usr/local/apache-tomcat9/webapps
- cp ~deploy/riskfirst-automation-0.0.1-SNAPSHOT.war ROOT.war
- vi /usr/local/apache-tomcat9/config/application.properties 
    * (Place in properties)
- In conf/catalina.properties:
    * common.loader="${catalina.base}/lib","${catalina.base}/lib/*.jar","${catalina.home}/lib","${catalina.home}/lib/*.jar","${catalina.home}/config"
- /etc/init.d/tomcat9 restart
