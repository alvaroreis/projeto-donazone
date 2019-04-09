package br.com.donazo.donazione.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.donazo.donazione.entities.Acao;
import br.com.donazo.donazione.repositorios.AcaoRepository;

@Named
@RequestScoped
public class AcaoBean {

    private Acao acao;

    private Iterable<Acao> acoes;

    public void init(final AcaoRepository acaoRepository) {

        this.acoes = acaoRepository.findAll();
    }

    /**
     * @return the acao
     */
    public Acao getAcao() {

        return this.acao;
    }

    /**
     * @param acao
     *            the acao to set
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
     * @param acoes
     *            the acoes to set
     */
    public void setAcoes(final Iterable<Acao> acoes) {

        this.acoes = acoes;
    }

}
