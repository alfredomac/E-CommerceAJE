document.addEventListener('DOMContentLoaded', async () => {
    const apiEndpoint = 'http://localhost:8080/v1'; // URL da API
  
    try {
      // Requisição GET para a API
      const response = await fetch(`${apiEndpoint}/produtos`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });
  
      if (!response.ok) {
        throw new Error(`Erro na requisição: ${response.status}`);
      }
  
      const produtos = await response.json(); // Dados recebidos da API
  
      // Renderizar os produtos no front-end
      const produtosContainer = document.querySelector('.card-columns');
      produtos.forEach((produto) => {
        const produtoHTML = `
          <div class="card">
            <div class="card-body">
              <a href="#">
                <img src="${produto.imagem || '../img/default.png'}" alt="Imagem do Produto" class="card-img-top">
              </a>
              <h3 class="card-title pt-2">${produto.nome}</h3>
              <p class="card-text mt-3">
                ${produto.descricao || 'Sem descrição disponível.'}
                <a class="" href="produto-detalhes.html">Detalhes</a>
              </p>
              <p class="card-text d-block">
                <span>${produto.preco} R$</span>
              </p>
            </div>
            <div class="card-footer">
              <button class="btn btn-outline-primary btn-adicionar form-login-input-button">
                Adicionar ao carrinho
              </button>
            </div>
          </div>
        `;
        produtosContainer.innerHTML += produtoHTML;
      });
    } catch (error) {
      console.error('Erro ao carregar produtos:', error);
    }
  });
  