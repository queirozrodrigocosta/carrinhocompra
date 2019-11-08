# Carrinho de compras

Carrinho de Compras
Definição:
Criar uma solução para carrinho de compras onde seja possível criar Usuários, Itens e o Carrinho.
Esta solução deve ser obrigatoriamente escrita utilizando Java. Fica livre a utilização de qualquer outra
ferramenta/lib que o candidato achar necessário para completar a tarefa. A solução deve conter testes
unitários com cobertura minima de 60% e a aplicação deve ser Threadsafe.

Regras Backend:
• Cada ítem deve ser identificado com: ID, NOME e VALOR.
o Criar telas de CRUD
• Cada usuário deve ser identificado com: ID, NOME e EMAIL
o Criar telas de CRUD
o Cada usuário deve ser único
o Cada usuário pode criar um carrinho com n itens
• Carrinho de Compras:
o Um carrinho deve esta ligado a um único usuário
o Deve ser possível fazer CRUD de itens
o Se um ítem já existir no carrinho, deve ser atualizado a quantidade deste item no carrinho
o Não deve existir ítem no carrinho com valor <= 0
o Deve existir um método fechar compras que exibirá todos os itens do carrinho ordenados
por nome, valor e exibir o somatório dos itens.
o Deve existir um método que exiba a lista de carrinhos existentes ordenados pelo valor
total do carrinho.

Regras Frontend:
• Validar na criação do usuário se o mesmo ja existe
• Validar o email do usuário
• Validar se o item tem valor > 0

Tarefa Bonus:
• Dockerizar a aplicação
• Fazer o deploy em alguma cloud

Stack a ser utilizada:
• JDK >= 8
• Spring boot 2.1.8
• MongoDB
• Angular 8
• Lombok
• Spring Test
• Webserver Jetty ou undertow
• Maven ou Gradle

Entrega da solução:
• A entrega do código fonte deve ser feita no github ou bitbucket
• Deve possuir um README de como clonar e fazer a aplicação rodar localmente
• Explicar a estratégia adotada na solução
