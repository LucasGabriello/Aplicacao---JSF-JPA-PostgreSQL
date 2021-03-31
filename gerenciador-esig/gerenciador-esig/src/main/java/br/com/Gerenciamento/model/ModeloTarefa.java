package br.com.Gerenciamento.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Tarefa")
public class ModeloTarefa implements Serializable, BaseTarefa{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idTarefa;
	private String titulo;
	private String descricao;
	private String responsavel;
	private String prioridade;
	private int deadline;
	private String situacao;
	public Long getIdTarefa() {
		return idTarefa;
	}
	public void setIdTarefa(Long idTarefa) {
		this.idTarefa = idTarefa;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTarefa == null) ? 0 : idTarefa.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloTarefa other = (ModeloTarefa) obj;
		if (idTarefa == null) {
			if (other.idTarefa != null)
				return false;
		} else if (!idTarefa.equals(other.idTarefa))
			return false;
		return true;
	}
	
	
	
	

}
