package com.forum.entitymodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "resposta")
public class Resposta
{

	private int idresposta;
	private String mensagem;
	private String autor;
	private long data_criacao;
	@JsonManagedReference
	private Topico topico;
	
	public Resposta(){}
	
	public Resposta(String mensagem, String autor, long data_criacao)
	{
		this.setMensagem(mensagem);
		this.setAutor(autor);
		this.setData_criacao(data_criacao);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getidresposta()
	{
		return this.idresposta;
	}
	
	public void setidresposta(int idresposta)
	{
		this.idresposta = idresposta;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

    @ManyToOne
    @JoinColumn(name = "idtopicofk")
    public Topico getTopico() {
        return this.topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

	public long getData_criacao() {
		return this.data_criacao;
	}

	public void setData_criacao(long data_criacao) {
		this.data_criacao = data_criacao;
	}

}