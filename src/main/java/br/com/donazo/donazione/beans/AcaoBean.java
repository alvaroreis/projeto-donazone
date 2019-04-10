package br.com.donazo.donazione.beans;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.donazo.donazione.entities.Acao;
import br.com.donazo.donazione.repositorios.AcaoRepository;

@Named
@RequestScoped
public class AcaoBean implements Serializable {

	private static final long serialVersionUID = -858774744832095173L;

	private Acao acao;

	private Iterable<Acao> acoes;

	@Inject
	private AcaoRepository acaoRepository;

	@PostConstruct
	public void init() {
		this.acao = new Acao();
		this.acao.setCadastro(new Date());
		this.acoes = this.acaoRepository.findAll();
	}

	public void prepaprar() {
		this.acao = new Acao();
		this.acao.setCadastro(new Date());
	}

	public String gravarInserir() {

		this.acaoRepository.save(this.acao);
		return "/pages/acao/lista.xhtml";
	}

	/**
	 * @return the acao
	 */
	public Acao getAcao() {

		return this.acao;
	}

	/**
	 * @param acao the acao to set
	 */
	public void setAcao(final Acao acao) {

		this.acao = acao;
	}

	/**
	 * @return the acoes
	 */
	public Iterable<Acao> getAcoes() {

		return this.acoes;
	}

	/**
	 * @param acoes the acoes to set
	 */
	public void setAcoes(final Iterable<Acao> acoes) {

		this.acoes = acoes;
	}

}
