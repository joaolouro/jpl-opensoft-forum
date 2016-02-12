package com.forum.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.forum.entityBO.RespostaBO;
import com.forum.entityBO.TopicoBO;
import com.forum.service.TopicoService;

@RestController
public class TopicoController
{
	
	@Autowired
	private TopicoService service;
	
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/topic/create", method = RequestMethod.POST)
    public void createTopico(@RequestBody TopicoBO topicobo)
    {
		service.createTopic(topicobo);
	}
	
    @ResponseStatus(HttpStatus.OK)
	@RequestMapping("/topic/respond")
	public void respondTopico(@RequestBody RespostaBO respostabo)
	{
    	service.postTopicReply(respostabo);
	}


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/topic/list", method = RequestMethod.GET)
	public Collection<TopicoBO> getAllTopics()
	{
		return service.getAllTopics();
	}


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/topic/consult/{id}", method = RequestMethod.GET)
	public TopicoBO consultTopico(@PathVariable (value = "id") int id)
	{
    	return service.getTopic(id);
	}
}
