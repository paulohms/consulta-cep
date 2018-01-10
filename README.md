# Projeto consulta-cep

API para consulta de CEP que expõem serviços REST com retorno JSON. Os métodos disponíveis são:

- consultarPorCep
- consultarPorEndereco

Projeto desenvolvido em Java utilizando os frameworks:

- Springboot
- JSoup
- Spring MVC
- JUnit
- Maven

Para executar/testar faça o clone do projeto. Em seguida acesse a pasta do projeto e rode o comando:

**mvn clean package**

Acesse a pasta target e execute o projeto com o comando:

**java -jar consulta-cep-1.0.jar**

Exemplo de requisições:

[http://localhost:8080/consultarPorCep?cep=38401048](http://localhost:8080/consultarPorCep?cep=38401048)

[http://localhost:8080/consultarPorEndereco?endereco=ENDEREÇO](http://localhost:8080/consultarPorEndereco?endereco=ENDEREÇO)
