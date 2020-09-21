package org.acme;

import org.acme.model.User;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> getAllUsers() {
        return User.listAll();
    }

    @GET
    @Path("/{id}")
    public User getById(@PathParam long id) {
        return (User) User.findByIdOptional(id).orElseThrow(() -> new NotFoundException("No user with id " + id));
    }

    @POST
    @Transactional
    public void createUser(User user) {
        user.persist();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteById(@PathParam long id) {
        User.deleteById(id);
    }
}
