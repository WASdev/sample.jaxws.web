
package wasdev.sample.jaxws.web.webservicecontext.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "WebServiceContextQueryService", targetNamespace = "http://webservicecontext.web.jaxws.sample.wasdev/", wsdlLocation = "WEB-INF/wsdl/WebServiceContextQueryService.wsdl")
public class WebServiceContextQueryService extends Service {

    private final static URL WEBSERVICECONTEXTQUERYSERVICE_WSDL_LOCATION;

    private final static Logger logger = Logger
            .getLogger(wasdev.sample.jaxws.web.webservicecontext.client.WebServiceContextQueryService.class
                    .getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = wasdev.sample.jaxws.web.webservicecontext.client.WebServiceContextQueryService.class
                    .getResource(".");
            url = new URL(baseUrl, "http://localhost:9080/JaxWsLibertyDemo/WebServiceContextQueryService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:9080/JaxWsLibertyDemo/WebServiceContextQueryService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        WEBSERVICECONTEXTQUERYSERVICE_WSDL_LOCATION = url;
    }

    public WebServiceContextQueryService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceContextQueryService() {
        super(WEBSERVICECONTEXTQUERYSERVICE_WSDL_LOCATION, new QName(
                "http://webservicecontext.web.jaxws.sample.wasdev/", "WebServiceContextQueryService"));
    }

    /**
     * 
     * @return
     *     returns WebServiceContextQuery
     */
    @WebEndpoint(name = "WebServiceContextQueryPort")
    public WebServiceContextQuery getWebServiceContextQueryPort() {
        return super.getPort(new QName("http://webservicecontext.web.jaxws.sample.wasdev/",
                "WebServiceContextQueryPort"), WebServiceContextQuery.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceContextQuery
     */
    @WebEndpoint(name = "WebServiceContextQueryPort")
    public WebServiceContextQuery getWebServiceContextQueryPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservicecontext.web.jaxws.sample.wasdev/",
                "WebServiceContextQueryPort"), WebServiceContextQuery.class, features);
    }

}
