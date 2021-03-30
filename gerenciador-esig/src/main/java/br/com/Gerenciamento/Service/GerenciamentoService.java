package br.com.Gerenciamento.Service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.Gerenciamento.model.ModeloTarefa;
import br.com.Gerenciamento.model.ModeloPessoa;
import br.com.dominio.dao.DAOPessoa;
import br.com.dominio.dao.DAOTarefa;

public class GerenciamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAOTarefa<ModeloTarefa> daoTarefa;
	
	public void salvarTarefa(ModeloTarefa t) {
		daoTarefa.salvarTarefa(t);
	}
	
	public void removerTarefa(ModeloTarefa t) {
		daoTarefa.removerTarefa(ModeloTarefa.class, t.getIdTarefa());
	}
	
	public List<ModeloTarefa> todasAsTarefas(){
		return daoTarefa.buscarTarefas("select t from ModeloTarefa t order by t.titulo");
	}
	
	//--------------------
	private DAOPessoa<ModeloPessoa> daoPessoa;
	
	public void salvarPessoa(ModeloPessoa p) {
		daoPessoa.salvarPessoa(p);
	}
	
	public void removerPessoa(ModeloPessoa p) {
		daoPessoa.removerPessoa(ModeloPessoa.class, p.getIdPessoa());
	}
	
	public List<ModeloPessoa> todasAsPessoas(){
		return daoPessoa.buscarPessoa("select p from ModeloPessoa p order by p.nome");
	}
	
}
