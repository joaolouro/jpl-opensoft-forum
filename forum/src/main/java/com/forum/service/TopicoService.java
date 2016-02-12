package com.forum.service;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forum.entityBO.RespostaBO;
import com.forum.entityBO.TopicoBO;
import com.forum.entitymodel.Resposta;
import com.forum.entitymodel.Topico;
import com.forum.repository.TopicoRepository;

@Service
public class TopicoService
{
	@Autowired
    private TopicoRepository repository;
	
	@Transactional(readOnly = true)
	public Collection<TopicoBO> getAllTopics()
	{
		Collection<TopicoBO> topicos = new ArrayList<TopicoBO>();
		for (Topico topico : repository.findAll())
		{
			topicos.add(new TopicoBO(topico));
		}
		return topicos;
	}
	
	@Transactional(readOnly = true)
	public TopicoBO getTopic(int id)
	{
		TopicoBO topico_bo = new TopicoBO(repository.findOne(id));	
		return topico_bo;
	}

	@Transactional
	public void createTopic(TopicoBO topico)
	{
		repository.save(new Topico(topico.getTitulo(), topico.getMensagem(), topico.getAutor()));	
	}
	
	@Transactional
	public void postTopicReply(RespostaBO respostabo)
	{
		repository.saveResposta(repository.findOne(respostabo.getTopico_id()), new Resposta(respostabo.getMensagem(), respostabo.getAutor()));
	}
}
