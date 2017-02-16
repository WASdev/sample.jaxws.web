
package wasdev.sample.jaxws.web.wsfeatures.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ImageServiceImpl", targetNamespace = "http://jaxws.service/")
@XmlSeeAlso({ ObjectFactory.class })
public interface ImageServiceImpl {

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns byte[]
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "uploadImage", targetNamespace = "http://jaxws.service/", className = "wasdev.sample.jaxws.web.wsfeatures.client.UploadImage")
    @ResponseWrapper(localName = "uploadImageResponse", targetNamespace = "http://jaxws.service/", className = "wasdev.sample.jaxws.web.wsfeatures.client.UploadImageResponse")
    public byte[] uploadImage(@WebParam(name = "arg0", targetNamespace = "") String arg0,
            @WebParam(name = "arg1", targetNamespace = "") byte[] arg1);

}
