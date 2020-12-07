---
id: transaction-delete
title: Deletando todas as transações
---

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';

Nesta end-point é possível você deletar todas as transações cadastradas.

### End-point

:::note

__DELETE__ - {{host}}:{{port}}/transacao

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
  "message": "deleted successful"
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
