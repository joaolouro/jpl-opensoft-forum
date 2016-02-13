package com.forum.entitymodel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "topico")
public class Topico
{

	private int idtopico;
	private String titulo;
	private String mensagem;
	private String autor;
	private long data_criacao;
	@JsonBackReference
	private Set<Resposta> respostas;
	
	public Topico(){}
	
	public Topico(String titulo, String mensagem, String autor, long data_criacao)
	{
		this.setTitulo(titulo);
		this.setMensagem(mensagem);
		this.setAutor(autor);
		this.setData_criacao(data_criacao);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getidtopico()
	{
		return this.idtopico;
	}
	
	public void setidtopico(int idtopico)
	{
		this.idtopico = idtopico;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	
	public long getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(long data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	@OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
	public Set<Resposta> getRespostas() {
		return this.respostas;
	}

	public void setRespostas(Set<Resposta> respostas)
	{

        if (this.respostas == null)
        {
            this.respostas = new HashSet<Resposta>();          
        }
        
 		for (Resposta resposta : respostas)
 		{
 			this.addResposta(resposta);
 		}
		
	}
	
	public void addResposta(Resposta resposta)
	{
		if (resposta != null)
		{
	        if (this.respostas == null)
	        {
	            this.respostas = new HashSet<Resposta>();          
	        }
	        
	        this.respostas.add(resposta);
	        resposta.setTopico(this);
	     }
	}
	
	@Override
	public String toString()
	{
		String result = String.format(
				"Topico[id=%d, titulo='%s', mensagem='%s', autor='%s']%n", 
				this.idtopico, this.titulo, this.mensagem, this.autor);
		
		if (respostas != null)
		{
			for(Resposta resposta : respostas)
			{
                result += String.format(
                		"Resposta[id=%d, mensagem='%s', autor='%s']%n", 
                		resposta.getidresposta(), resposta.getMensagem(), resposta.getAutor());
			}
		}
		
		return result;
	}
}