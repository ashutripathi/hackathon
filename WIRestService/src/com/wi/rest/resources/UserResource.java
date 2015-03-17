/**
 * 
 */
package com.wi.rest.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.wi.rest.bean.Amanat;
import com.wi.rest.bean.Asset;


/**
 * @author Neel
 *
 */
@Path("user")
public class UserResource {
	
	
	
	@GET
	@Path("a")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello(@QueryParam ("id") String id) {
		System.out.println("Hello");
		RegistrationResponse response = new RegistrationResponse();
		System.out.println("id"+id);
		
		try {
			List<Asset> assets = new ArrayList<Asset>();
			File file = new File("C:\\xampp\\htdocs\\hackamanatXML.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Amanat.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Amanat amanat = (Amanat) jaxbUnmarshaller.unmarshal(file);
			//System.out.println(customer);
			assets=amanat.getAsset();
			
			for(Asset asset:assets)
			{
				if(asset.getAssetid().equalsIgnoreCase(id))
				{
					response.setEmpId(asset.getEmpid());
					response.setStatus(1);
				}
			}
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		
		
		/*if(id.equalsIgnoreCase("S00001"))
		{
			response.setRegistered(true);
		}*/
		//return "a";
		return Response.ok(response, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
	}
/*	@POST
	@Path("a")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHello(JAXBElement<RegistrationRequest> elem) {
		System.out.println("Hello");
		RegistrationRequest bookingMessage = elem.getValue();
		// Get sender id from DB
		String senderId = bookingMessage.getAndroidId();
		String userMessage = bookingMessage.getUserName();
		System.out.println("a-"+senderId);
		System.out.println("b-"+userMessage);
		RegistrationResponse response = new RegistrationResponse();
		response.setRegistered(false);
		if(senderId.equalsIgnoreCase("S00001"))
		{
			response.setRegistered(true);
		}
		//return "a";
		return Response.ok(response, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
	}*/
	
	/*@Path("post")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendToGCM(JAXBElement<BookingMessage> elem) {
		System.out.println("inside sendToGCM");
		// API key is used to authenticate the application for using GCM services
		// This key is provided by google play services
		String apiKey = "AIzaSyBgej2CLiwX_loeMrZjUGwjqwmzNwJ3v24";
		BookingMessage bookingMessage = elem.getValue();
		// Get sender id from DB
		String senderId = bookingMessage.getSenderId();
		String userMessage = bookingMessage.getMessage();
		
		List<String> androidTarget = new ArrayList<>();
		// This is the list of target devices 
		// where the message is to be sent from GCM server
		androidTarget.add(senderId);
		
		Sender sender = new Sender(apiKey);
		Message message = new Message.Builder()
			.collapseKey("collapseKey")
			.delayWhileIdle(true)
			.addData("message", userMessage)
			.build();
		
		try {
			MulticastResult result = sender.send(message, androidTarget, 1);
			if (result.getResults() != null) {
				int canonicalRegId = result.getCanonicalIds();
				System.out.println("canonical ids:" + canonicalRegId);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "fail";
		}
		
		return "success"; 
	}
	
	@POST
	@Path("getRegistration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRegistrationStatus(JAXBElement<RegistrationRequest> request) {
		RegistrationResponse response = new RegistrationResponse();
		response.setRegistered(false);
		return Response.ok(response, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(JAXBElement<RegistrationRequest> request) {
		RegistrationResponse response = new RegistrationResponse();
		delegate.registerUser(request.getValue());
		//userDAO.registerUser(request.getValue());
		return Response.ok(response, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
	}*/
}
