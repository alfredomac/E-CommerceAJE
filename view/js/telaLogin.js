       // Função de validação
       function validateLoginForm(event) {
        const emailInput = document.getElementById("emailInput");
        const passwordInput = document.getElementById("passwordInput");

        const email = emailInput.value.trim();
        const password = passwordInput.value.trim();

        // Validação do formato do e-mail
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!email) {
            alert("Por favor, insira o e-mail.");
            emailInput.focus();
            event.preventDefault(); // Impede o envio do formulário
            return false;
        }

        if (!emailRegex.test(email)) {
            alert("Por favor, insira um e-mail válido.");
            emailInput.focus();
            event.preventDefault();
            return false;
        }

        if (!password) {
            alert("Por favor, insira a palavra-passe.");
            passwordInput.focus();
            event.preventDefault();
            return false;
        }

        // Se todas as validações forem atendidas, o formulário será enviado
        return true;
    }

    // Adicionar evento ao formulário
    document.addEventListener("DOMContentLoaded", function () {
        const form = document.getElementById("emailForm");
        form.addEventListener("submit", validateLoginForm);
    });