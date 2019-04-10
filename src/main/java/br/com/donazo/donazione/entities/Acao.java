/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.donazo.donazione.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "acao")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Acao.findAll", query = "SELECT a FROM Acao a"),
		@NamedQuery(name = "Acao.findById", query = "SELECT a FROM Acao a WHERE a.id = :id"),
		@NamedQuery(name = "Acao.findByNome", query = "SELECT a FROM Acao a WHERE a.nome = :nome"),
		@NamedQuery(name = "Acao.findByDescricao", query = "SELECT a FROM Acao a WHERE a.descricao = :descricao"),
		@NamedQuery(name = "Acao.findByInicio", query = "SELECT a FROM Acao a WHERE a.inicio = :inicio"),
		@NamedQuery(name = "Acao.findByFim", query = "SELECT a FROM Acao a WHERE a.fim = :fim"),
		@NamedQuery(name = "Acao.findByCadastro", query = "SELECT a FROM Acao a WHERE a.cadastro = :cadastro"),
		@NamedQuery(name = "Acao.findByCargaHoraria", query = "SELECT a FROM Acao a WHERE a.cargaHoraria = :cargaHoraria") })
public class Acao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nome")
	private String nome;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "descricao")
	private String descricao;
	@Basic(optional = false)
	@NotNull
	@Column(name = "inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	@Basic(optional = false)
	@NotNull
	@Column(name = "fim")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fim;
	@Basic(optional = false)
	@NotNull
	@Column(name = "cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	@Basic(optional = false)
	@NotNull
	@Column(name = "cargaHoraria")
	private int cargaHoraria;

	public Acao() {
	}

	public Acao(final Integer id) {
		this.id = id;
	}

	public Acao(final Integer id, final String nome, final String descricao, final Date inicio, final Date fim,
			final Date cadastro, final int cargaHoraria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.inicio = inicio;
		this.fim = fim;
		this.cadastro = cadastro;
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(final Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return this.fim;
	}

	public void setFim(final Date fim) {
		this.fim = fim;
	}

	public Date getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(final Date cadastro) {
		this.cadastro = cadastro;
	}

	public int getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(final int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(final Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Acao)) {
			return false;
		}
		final Acao other = (Acao) object;
		if (((this.id == null) && (other.id != null)) || ((this.id != null) && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.org.centrocac.entidade.Acao[ id=" + this.id + " ]";
	}

}
