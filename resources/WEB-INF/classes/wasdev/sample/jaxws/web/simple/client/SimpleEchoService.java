
package wasdev.sample.jaxws.web.simple.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "SimpleEchoService", targetNamespace = "http://simple.web.jaxws.sample.wasdev/", wsdlLocation = "WEB-INF/wsdl/SimpleEchoService.wsdl")
public class SimpleEchoService extends Service {

    private final static URL SIMPLEECHOSERVICE_WSDL_LOCATION;

    private final static Logger logger = Logger
            .getLogger(wasdev.sample.jaxws.web.simple.client.SimpleEchoService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = wasdev.sample.jaxws.web.simple.client.SimpleEchoService.class.getResource(".");
            url = new URL(baseUrl, "WEB-INF/wsdl/SimpleEchoService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:9080/JaxWsLibertyDemo/SimpleEchoService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SIMPLEECHOSERVICE_WSDL_LOCATION = url;
    }

    public SimpleEchoService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SimpleEchoService() {
        super(SIMPLEECHOSERVICE_WSDL_LOCATION, new QName("http://simple.web.jaxws.sample.wasdev/",
                "SimpleEchoService"));
    }

    /**
     * 
     * @return
     *     returns SimpleEcho
     */
    @WebEndpoint(name = "SimpleEchoPort")
    public SimpleEcho getSimpleEchoPort() {
        return super
                .getPort(new QName("http://simple.web.jaxws.sample.wasdev/", "SimpleEchoPort"), SimpleEcho.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SimpleEcho
     */
    @WebEndpoint(name = "SimpleEchoPort")
    public SimpleEcho getSimpleEchoPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://simple.web.jaxws.sample.wasdev/", "SimpleEchoPort"),
                SimpleEcho.class, features);
    }

}
