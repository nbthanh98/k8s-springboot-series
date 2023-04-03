FROM adoptopenjdk/openjdk11:latest
WORKDIR /workspace
COPY target/*-SNAPSHOT.jar /workspace/app.jar
ENV TZ="Asia/Ho_Chi_Minh"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/workspace/app.jar"]