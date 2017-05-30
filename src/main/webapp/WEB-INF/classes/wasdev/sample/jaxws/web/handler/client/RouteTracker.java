
package wasdev.sample.jaxws.web.handler.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "RouteTracker", targetNamespace = "http://web.jaxws.sample.wasdev/")
@XmlSeeAlso({ ObjectFactory.class })
public interface RouteTracker {

    /**
     * 
     * @param message
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "track", targetNamespace = "http://web.jaxws.sample.wasdev/", className = "wasdev.sample.jaxws.web.handler.client.Track")
    @ResponseWrapper(localName = "trackResponse", targetNamespace = "http://web.jaxws.sample.wasdev/", className = "wasdev.sample.jaxws.web.handler.client.TrackResponse")
    public String track(@WebParam(name = "message", targetNamespace = "") String message);

}
