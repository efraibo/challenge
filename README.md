# Challenge  

## Para executar o projeto localhost siga os passos
 - Foi utilizado um banco em memória(H2) para facilitar os teste local pelo avaliador
 - Baixe as dependências: mvn clean install;
 
### Executar projeto utilizando IDE
 - Para configurar o projeto na IDE é necessário configurar a biblioteca lombok; 
 - Start a aplicação a partir da classe ChallengeAplication.java;
 
### Executar projeto utilizando pelo console
 - Após rodar o comando "mvn clean install" execute o seguinte comando "java -jar target/challenge-0.0.1-SNAPSHOT.jar"
 

# Aplicação Local

## Acessar swagger api quando executar o projeto local
 - http://localhost:8080/api/swagger-ui.html#/

## Collection postman localhost
 - https://www.getpostman.com/collections/942ea84a77cbf4d2a0f9


# Aplicação remoto

## Acessar swagger api utilizando a aplicação que está no ambiente pivotal
 - https://challenge.cfapps.io/api/swagger-ui.html#/

## Acessar a aplicação na pivotal cloud (OBS: Adicionar o endpoint correto conforme documentação swagger)
 - https://challenge.cfapps.io/api/v1/despesas

## Collection postman remoto
 - https://www.getpostman.com/collections/162a325896afd25d61a2

# Observações Gerais
 - A aplicação foi publicada na cloud pivotal conforme solicitado;
 - Foi criado um serviço de banco de dados postgres para ser utilizado na aplicação;
 - Foi levando em consideração o ano 2019 para consumir a api. Os dados foram adicionados previamente no momento que a aplicação sobe pela primeira vez. Deixando o retorno dos dados mais rápido e eficiente;


