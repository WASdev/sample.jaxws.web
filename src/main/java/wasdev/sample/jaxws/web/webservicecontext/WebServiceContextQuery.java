
package wasdev.sample.jaxws.web.webservicecontext;

import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService
public class WebServiceContextQuery {

    @Resource
    private WebServiceContext context;

    public String query() {
        StringBuilder responseBuilder = new StringBuilder();
        for (Map.Entry entry : context.getMessageContext().entrySet()) {
            responseBuilder.append(entry.getKey() + " : " + entry.getValue() + "<br/>");
        }
        return responseBuilder.toString();
    }

}
