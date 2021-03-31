package br.com.dominio.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
//import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import br.com.Gerenciamento.Service.*;
import br.com.Gerenciamento.model.ModeloPessoa;
import br.com.dominio.utility.Message;

@Named("PC")
@SessionScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloPessoa pessoa;

	@Inject
	private GerenciamentoService servicePessoa;

	private List<ModeloPessoa> pessoas;

	public void carregarP() {
		pessoas = servicePessoa.todasAsPessoas();
	}
	public void limparP() {
		pessoa = new ModeloPessoa();
	}
	public void adicionarP() {

		try {
			servicePessoa.salvarPessoa(pessoa);
			//carregarP();
			limparP();

		} catch (Exception e) {
			Message.erro("erro");
		}

	}

	public void removerP() {

		try {
			servicePessoa.salvarPessoa(pessoa);
			carregarP();

		} catch (Exception e) {
			Message.erro("erro");
		}

	}

	public ModeloPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(ModeloPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ModeloPessoa> getPessoas() {
		return pessoas;
	}
	
}
