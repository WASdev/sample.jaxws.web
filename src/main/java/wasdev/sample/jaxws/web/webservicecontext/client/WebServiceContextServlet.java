
package wasdev.sample.jaxws.web.webservicecontext.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import wasdev.sample.jaxws.web.BaseClientServlet;

@WebServlet("/WebServiceContextServlet")
public class WebServiceContextServlet extends BaseClientServlet {

    @WebServiceRef(value = WebServiceContextQueryService.class)
    private WebServiceContextQuery contextQuery;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String echoParameter = request.getParameter("submit");
        if (echoParameter != null) {
            setEndpointAddress((BindingProvider) contextQuery, request, "WebServiceContextQueryService");
            String responseMessage = contextQuery.query();
            request.setAttribute("output", responseMessage);
        }
        request.getRequestDispatcher("webservicecontext_sample.jsp").forward(request, response);
    }

}
