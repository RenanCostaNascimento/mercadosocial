/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Instituicao;
import br.edu.ifes.sr.dw.modelos.TipoInstituicao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.persistencia.InstituicaoDao;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean(name = "cadastroInstituicao")
@RequestScoped
public class CadastroInstituicao {

    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String tipo;
    private String email;
    private String senha;

    public String cadastrar() {
        InstituicaoDao instituicaoDao = DaoFactory.criarInstituicaoDao();
        
        Instituicao instituicao = new Instituicao();
        
        instituicao.setNomeFantasia(nomeFantasia);
        instituicao.setRazaoSocial(razaoSocial);
        instituicao.setCnpj(cnpj);
        instituicao.setEmail(email);
        instituicao.setSenha(senha);
        if ("beneficente".equals(tipo)) {
            instituicao.setTipoInstituicao(TipoInstituicao.BENEFICENTE);
        } else if ("contribuidora".equals(tipo)) {
            instituicao.setTipoInstituicao(TipoInstituicao.CONTRIBUIDORA);
        }

        instituicaoDao.salvar(instituicao);
        ContextMessage.addMessage("Sucesso", "Instituição cadastrada com sucesso. Agora faça login na área apropriada.");
        return "instituicaoCadastrada";
    }

}
