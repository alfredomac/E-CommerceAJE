document.getElementById("emailForm").addEventListener("submit", function (event) {
    const emailInput = document.getElementById("emailInput");
    const passwordInput = document.getElementById("passwordInput");
        
    const email = emailInput.value.trim();
    const password = passwordInput.value.trim();

        // Validação do e-mail
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!email) {
        alert("Por favor, insira o e-mail.");
        emailInput.focus();
        event.preventDefault(); // Impede o envio do formulário
        return;
    } else if (!emailRegex.test(email)) {
        alert("Por favor, insira um e-mail válido.");
        emailInput.focus();
        event.preventDefault();
        return;
    }

        // Validação da senha
    if (!password) {
        alert("Por favor, insira a palavra-passe.");
        passwordInput.focus();
        event.preventDefault();
        return;
    }

        // Se passar pelas validações, o formulário será enviado
    alert("Formulário enviado com sucesso!");
});