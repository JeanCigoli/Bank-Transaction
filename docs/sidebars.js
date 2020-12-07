/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 *
 * @format
 */

module.exports = {
  docs: [  
    {
      type: 'category',
      label: 'Getting Started',
      items: [
        'info',
        'installation',
        'structure',
      ],
    },
    {
      type: 'category',
      label: 'API',
      items: [
        {
          'Transações': ['api/transaction-create', 'api/transaction-delete', 'api/transaction-find'],
        },
        {
          'Estatística': ['api/statistic-find'],
        },
        'api/healthcheck',
      ],
    },
  ],
};
