
package wasdev.sample.jaxws.web.webservicecontext.client;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "WebServiceContextQuery", targetNamespace = "http://webservicecontext.web.jaxws.sample.wasdev/")
@XmlSeeAlso({ ObjectFactory.class })
public interface WebServiceContextQuery {

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "query", targetNamespace = "http://webservicecontext.web.jaxws.sample.wasdev/", className = "wasdev.sample.jaxws.web.webservicecontext.client.Query")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "http://webservicecontext.web.jaxws.sample.wasdev/", className = "wasdev.sample.jaxws.web.webservicecontext.client.QueryResponse")
    public String query();

}
