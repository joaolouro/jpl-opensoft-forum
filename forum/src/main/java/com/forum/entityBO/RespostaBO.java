package com.forum.entityBO;

import com.forum.entitymodel.Resposta;

public class RespostaBO
{
	
	private int idresposta;
	private String mensagem;
	private String autor;
	private int topico_id;

	public RespostaBO(){}
	
	public RespostaBO(Resposta resposta)
	{
		this.idresposta = resposta.getidresposta();
		this.mensagem = resposta.getMensagem();
		this.autor = resposta.getAutor();
	}

	public int getIdresposta() {
		return idresposta;
	}

	public void setIdresposta(int idresposta) {
		this.idresposta = idresposta;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getTopico_id() {
		return topico_id;
	}

	public void setTopico_id(int topico_id) {
		this.topico_id = topico_id;
	}

}
