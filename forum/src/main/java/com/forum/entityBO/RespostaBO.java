package com.forum.entityBO;

import com.forum.entitymodel.Resposta;

public class RespostaBO
{
	
	private int idresposta;
	private String mensagem;
	private String autor;
	private long data_criacao;
	private int topico_id;

	public RespostaBO(){}
	
	public RespostaBO(Resposta resposta)
	{
		this.idresposta = resposta.getidresposta();
		this.mensagem = resposta.getMensagem();
		this.autor = resposta.getAutor();
		this.data_criacao = resposta.getData_criacao();
		this.topico_id = resposta.getTopico().getidtopico();
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

	public long getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(long data_criacao) {
		this.data_criacao = data_criacao;
	}

	@Override
	public String toString()
	{
		String result = String.format(
				"Resposta[id=%d, autor='%s', mensagem='%s', data_criacao=%d, topico_id=%d]%n", 
				this.idresposta, this.autor, this.mensagem, this.data_criacao, this.topico_id);
		
		return result;
	}
	
}
