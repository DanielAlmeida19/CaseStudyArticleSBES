# Imagem do java
FROM openjdk:21

# Diretório de trabalho
WORKDIR /app


RUN mvn clean install

# Executável da aplicação
COPY target/MSResident-0.0.1-SNAPSHOT.jar app.jar

# Porta da aplicação
EXPOSE 8081


# Comando para executar a aplicação
ENTRYPOINT [ "java", "-jar", "app.jar" ]