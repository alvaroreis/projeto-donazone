package br.com.donazo.donazione.beans;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;

import br.com.donazo.donazione.entities.Acao;
import br.com.donazo.donazione.repositorios.AcaoRepository;
import br.com.donazo.donazione.utils.MessagesUtil;

@Named
@ViewScoped
public class AcaoBean implements Serializable {

    private static final long serialVersionUID = -858774744832095173L;

    private Acao acao;

    private Acao acaoSelecionado;

    private Iterable<Acao> acoes;

    @Inject
    private AcaoRepository acaoRepository;

    @PostConstruct
    public void init() {

        this.acoes = this.acaoRepository.findAll();
    }

    public void prepaprar() {

        if (this.acao != null) {
            this.acao = new Acao();
            this.acao.setCargaHoraria(1);
            this.acao.setCadastro(new Date());
        }

    }

    public void gravarInserir() {

        try {
            this.acaoRepository.save(this.acao);
            this.prepaprar();
            MessagesUtil.criarMensagemDeInformacao("Ação " + this.acao.getNome() + "  salva.");
        } catch (final Exception e) {
            MessagesUtil.criarMensagemDeErro(e.getMessage());
        }
    }

    public void gravarExcluir() {

        try {
            MessagesUtil.criarMensagemDeInformacao("Ação " + this.acao.getNome() + "  excluída.");
            this.acaoRepository.delete(this.acao);
        } catch (final Exception e) {
            MessagesUtil.criarMensagemDeErro(e.getMessage());
        }

    }

    public void closeEvent(final CloseEvent closeEvent) {

        this.init();
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
     * @return the acaoSelecionado
     */
    public Acao getAcaoSelecionado() {

        return this.acaoSelecionado;
    }

    /**
     * @param acaoSelecionado
     *            the acaoSelecionado to set
     */
    public void setAcaoSelecionado(final Acao acaoSelecionado) {

        this.acaoSelecionado = acaoSelecionado;
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
