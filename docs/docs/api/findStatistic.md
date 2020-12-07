---
id: statistic-find
title: Buscando as estatísticas 
---

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';

Nesta end-point é possível você visualizar algumas estatísticas de transações que ocorreram em um determinado tempo.

### End-point

:::note

__GET__ - {{host}}:{{port}}/estatistica?seconds=

:::

### Parâmetros de envio

#### query

| Nome    | Tipo | Descrição                                           |
|---------|------|-----------------------------------------------------|
| seconds | int  | O intervalo de segundos que ocorreram as transações |

:::important

Não é obrigatório o envio da variável seconds, caso opte em não enviar ele terá por padrão 60 segundos.

:::

### Exemplos de resposta

<Tabs
  defaultValue="200"
  values={[
    {label: 'Ok', value: '200'},
  ]}>
  <TabItem value="200">

| Nome  | Descrição                                              |
|-------|--------------------------------------------------------|
| count | Quantidade de transações nos últimos segundos          |
| sum   | Soma total do valor transacionado nos últimos segundos |
| avg   | Média do valor transacionado nos últimos segundos      |
| min   | Menor valor transacionado nos últimos segundos         |
| max   | Maior valor transacionado nos últimos segundos         |

```javascript
{
  "payload": {
    "count": 2,
    "sum": 400.0,
    "avg": 200.0,
    "min": 150.0,
    "max": 250.0
  },
  "message": "request successful"
}
```
  </TabItem>
  <TabItem value="400">

```javascript
{
  "message": "JSON se encontra mal formatado",
  "errors": {
      "param": "request JSON",
      "message": "JSON parse error: {{message}}"
  }
}
```

  </TabItem>
</Tabs>