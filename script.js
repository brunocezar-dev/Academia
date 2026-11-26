const API_URL = 'http://localhost:8080/api';
const nav = document.querySelector('#mainNav');
document.querySelector('#menuToggle').addEventListener('click', () => nav.classList.toggle('open'));
nav.querySelectorAll('a').forEach(link => link.addEventListener('click', () => nav.classList.remove('open')));
document.querySelector('#year').textContent = new Date().getFullYear();

async function sendToApi(path, payload) {
  const response = await fetch(`${API_URL}${path}`, {
    method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(payload)
  });
  const body = await response.json().catch(() => ({}));
  if (!response.ok) throw new Error(body.message || body.error || 'Não foi possível concluir a solicitação.');
  return body;
}

document.querySelector('#clientForm').addEventListener('submit', async event => {
  event.preventDefault();
  const form = event.currentTarget; const message = document.querySelector('#clientMessage');
  const data = Object.fromEntries(new FormData(form));
  message.textContent = 'Enviando cadastro...';
  try {
    await sendToApi('/clientes', data);
    message.textContent = 'Cadastro realizado com sucesso!'; message.style.color = '#69d69a'; form.reset();
  } catch (error) { message.textContent = `${error.message} Confira se o backend está ligado.`; message.style.color = '#ff777c'; }
});

document.querySelector('#bookingForm').addEventListener('submit', async event => {
  event.preventDefault();
  const form = event.currentTarget; const message = document.querySelector('#bookingMessage');
  const data = Object.fromEntries(new FormData(form));
  // datetime-local já envia o formato esperado por LocalDateTime: AAAA-MM-DDTHH:mm
  message.textContent = 'Verificando disponibilidade...';
  try {
    await sendToApi('/agendamentos', data);
    message.textContent = 'Agendamento confirmado!'; message.style.color = '#69d69a'; form.reset();
  } catch (error) { message.textContent = `${error.message} Verifique se seu e-mail está cadastrado e se há vaga.`; message.style.color = '#ff777c'; }
});
