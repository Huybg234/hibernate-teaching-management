package controller;

import entity.Subject;
import service.SubjectService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/subjects")
public class SubjectController {

    SubjectService subjectService = new SubjectService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subject> getListSubject() {
        return subjectService.getListSubject();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewSubject(Subject subject) {
        return subjectService.insert(subject) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String UpdateSubject(Subject subject) {
        return subjectService.update(subject) ? "Update thành công" : "Update thất bại";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeSubject(@PathParam("id") int id) {
        return subjectService.removeSubject(id) ? "Xóa thành công" : "Xóa thất bại";
    }

}
