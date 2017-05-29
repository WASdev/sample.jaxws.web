
package wasdev.sample.jaxws.web.handler.client;

import java.io.IOException;

import javax.jws.HandlerChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import wasdev.sample.jaxws.web.BaseClientServlet;

@WebServlet("/HandlerClientServlet")
@HandlerChain(file = "handler-client.xml")
public class HandlerClientServlet extends BaseClientServlet {

    private static final long serialVersionUID = -5916044635761262727L;

    @WebServiceRef(value = RouteTrackerService.class)
    private RouteTracker routeTracker;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String echoParameter = request.getParameter("echoParameter");
        request.setAttribute("echoParameter", echoParameter);
        if (echoParameter != null) {
            setEndpointAddress((BindingProvider) routeTracker, request, "RouteTrackerService");
            String echoResponse = routeTracker.track(echoParameter);
            request.setAttribute("echoResponse", echoResponse);
        }
        request.getRequestDispatcher("handler_sample.jsp").forward(request, response);
    }
}
