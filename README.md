# DEMOSSR

## Exemplo de integração SSR com `Spring Boot` e `Thymeleaf`

* Esse projeto também configura perfis de execução (DEV e PRD)
  * Verifique os arquivos application*.properties
* Também existe a opção setada no arquivo `launch.json` da pasta .vscode
* É possível executar o projeto através do comando `mvn -Dspring.profiles.active=<NOMEDOPROFILE> spring-boot:run`
  * NOMEDOPROFILE é alguma opção associada ao arquivo application-NOMEDOPROFILE.properties
    * O acesso será dado pelo endereço [http://localhost:8081/demossr](http://localhost:8081/demossr)
