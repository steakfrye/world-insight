FROM adoptopenjdk:11-jre-hotspot

RUN curl -L "https://github.com/docker/compose/releases/download/1.28.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
RUN chmod +x /usr/local/bin/docker-compose

RUN curl -L https://services.gradle.org/distributions/gradle-6.8-bin.zip -o gradle-6.8-bin.zip
RUN apt-get install -y unzip
RUN unzip gradle-6.8-bin.zip
ENV GRADLE_HOME=/app/gradle-2.4
ENV PATH=$PATH:$GRADLE_HOME/bin
RUN /bin/bash -c "source $HOME/.bashrc"

RUN mkdir /opt/app
COPY build/libs/application-0.0.1-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar"]