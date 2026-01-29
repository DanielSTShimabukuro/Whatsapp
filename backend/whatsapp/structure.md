# Arquitetura do Projeto (SOLID)
```text
domain/                                 Camada de Domínio — Entidades vão aqui
    user/                               ex: Entidade User
        User.java
        UserType.java
        
application/                            Camada de Aplicação — Regras de Negócio e Exceções vão aqui
    user/                               ex: Service e UseCases p/ User
        UserService.java                
        CreateUserUseCase.java
    exceptions/                         ex: Exceção customizada p/ tratar Recurso Não Encontrado
        ResourceNotFoundException.java
        
infra/                                  Camada de Infraestrutura — Repositórios e Configs de Autenticação vão aqui     
    persistence/                        ex: Onde vão os Repositórios c/ JPA — Implementações vão aqui também
        user/
            UserRepository.java
    security/
            SecurityConfig.java
            SecurityFilter.java       

interfaces/                             Camada de Interface — Controllers e tratamento de erro global aqui  
    rest/
        user/
            UserController.java
            requests/
                CreateUserRequest.java  ex: Record p/ definir o body do request de criação do usuário
            responses/
                UserResponse.java       ex: Recor p/ definir o body do response dos recursos que retornam usuário
```