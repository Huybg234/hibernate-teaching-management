package controller;

import entity.Teacher;
import service.TeacherService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teachers")
public class TeacherController {

    TeacherService teacherService = new TeacherService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Teacher> getListTeacher() {
        return teacherService.getListTeacher();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewTeacher(Teacher teacher) {
        return teacherService.insert(teacher) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String UpdateTeacher(Teacher teacher){
        return teacherService.update(teacher) ? "Update thành công" : "Update thất bại";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeTeacher(@PathParam("id") int id) {
        return teacherService.removeTeacher(id) ? "Xóa thành công" : "Xóa thất bại";
    }
}
