### Configurações
- **AWS**
  - Configurar infraestrutura na AWS para implantação do sistema.
- **Mongo**
  - Configurar banco de dados MongoDB para persistência de dados.
- **Keycloak**
  - Configurar serviço de autenticação e autorização com Keycloak.
- **Postgres & pgAdmin**
  - Configurar banco de dados PostgreSQL e ferramenta de administração pgAdmin.

### Infraestrutura
- **Dockerfile**
  - Criar Dockerfile para construir imagens do aplicativo.
- **Docker Compose**
  - Criar arquivo Docker Compose para facilitar a execução e gerenciamento dos contêineres.

### Onboarding
- **CRUD Usuários**
  - Implementar operações de criação, leitura, atualização e exclusão de usuários.
- **CRUD Endereço**
  - Implementar operações de gerenciamento de endereços dos usuários.
- **CRUD Telefones**
  - Implementar operações de gerenciamento de números de telefone dos usuários.
- **CRUD Contas**
  - Implementar operações de criação, leitura, atualização e exclusão de contas de usuário.
- **Implementação de Autenticação (Integração Keycloak)**
  - Integrar o sistema de autenticação do Keycloak ao aplicativo.

### Operações do Sistema
- **CRUD Transações**
  - Implementar operações de criação, leitura, atualização e exclusão de transações, registrando-as no banco relacionadas ao número da conta do usuário.
- **CRUD Documento Usuário**
  - Implementar operações de gerenciamento de documentos dos usuários.
- **CRUD Histórico de Crédito**
  - Implementar operações de gerenciamento do histórico de crédito dos usuários.
- **CRUD Cheques**
  - Implementar operações de gerenciamento de cheques dos usuários.
- **CRUD Investimentos**
  - Implementar operações de gerenciamento de investimentos dos usuários.
- **CRUD Pagamentos**
  - Implementar operações de gerenciamento de pagamentos dos usuários.
- **CRUD Beneficiários de Transferências**
  - Implementar operações de gerenciamento dos beneficiários de transferências dos usuários.
- **CRUD Empréstimos**
  - Implementar operações de gerenciamento de empréstimos dos usuários.

### Log
- **Implementação do Microserviço de Log com MongoDB**
  - Desenvolver microserviço para registrar diferentes tipos de logs no MongoDB.
  - **Tipos de Log:**
    - Ao fazer login
    - Ao realizar transações

### Envio de E-mail
- **E-mail de Boas-Vindas**
  - Configurar sistema para enviar e-mail de boas-vindas aos novos usuários.
- **Recuperação de Senha**
  - Implementar funcionalidade de recuperação de senha por e-mail.
- **Notificação de Transações**
  - Configurar sistema para enviar e-mail de confirmação após uma transação bem-sucedida.
