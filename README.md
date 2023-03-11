# Demo-app

Apenas uma demonstração de como fazer um teste integrado com o Spring. Há apenas o teste da classe `PostAuthorController`:
- Exemplifica a utilização das anotações `@SpringBootTest` e `@AutoConfigureMockMvc`;
- Como validar o resultado de um objeto do json da resposta de um endpoint;
- Como configurar um banco de dados em memória apenas para os testes no arquivo `application.properties` no *resources* de *test*.

Também a demostração de como inserir um `correlationId` na *thread*:
- Configuração na classe `LogInterceptor` e expondo para o Spring na classe `WebConfig`;
- Há uma configuração de log customizada pelo arquivo `logback-spring.xml`.

Se gostaria de executar a aplicação, precisará configurar um banco de dados, neste caso um MySQL. Configurando um container docker como abaixo será o suficiente:
- `docker run --name demo-app-db -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql`;

Há uma *collection* do Postman com os *endpoints* disponíveis na pasta `postman-collection`.
