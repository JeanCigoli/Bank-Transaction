---
id: transaction-create
title: Criando uma transação
---

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';

Nesta end-point é possível você fazer uma transação enviando o valor e data que ela foi executada.

### End-point

:::note

__POST__ - {{host}}:{{port}}/transacao

:::

### Parâmetros de envio

#### body

| Nome     | Tipo        | Descrição                                         |
|----------|-------------|---------------------------------------------------|
| valor    | decimal     | Valor em decimal com ponto flutuante da transação |
| dataHora | data e hora | Data/Hora em que a transação aconteceu            |

```javascript
{
  "valor": 250,
  "dataHora": "2020-12-05T14:39:56.789-03:00"
}
```

### Exemplos de resposta

<Tabs
  defaultValue="201"
  values={[
    {label: 'Created', value: '201'},
    {label: 'Bad Request', value: '400'},
    {label: 'Unprocessable Entity', value: '422'},
  ]}>
  <TabItem value="201">

```javascript
{
  "payload": {
      "id": 1,
      "value": 250.0,
      "date": "2020-12-05T17:39:56.789+00:00",
      "createdAt": "2020-12-06T14:26:10.493+00:00"
  },
  "message": "created successful"
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
  <TabItem value="422">

```javascript
{
  "message": "Unprocessable Entity",
  "errors": {
      "param": "valor",
      "message": "O valor mínimo para a transação é 0"
  }
}
``` 
  
  </TabItem>
</Tabs>
