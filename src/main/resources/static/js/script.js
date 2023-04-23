// Variavel para controlar a tela
let isOpen = false;
// Telas para fechar e abrir e butões
//View NavBar
let viewNavBar = document.querySelector(".menuHamb");
let btnViewNavBar = document.querySelector(".iconeHamburge");
//View Notificação
let viewNoti = document.querySelector(".caixa_notificacao");
let btnViewNoti = document.querySelector("#notificacao");
//View cadastro de aluno
let viewRegisterUser = document.querySelector(".conteiner_register_aluno");
let bntExitRegister = document.querySelector("#sair_register").addEventListener("click", ()=>{
    viewRegisterUser.style.display = "none";
});;
let bntAddUSer = document.querySelector(".box_btn_addUser button").addEventListener("click", ()=>{
    viewRegisterUser.style.display = "flex";
});

function openView(value) {
    //isOpen == false
    if(!isOpen){
        value.style.display = "block";
        isOpen = true;
    }else{
        value.style.display = "none";
        isOpen = false;
    }
}
//agora veririfico o evento no btn passando a tela como parametro
// viewNavBar
btnViewNavBar.addEventListener("click", ()=>{
    openView(viewNavBar);
});
// viewNoti
btnViewNoti.addEventListener("click", ()=>{
    openView(viewNoti);
});

// Fazendo a conexão com minha API para retornar alunos
const alunosList = document.querySelector('#alunos-list');
fetch('http://localhost:8080/api/alunos')
  .then(response => response.json())
  .then(alunos => {
    alunos.forEach(aluno => {
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>
        <div class="boxImg">
        <img src="https://picsum.photos/50/50" />
        </div>
        </td>
        <td>${aluno.id}</td>
        <td>${aluno.user_name}</td>
        <td>${aluno.first_name}</td>
        <td>${aluno.last_name}</td>
        <td>${aluno.email}</td>
        <td>${aluno.phone}</td>
        <td>${aluno.matricula}</td>
        <td class="btns_acao">
            <div class="boxAcoes">
                <button id="btn_editar">
                    <i class="fa-solid fa-user-pen"></i>
                </button>
                <button id="btn_remover">
                    <i class="fa-solid fa-user-xmark"></i>
                </button>
                <button id="btn_ver">
                    <i class="fa-solid fa-eye"></i>
                </button>
            </div>
        </td>
      `;
      alunosList.appendChild(tr);
    });
  });