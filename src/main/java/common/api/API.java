package common.api;

import common.helpers.FormData;
import io.vertx.core.json.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("api")
public class API {

    public static class Resource {

        @FormParam("file")
//        @PathParam(MediaType.APPLICATION_OCTET_STREAM)
        public File file;

        public Resource() {
        }

        public String getName() {
            return file.getName();
        }
    }

    /**
     * TODO: Переделать на инъекцию зависимости при старте
     */
    final String rootPath = "C:\\Users\\ashcheulovmr\\Documents\\borscht\\vodka\\";

    /**
     * TODO: Метод загрузки на сервер
     *
     * @return
     */
    @POST
    @Path("upload")
//    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public JsonObject upload(@MultipartForm Resource upload) {
        System.out.println("here was");
        try {
            System.out.println(upload.file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        var j = new JsonObject().put("aaa", "value");
        return j;
    }

    /**
     * Загрузка файла и вывод его размера
     * @param fileData
     * @return
     * @throws IOException
     */
    @POST
    @Path("file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@MultipartForm FormData fileData) throws IOException {
        System.out.println("Received file of size = ");
        System.out.println(fileData.file.length());
        return Response.ok().build();
    }

    /**
     * Метод возвращающий объект по ссылке
     *
     * @param uid уникальное имя объекта
     * @return объект
     */
    @GET
    @Path("get/{uid}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public File getObject(@PathParam("uid") String uid) throws IOException {
        //TODO: валидация идентификатора т.е. обращение к индексации и проверка наличия такого идентификатора

        //TODO: валидация объекта с таким идентификатором

        File f = new File(rootPath + uid);
        return f;
    }
}
