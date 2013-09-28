package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.MediaType;

//http://localhost:8080/RESTfulExample/rest/message/hello%20world
@Path("/message")
public class MessageRestService {

	private static final String FILENAME = "File.txt";
	private static final String IMGFILENAME = "Image.png";

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/getfile")
	@Produces("text/plain")
	public Response getFile() {

		ResponseBuilder response = Response.ok((Object) new File(FILENAME));
		response.header("Content-Disposition",
				"attachment; filename=\"File.txt\"");
		return response.build();

	}

	@GET
	@Path("/getimage")
	@Produces("image/png")
	public Response getImage() {

		ResponseBuilder response = Response.ok((Object) new File(IMGFILENAME));
		response.header("Content-Disposition",
				"inline; filename=\"Image.png\"");
		return response.build();

	}


}
