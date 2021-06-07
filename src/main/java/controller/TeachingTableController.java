package controller;

import entity.TeachingTable;
import service.TeachingTableService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/teaching_tables")
public class TeachingTableController {

    TeachingTableService teachingTableServiceService = new TeachingTableService();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeachingTable> getListTeachingTable() {
        return teachingTableServiceService.getListTeaching();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewTeachingTable(TeachingTable teachingTable) {
        return teachingTableServiceService.insert(teachingTable) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String UpdateTeachingTable(TeachingTable teachingTable){
        return teachingTableServiceService.update(teachingTable) ? "Update thành công" : "Update thất bại";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeTeachingTable(@PathParam("id") int id) {
        return teachingTableServiceService.removeTeacher(id) ? "Xóa thành công" : "Xóa thất bại";
    }
}
