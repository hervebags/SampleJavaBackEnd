package za.co.rest.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.MediaType;

//http://localhost:8080/javarestservice/rest/codejam/display/hi
@Path("/codejam")
public class RestService {

	private static final String FILENAME = "/File.txt";
	private static final String IMGFILENAME = "/Image.jpg";
	private static final String SOUNDFILENAME = "/Sound.mp3";

	@GET
	@Path("display/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/getfileinline")
	@Produces("text/plain")
	public Response getFileInline() {
		String fileUrl = getClass().getClassLoader().getResource(FILENAME).getFile();
		ResponseBuilder response = Response.ok((Object) new File(fileUrl));
		response.header("Content-Disposition",
				"inline; filename=\"File.txt\"");
		return response.build();
	}
	
	@GET
	@Path("/getfiledownload")
	@Produces("text/plain")
	public Response getFile() {
		String fileUrl = getClass().getClassLoader().getResource(FILENAME).getFile();
		ResponseBuilder response = Response.ok((Object) new File(fileUrl));
		response.header("Content-Disposition",
				"attachment; filename=\"File.txt\"");
		return response.build();
	}

	@GET
	@Path("/getimageinline")
	@Produces("image/jpeg")
	public Response getImageInline() {
		String fileUrl = getClass().getClassLoader().getResource(IMGFILENAME).getFile();
		ResponseBuilder response = Response.ok((Object)new File(fileUrl));
		response.header("Content-Disposition",
				"inline; filename=\"Image.jpg\"");
		return response.build();
	}
	
	@GET
	@Path("/getimagedownload")
	@Produces("image/jpeg")
	public Response getImageDownload() {
		String fileUrl = getClass().getClassLoader().getResource(IMGFILENAME).getFile();
		ResponseBuilder response = Response.ok((Object)new File(fileUrl));
		response.header("Content-Disposition",
				"attachment; filename=\"Image.jpg\"");
		return response.build();
	}
	
	@GET
	@Path("/getsounddownload")
	@Produces("image/jpeg")
	public Response getSoundDownload() {
		String fileUrl = getClass().getClassLoader().getResource(SOUNDFILENAME).getFile();
		ResponseBuilder response = Response.ok((Object)new File(fileUrl));
		response.header("Content-Disposition",
				"attachment; filename=\"Sound.mp3\"");
		return response.build();
	}
	
	@GET
	@Path("/getsoundplay")
	@Produces("audio/mpeg")
	public Response getSoundPlay() {
		String fileUrl = getClass().getClassLoader().getResource(SOUNDFILENAME).getFile();
		ResponseBuilder response = Response.ok((Object)new File(fileUrl));
		response.header("Content-Disposition",
				"inline; filename=\"Sound.mp3\"");
		return response.build();
	}
}
