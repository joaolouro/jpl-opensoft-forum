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
	private Collection<RespostaBO> respostas = new ArrayList<RespostaBO>(0);

	public TopicoBO(){}
	
	public TopicoBO(Topico topico)
	{
		this.idtopico = topico.getidtopico();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.autor = topico.getAutor();
		
		for(Resposta resposta : topico.getRespostas())
		{
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

	public Collection<RespostaBO> getRespostas() {
		return respostas;
	}

	public void setRespostas(Collection<RespostaBO> respostas) {
		this.respostas = respostas;
	}
	
}
