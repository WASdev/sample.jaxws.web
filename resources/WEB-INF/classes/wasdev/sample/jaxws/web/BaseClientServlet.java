
package wasdev.sample.jaxws.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.BindingProvider;

public class BaseClientServlet extends HttpServlet {

    protected String getRequestBaseURL(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    protected void setEndpointAddress(BindingProvider bindingProvider, HttpServletRequest request, String endpointPath) {
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                getRequestBaseURL(request) + "/" + endpointPath);
    }
}
