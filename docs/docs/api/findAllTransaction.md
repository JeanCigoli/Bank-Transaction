---
id: transaction-find
title: Buscando todas as transações
---

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';

Nesta end-point é possível você visualizar todas as transações cadastradas.

### End-point

:::note

__GET__ - {{host}}:{{port}}/transacao

:::

### Parâmetros de envio

Não é necessário realizar nenhum tipo de envio.

### Exemplos de resposta

<Tabs
  defaultValue="200"
  values={[
    {label: 'Ok', value: '200'},
  ]}>
  <TabItem value="200">

```javascript
{
  "payload": [
      {
        "id": 2,
        "value": 250.0,
        "date": "2020-12-05T17:39:56.789+00:00",
        "createdAt": "2020-12-06T14:33:43.847+00:00"
      }
  ],
  "message": "request successful"
}
```
  </TabItem>
  <TabItem value="400">

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