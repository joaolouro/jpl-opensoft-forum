package com.forum.entityBO;

import java.util.ArrayList;
import java.util.Collection;

import com.forum.entitymodel.Resposta;
import com.forum.entitymodel.Topico;

public class TopicoBO 
{
	
	private int idtopico;
	private String titulo;
	private String mensagem;
	private String autor;
	private int nr_respostas = 1;
	private long data_criacao;
	private long data_ultima_resposta;
	private Collection<RespostaBO> respostas = new ArrayList<RespostaBO>(0);

	public TopicoBO(){}
	
	public TopicoBO(Topico topico)
	{
		this.idtopico = topico.getidtopico();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.autor = topico.getAutor();
		this.data_criacao = topico.getData_criacao();
		this.nr_respostas += topico.getRespostas().size();
		this.data_ultima_resposta = this.getData_criacao();

		for(Resposta resposta : topico.getRespostas())
		{
			this.data_ultima_resposta = Math.max(this.data_ultima_resposta, resposta.getData_criacao());   
			RespostaBO respostabo = new RespostaBO(resposta);
			respostas.add(respostabo);
		}
	}

	public int getIdtopico() {
		return idtopico;
	}

	public void setIdtopico(int idtopico) {
		this.idtopico = idtopico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	
	public int getNr_respostas()
	{
		return nr_respostas;
	}

	public void setNr_respostas(int nr_respostas)
	{
		this.nr_respostas = nr_respostas;
	}
	
	public long getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(long data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Collection<RespostaBO> getRespostas() {
		return respostas;
	}

	public void setRespostas(Collection<RespostaBO> respostas) {
		this.respostas = respostas;
	}

	public long getData_ultima_resposta() {
		return data_ultima_resposta;
	}

	public void setData_ultima_resposta(long data_ultima_resposta) {
		this.data_ultima_resposta = data_ultima_resposta;
	}
	
	@Override
	public String toString()
	{
		String result = String.format(
				"Topico[id=%d, titulo='%s', mensagem='%s', autor='%s', data_criacao=%d, nr_respostas=%d, data_ultima_resposta=%d]%n", 
				this.idtopico, this.titulo, this.mensagem, this.autor, this.data_criacao, this.nr_respostas, this.data_ultima_resposta);
		
		if (respostas != null)
		{
			for(RespostaBO resposta : this.respostas)
			{
                result += resposta.toString();
			}
		}
		
		return result;
	}
}
