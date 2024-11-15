package com.sollares.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name = "nome_disciplina")
	private String nomeDisciplina;
	
	@Column(name = "carga_horaria")
	private int cargaHoraria;
	
	@Column(name = "limite_alunos")
	private int limiteAlunos;
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Pessoa professor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "disciplina")
	private List<Matricula> matriculas = new ArrayList<>();
	
	public Disciplina() {
	}
	
	public Disciplina(int codigo, String nomeDisciplina, int cargaHoraria, Pessoa professor, int limiteAlunos) {
		this.codigo = codigo;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
		this.limiteAlunos = limiteAlunos;
	}
	
	

	public int getCodigo() {
		return codigo;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getLimiteAlunos() {
		return limiteAlunos;
	}

	public void setLimiteAlunos(int limiteAlunos) {
		this.limiteAlunos = limiteAlunos;
	}

	public Pessoa getProfessor() {
		return professor;
	}

	public void setProfessor(Pessoa professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return codigo == other.codigo;
	}
}
