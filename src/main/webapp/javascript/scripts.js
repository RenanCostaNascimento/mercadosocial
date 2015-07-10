/* 
 * Copyright (C) 2015 Renan.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
function validaEmail(elemento, classe) {
    exp_reg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
    if (exp_reg.test(elemento.value) === false) {
        adicionarClasse(elemento, classe);
    }else{
        removerClasse(elemento, classe);
    }
}

function validaCpf(elemento, classe) {
    var Soma;
    var Resto;
    var strCPF = elemento.value;
    Soma = 0;
    if (strCPF === "00000000000") {
        adicionarClasse(elemento, classe);
        return false;
    }
    for (i = 1; i <= 9; i++) {
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    }
    Resto = (Soma * 10) % 11;
    if ((Resto === 10) || (Resto === 11)) {
        Resto = 0;
    }
    if (Resto !== parseInt(strCPF.substring(9, 10))) {
        adicionarClasse(elemento, classe);
        return false;
    }
    Soma = 0;
    for (i = 1; i <= 10; i++) {
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    }
    Resto = (Soma * 10) % 11;
    if ((Resto === 10) || (Resto === 11)) {
        Resto = 0;
    }
    if (Resto !== parseInt(strCPF.substring(10, 11))) {
        adicionarClasse(elemento, classe);
        return false;
    }
    removerClasse(elemento, classe);
    return true;
}

function confirmarSenha(senha, confirmacaoSenha, classe) {
    if (senha.value !== confirmacaoSenha.value) {
        adicionarClasse(senha, classe);
        adicionarClasse(confirmacaoSenha, classe);
    }else{
        removerClasse(senha, classe);
        removerClasse(confirmacaoSenha, classe);
    }
}

function carregarPagina(pagina) {
    window.top.location.href = pagina;
}

function adicionarClasse(elemento, classe) {
    var classeAtual = elemento.className;
      
    if (classeAtual.indexOf(classe) === -1) {
        if ((classeAtual === null) || (classeAtual === "")) {
            elemento.className = classe;
        } else {
            elemento.className += " " + classe;
        }
    }
}
 
function removerClasse(elemento, classe) {
    var classeAtual = elemento.className;
 
    if (classeAtual === classe) {
        elemento.className = "";
        return;
    }
 
    var valoresClasses = classeAtual.split(" ");
    var filteredList = [];
 
    for (var i = 0 ; i < valoresClasses.length; i++) {
        if (classe !== valoresClasses[i]) {
            filteredList.push(valoresClasses[i]);
        }
    }
 
    elemento.className = filteredList.join(" ");
}