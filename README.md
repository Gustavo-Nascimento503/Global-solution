# Ocean Guard

Bem-vindo à documentação da **Ocean Guard API**! Esta API fornece informações de Registros e usuarios. Abaixo, você encontrará detalhes sobre as principais classes e endpoints disponíveis.

## Descrição do projeto
O OceanGuard é um aplicativo inovador desenvolvido para auxiliar moradores e banhistas das praias a relatar e monitorar as condições ambientais e atividades humanas nessas áreas, promovendo a conservação e gestão sustentável do ambiente costeiro.

## Classes

### `Usuario`

A classe `Usuario` contém informações de cadastro sobre os usuario da plataforma.

**Atributos:**

- `id`: O identificador único do usuario.

- `nome`: O nome do usuario.

- `email`: O email do usuario.

- `senha`: A senha do usuario.

### `Registro`

A classe `Registro` contém informações de cadastro sobre os registros da plataforma.

**Atributos:**

- `id`: O identificador único da ocorrencia.

- `ocorrencia`: O nome/tipo da ocorrencia.

- `localidade`: O local da ocorrencia.

- `descRegistro`: A descrição da ocorrencia.

- `usuario`: Relacionamento entre registro e usuario.

# Endpoints

## Métodos GET

- `GET /usuario`: Retorna uma lista de todos os usuario.

- `GET /registro`: Retorna uma lista de todos os registros.
  
- `GET /registro/{id}`: Retorna detalhes sobre um registro específico com base no ID.

## Métodos Post
  
- `POST /usuario`: Cria um novo usuario com base nos dados fornecidos.

- `POST /registro`: Cria um novo registro com base nos dados fornecidos.

## Métodos PUT

- `PUT /registro/{id}`: Atualiza os detalhes de um fornecedor existente com base no ID.

## Métodos DELETE
  
- `DELETE /registro/{id}`: Exclui um registro com base no ID.

Lembre-se de incluir os parâmetros necessários na sua solicitação para obter os resultados desejados.

## Exemplo JSON

Aqui está um exemplo da estrutura JSON representando as informações do `usuario`:

```json
{
    "id": "Long",
    "nome": "String",
    "email": "String",
    "senha": "String",
}
```

Aqui está um exemplo da estrutura JSON representando as informações do `registro`:

```json
{
    "id": "Long",
    "ocorrencia": "String",
    "localidade": "String",
    "descRegistro": "String",
    "id_registro": "Long"
}
```

## Códigos de retorno(usuario e registro)

- 200: Conexão e resposta bem-sucedidas.
- 201: Registrado com sucesso.
- 400: Dados inválidos ou ausentes fornecidos.
- 404: Página ou recurso não encontrado.
- 405: Acesso restrito ao recurso.
- 500: Erro interno do servidor.

## Como testar

- 1: No postman ou insomnia importe o arquivo JSON.
- 2: Com o arquivo importado faça o cadastro do usuario.
- 3: Faça o login do usuario, ira gerar um token como retorno.
- 4: Em todas as outras requisições sera necessario ativar a autenticação, ative a `Bearer token`, e cole o token em todas elas, a partir disso você tera acesso as requisições.