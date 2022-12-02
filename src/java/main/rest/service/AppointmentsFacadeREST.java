/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.rest.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import main.entities.Appointments;
import main.entities.AppointmentsPK;

/**
 *
 * @author J-ANONIMO
 */
//@javax.ejb.Stateless
@Path("main.entities.appointments")
public class AppointmentsFacadeREST extends AbstractFacade<Appointments> {

    @PersistenceContext(unitName = "TrylPU")
    private EntityManager em;

    private AppointmentsPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;clientId=clientIdValue;id=idValue;stylistId=stylistIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        main.entities.AppointmentsPK key = new main.entities.AppointmentsPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> clientId = map.get("clientId");
        if (clientId != null && !clientId.isEmpty()) {
            key.setClientId(new java.lang.Integer(clientId.get(0)));
        }
        java.util.List<String> id = map.get("id");
        if (id != null && !id.isEmpty()) {
            key.setId(new java.lang.Integer(id.get(0)));
        }
        java.util.List<String> stylistId = map.get("stylistId");
        if (stylistId != null && !stylistId.isEmpty()) {
            key.setStylistId(new java.lang.Integer(stylistId.get(0)));
        }
        return key;
    }

    public AppointmentsFacadeREST() {
        super(Appointments.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Appointments entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Appointments entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        main.entities.AppointmentsPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Appointments find(@PathParam("id") PathSegment id) {
        main.entities.AppointmentsPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appointments> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Appointments> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
