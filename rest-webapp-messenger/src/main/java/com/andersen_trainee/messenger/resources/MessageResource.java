package com.andersen_trainee.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.andersen_trainee.messenger.model.Message;
import com.andersen_trainee.messenger.service.MessageService;

@Path("messages")
public class MessageResource {
	private MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> showAllMessages() {
		return messageService.getAllMessages();
	}

	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageById(@PathParam("messageId") int id) {
		return messageService.getMessageById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message message) {
		return messageService.updateMessage(message);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message add(Message message) {
		return messageService.addMessage(message);
	}
	
	@DELETE
	@Path("{messageId}")
	public void deleteMessage(@PathParam("messageId") int id) {
		messageService.deleteMessage(id);
	}

}
