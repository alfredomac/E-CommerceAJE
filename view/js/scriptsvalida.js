// Função para validar um campo
function validateField(field, errorElement) {
  if (!field.value.trim()) {
    errorElement.classList.add('active');
    field.setCustomValidity('Este campo é obrigatório.');
  } else {
    errorElement.classList.remove('active');
    field.setCustomValidity('');
  }
}


function validateForm() {
  const form = document.getElementById('registrationForm');

  // Referências dos campos e mensagens de erro
  const firstName = document.getElementById('firstName');
  const lastName = document.getElementById('lastName');
  const email = document.getElementById('email');
  const password = document.getElementById('password');
  const username = document.getElementById('username');

  const firstNameError = document.getElementById('firstNameError');
  const lastNameError = document.getElementById('lastNameError');
  const emailError = document.getElementById('emailError');
  const passwordError = document.getElementById('passwordError');
  const usernameError = document.getElementById('usernameError');

  // Validações individuais
  validateField(firstName, firstNameError);
  validateField(lastName, lastNameError);
  validateField(email, emailError);
  validateField(password, passwordError);
  validateField(username, usernameError);

  // Verificar se todos os campos estão válidos antes de enviar
  if (form.checkValidity()) {
    alert('Formulário enviado com sucesso!');
    form.reset(); // Limpa o formulário após o envio
    return true;
  } else {
    return false;
  }
}
