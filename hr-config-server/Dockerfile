### baixa a imagem do openjdk ###
FROM openjdk:11

### Cria uma pasta para o tomca t###
VOLUME /tmp

### Expõe a porta padrão ###
EXPOSE 8888

### adiciona o arquivo Jar do nosso projeto e o renomeia(nome da frente) ###
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar

### define o que é para ser executado da primeira vez ###
ENTRYPOINT [“java”, “-jar”, “/hr-config-server.jar”]