
package wasdev.sample.jaxws.web.catalog.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "CalculatorPortType", targetNamespace = "http://catalog.web.jaxws.sample.wasdev")
@XmlSeeAlso({ ObjectFactory.class })
public interface CalculatorPortType {

    /**
     * 
     * @param value1
     * @param value2
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "http://catalog.web.jaxws.sample.wasdev")
    @RequestWrapper(localName = "add", targetNamespace = "http://catalog.web.jaxws.sample.wasdev", className = "wasdev.sample.jaxws.web.catalog.client.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://catalog.web.jaxws.sample.wasdev", className = "wasdev.sample.jaxws.web.catalog.client.AddResponse")
    public int add(@WebParam(name = "value1", targetNamespace = "http://catalog.web.jaxws.sample.wasdev") int value1,
            @WebParam(name = "value2", targetNamespace = "http://catalog.web.jaxws.sample.wasdev") int value2);

}
