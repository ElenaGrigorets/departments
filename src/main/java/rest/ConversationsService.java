package rest;

import rest.model.Student;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@Path("/students")
public class ConversationsService {

	@GET
	@Path("/getStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Student> getTrackInJSON() throws IOException {

		Student student = new Student();
		student.setName("Dima");
		student.setAge(37);
		Student student2 = new Student();
		student2.setName("Lena");
		student2.setAge(30);
		return Arrays.asList(student, student2);
	}

//	@POST
//	@Path("/post")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response createTrackInJSON(Conversation conversation) {
//
//		DB.conversationMap.put(conversation.getSubevaluationId(), conversation);
//		return Response.status(201).entity("Conversation is saved successfully").build();
//
//	}

}