package br.com.dominio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.Gerenciamento.Service.GerenciamentoService;
import br.com.Gerenciamento.model.ModeloTarefa;
import br.com.dominio.utility.Message;

@Named
@ViewScoped
public class TarefaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloTarefa tarefa;

	@Inject
	private GerenciamentoService serviceTarefa;

	private List<ModeloTarefa> tarefas;

	public void carregarT() {
		tarefas = serviceTarefa.todasAsTarefas();
	}

	public void adicionarT() {

		try {
			serviceTarefa.salvarTarefa(tarefa);
			carregarT();

		} catch (Exception e) {
			Message.erro("erro");
		}

	}

	public void removerT() {

		try {
			serviceTarefa.salvarTarefa(tarefa);
			carregarT();

		} catch (Exception e) {
			Message.erro("erro");
		}

	}

	public ModeloTarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(ModeloTarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<ModeloTarefa> getTarefas() {
		return tarefas;
	}

}
