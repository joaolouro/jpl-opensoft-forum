package com.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.entitymodel.Resposta;
import com.forum.entitymodel.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Integer>
{
	default void saveResposta(Topico topico, Resposta resposta)
	{
		topico.addResposta(resposta);
		this.save(topico);
	}
}