[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/0LozK0wt)
# CheckPoint 6: DevOps e CI/CD com Azure DevOps

## Desafio

Você faz parte do time de tecnologia responsável pelo **Projeto DimDim**, do banco DimDim, uma instituição financeira nacional com mais de 1 milhão de correntistas. O banco está passando por uma transformação digital para se tornar mais ágil, moderno e competitivo, melhorando a experiência de seus clientes nos canais digitais e físicos.

Sua missão é atuar diretamente na aplicação **transactions-services**, responsável por:

- Processamento de transferências, TEDs, PIX, depósitos e saques
- Controle de extratos

O desafio é **automatizar o ciclo de vida da aplicação na nuvem**, utilizando Azure DevOps, garantindo que:

1. A aplicação seja **compilada e testada automaticamente** a cada alteração de código.
2. Uma **imagem Docker** seja gerada e enviada para o Azure Container Registry.
3. A aplicação esteja **deployada em um WebApp do Azure**, disponível e funcional para uso pelos clientes do banco.

> Esta não é uma avaliação de seguir passos: é um convite a **explorar, refletir e decidir** como resolver cada etapa do processo de DevOps, considerando o impacto real para a experiência do cliente e a operação diária da DimDim.

---

## Recursos Disponíveis

- Aplicação **transactions-services**, já _conteinerizada_, disponível neste repositório.
- Ambiente Azure (WebApp, Banco e ACR) pode ser criado via script: `scripts/setup.sh`.
- Ao término da atividade, é possível limpar o ambiente com o script: `scripts/cleanup.sh`.
- IA disponível para apoiar o aluno na construção da solução.
- Documentações oficiais do Azure, Docker e Gradle.

Use esses recursos como suporte para **planejar, testar e iterar** sua solução.

---

## Pontos de Reflexão

Antes de criar sua solução, considere:

- Como organizar o **pipeline** para que o Build, Test e Deploy funcionem de forma automatizada.
- Como garantir que a **imagem Docker** esteja sempre atualizada no registro.
- Quais variáveis, ambientes e configurações são necessárias para que o deploy funcione sem intervenção manual.
- Como você pode estruturar o YAML de forma **clara, eficiente e reprodutível**, refletindo boas práticas de DevOps.

---

## Critérios de Avaliação

Sua avaliação será baseada em:

- **Automação**: O pipeline realiza build, testes e deploy sem ações manuais.
- **Funcionalidade**: A aplicação está funcionando corretamente no WebApp após o deploy.
- **Gestão de imagens Docker**: A imagem é construída e enviada corretamente para o ACR.
- **Documentação e clareza**: O repositório contém informações suficientes para entender a pipeline e o deploy.
- **Reflexão e solução própria**: A forma como você organiza e resolve o desafio será considerada, valorizando **autonomia e criatividade**.

> Lembre-se: o aprendizado está no **processo de construir a solução**, refletir sobre as decisões e validar resultados.

---

## Dica de abordagem

- Experimente etapas isoladas antes de integrar tudo na pipeline.
- Leia os logs e mensagens da pipeline para entender falhas e acertos.
- Busque entender **por que** cada etapa é necessária, não apenas **como** fazê-la.
- Compartilhe aprendizados e problemas enfrentados; a avaliação também considera a capacidade de **analisar e aprender com o processo**.

---

## Observação importante

- Para que o deploy seja considerado válido, ele deve ser realizado **pelo pipeline**. Deploy manual não será aceito como solução correta.
- Inclua evidências da execução da pipeline (logs, prints do pipeline, logs do WebApp ou ACR) para comprovar que sua solução foi automatizada.

---

## 🚀 Solução Implementada

### 📋 Infraestrutura Azure

Recursos criados na subscription Azure:

- **Resource Group**: `rg-cp6-2tds`
- **Azure Container Registry**: `2tds251cp6rm556221.azurecr.io`
- **Azure Web App**: `2tds251cp6rm556221.azurewebsites.net`
- **Localização**: Brazil South

### 🔄 Pipeline CI/CD

A pipeline foi implementada no Azure DevOps com 3 stages principais:

#### **Stage 1: Build and Test Application**
- Instalação do Java 21 (OpenJDK)
- Compilação do projeto com Gradle
- Execução de testes unitários automatizados
- Publicação dos resultados dos testes

#### **Stage 2: Docker Build and Push to ACR**
- Build da imagem Docker multi-stage
- Tag da imagem com número do build e `latest`
- Push da imagem para o Azure Container Registry
- Validação da imagem criada

#### **Stage 3: Deploy to Azure WebApp**
- Deploy do container Docker no Azure WebApp
- Configuração de variáveis de ambiente (porta 8080)
- Configuração do registro Docker
- Restart automático da aplicação

### 🛠️ Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Framework**: Spring Boot 3.5.7
- **Build Tool**: Gradle 8.14
- **Java**: OpenJDK 21
- **Database**: H2 (em memória)
- **Container**: Docker multi-stage build
- **Base Image**: gcr.io/distroless/java21:nonroot
- **CI/CD**: Azure DevOps Pipelines
- **Cloud**: Microsoft Azure

### ✅ Aplicação em Produção

**URL da Aplicação**: https://2tds251cp6rm556221.azurewebsites.net

**Endpoints Disponíveis**:
- `/actuator/health` - Status de saúde da aplicação
- `/actuator/info` - Informações da aplicação

### 📊 Evidências de Execução

A pipeline foi executada com sucesso realizando:
1. ✅ Build automatizado do código-fonte
2. ✅ Execução de testes unitários
3. ✅ Criação e publicação de imagem Docker no ACR
4. ✅ Deploy automatizado no Azure WebApp
5. ✅ Aplicação acessível e funcional

### 🔐 Service Connections

Foram configuradas 2 service connections no Azure DevOps:
1. **ACRServiceConnection** - Para autenticação no Azure Container Registry
2. **AzureServiceConnection** - Para deploy no Azure WebApp

### 📝 Arquitetura da Solução

```
GitHub Repository
       ↓
   [Trigger]
       ↓
Azure DevOps Pipeline
       ↓
   ┌─────────────┐
   │ Build & Test│
   └──────┬──────┘
          ↓
   ┌─────────────┐
   │ Docker Build│
   └──────┬──────┘
          ↓
Azure Container Registry
   (2tds251cp6rm556221)
          ↓
   ┌─────────────┐
   │   Deploy    │
   └──────┬──────┘
          ↓
    Azure WebApp
(2tds251cp6rm556221)
```

### 🎯 Resultados Alcançados

- ✅ Pipeline CI/CD 100% automatizada
- ✅ Build e testes executados automaticamente a cada commit
- ✅ Imagem Docker gerada e versionada no ACR
- ✅ Deploy automático no Azure WebApp
- ✅ Aplicação acessível via HTTPS
- ✅ Zero intervenção manual no processo de deploy

---

## 👨‍💻 Autor

**RM**: 556221  
**Nome**: João Henrique Dias  
**Turma**: 2TDSa