package common.helpers;

import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.core.MediaType;
import java.io.File;

public class FormData {
    @FormParam("file")
//    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public File file;
}