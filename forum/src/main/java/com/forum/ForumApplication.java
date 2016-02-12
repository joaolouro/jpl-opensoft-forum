package com.forum;


import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumApplication implements CommandLineRunner
{

	public static void main(String[] args)
	{
		SpringApplication.run(ForumApplication.class, args);
	}
	

	@Override
    @Transactional
    public void run(String... strings) throws Exception
	{
		/*
		Topico topico_1 = new Topico("titulo 1", "discussoa titulo 1", "autor 1");
		
		
		topicoRepository.saveResposta(topico_1, new Resposta("resposta 1", "autor 2"));
		topicoRepository.saveResposta(topico_1, new Resposta("resposta 2", "autor 3"));
		topicoRepository.saveResposta(topico_1, new Resposta("resposta 3", "autor 4"));
		
		
		Topico topico_2 = new Topico("titulo 2", "discussoa titulo 2", "autor 2");
		
		topico_2.setRespostas(new HashSet<Resposta>()
		{
			{
	            add(new Resposta("resposta 1", "autor 1"));
	            add(new Resposta("resposta 2", "autor 3"));
	            add(new Resposta("resposta 3", "autor 4"));
			}
		});
		
		topicoRepository.save(new HashSet<Topico>()
		{
			{
				add(topico_1);
				add(topico_2);
			}
		});
		
		topico_2.addResposta(new Resposta("resposta simples", "autor exterior"));
		
		topicoRepository.save(topico_2);
		
		// fetch all categories
		for (Topico topico : topicoRepository.findAll())
		{
			logger.info(topico.toString());
		}
		*/
	}
}