package br.com.omni.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamentos")
public class DepartamentoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7201333509493963518L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "local")
	private String local;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	private EstadoEnum estado;

	@Column(name = "diretoria")
	@Enumerated(EnumType.STRING)
	private DiretoriaEnum diretoria;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	public DiretoriaEnum getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(DiretoriaEnum diretoria) {
		this.diretoria = diretoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		DepartamentoEntity other = (DepartamentoEntity) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartamentoEntity [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}

}
