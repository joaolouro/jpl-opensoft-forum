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
	private Collection<RespostaBO> respostas = new ArrayList<RespostaBO>(0);

	public TopicoBO(){}
	
	public TopicoBO(Topico topico)
	{
		this.idtopico = topico.getidtopico();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.autor = topico.getAutor();
		this.nr_respostas += topico.getRespostas().size();
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
	
	public int getNr_respostas()
	{
		return nr_respostas;
	}

	public void setNr_respostas(int nr_respostas)
	{
		this.nr_respostas = nr_respostas;
	}
	
}
