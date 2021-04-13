package common.api;

import io.vertx.core.json.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;

@Path("api")
public class API {
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("multipart/form-data")
    public JsonObject upload() {
        var j = new JsonObject().put("aaa", "value");
        return j;
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
