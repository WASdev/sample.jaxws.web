
package wasdev.sample.jaxws.web.wsfeatures.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ImageServiceImplService", targetNamespace = "http://jaxws.service/", wsdlLocation = "WEB-INF/wsdl/image.wsdl")
public class ImageServiceImplService extends Service {

    private final static URL IMAGESERVICEIMPLSERVICE_WSDL_LOCATION;

    private final static Logger logger = Logger
            .getLogger(wasdev.sample.jaxws.web.wsfeatures.client.ImageServiceImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = wasdev.sample.jaxws.web.wsfeatures.client.ImageServiceImplService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:9080/JaxWsLibertyDemo/ImageServiceImplService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:9080/JaxWsLibertyDemo/ImageServiceImplService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        IMAGESERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public ImageServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ImageServiceImplService() {
        super(IMAGESERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://jaxws.service/", "ImageServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns ImageServiceImpl
     */
    @WebEndpoint(name = "ImageServiceImplPort")
    public ImageServiceImpl getImageServiceImplPort() {
        return super.getPort(new QName("http://jaxws.service/", "ImageServiceImplPort"), ImageServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ImageServiceImpl
     */
    @WebEndpoint(name = "ImageServiceImplPort")
    public ImageServiceImpl getImageServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://jaxws.service/", "ImageServiceImplPort"), ImageServiceImpl.class,
                features);
    }

}
