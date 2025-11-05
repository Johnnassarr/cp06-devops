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
