package com.test.restapi.application;

import com.test.model.Electronics;
import com.test.model.Employee;
import com.test.service.ElectronicsService;
import com.test.service.EmployeeService;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Hog
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/store",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Store.Rest" }, service = Application.class)
public class RestControllerApplication extends Application {

	@Reference
	private EmployeeService employeeService;
	
	@Reference
	private ElectronicsService electronicsService;

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployees() {
		
		try {
			List<Employee> employees = employeeService.getEmployees(); 
			return Response.ok(employees).build();		
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("employeeId") long employeeId) {

		try {
			return Response.ok(employeeService.getEmployeeById(employeeId)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@GET()
	@Path("/electronics")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getElectronicsByCount() {
		
		try {
			List<Electronics> electronics = electronicsService.getElectronicsByCount();
			return Response.ok(electronics).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}