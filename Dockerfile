FROM tomcat

WORKDIR /usr/local/tomcat

RUN rm -rf webapps/*

COPY target/T1.war webapps/T1.war

EXPOSE 8080

CMD ["catalina.sh","run"]