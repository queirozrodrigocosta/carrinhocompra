Para rodar o sistema deve-se:
- clonar a raiz do projeto "git clone https://github.com/queirozrodrigocosta/carrinhocompra.git".
- abrir a pasta "carrinhocompra-backend" e executar os comandos maven "updade", "test" e "install", executar a aplicação spring na porta 8080 em algum servidor de aplicação com o arquivo *.JAR gerado na pasta "target"
- abrir a pasta "carrinhocompra-frontend" e executar os comandos npm "install" e "ng serve"
- abrir o navegador e testar a aplicação localmente na porta que o npm disponibilizou

Definição: Criar uma solução para carrinho de compras onde seja possível criar Usuários, Itens e o Carrinho. Esta solução deve ser obrigatoriamente escrita utilizando Java. Fica livre a utilização de qualquer outra ferramenta/lib que o candidato achar necessário para completar a tarefa. A solução deve conter testes unitários com cobertura minima de 60% e a aplicação deve ser Threadsafe. 

Regras Backend: • Cada ítem deve ser identificado com: ID, NOME e VALOR. • Criar telas de CRUD • Cada usuário deve ser identificado com: ID, NOME e EMAIL • Criar telas de CRUD • Cada usuário deve ser único • Cada usuário pode criar um carrinho com n itens • Carrinho de Compras: • Um carrinho deve esta ligado a um único usuário • Deve ser possível fazer CRUD de itens • Se um ítem já existir no carrinho, deve ser atualizado a quantidade deste item no carrinho • Não deve existir ítem no carrinho com valor <= 0 • Deve existir um método fechar compras que exibirá todos os itens do carrinho ordenados por nome, valor e exibir o somatório dos itens. • Deve existir um método que exiba a lista de carrinhos existentes ordenados pelo valor total do carrinho. 

Regras Frontend: • Validar na criação do usuário se o mesmo ja existe • Validar o email do usuário • Validar se o item tem valor > 0 

Tarefa Bonus: • Dockerizar a aplicação • Fazer o deploy em alguma cloud 

Stack a ser utilizada: • JDK >= 8 • Spring boot 2.1.8 • MongoDB • Angular 8 • Lombok • Spring Test • Webserver Jetty ou undertow • Maven ou Gradle 

Entrega da solução: • A entrega do código fonte deve ser feita no github ou bitbucket • Deve possuir um README de como clonar e fazer a aplicação rodar localmente • Explicar a estratégia adotada na solução

