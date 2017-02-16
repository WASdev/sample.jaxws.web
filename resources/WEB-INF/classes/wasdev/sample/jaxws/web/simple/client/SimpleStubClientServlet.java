
package wasdev.sample.jaxws.web.simple.client;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import wasdev.sample.jaxws.web.BaseClientServlet;

@WebServlet("/SimpleStubClientServlet")
public class SimpleStubClientServlet extends BaseClientServlet {

    private static final long serialVersionUID = 241012649903007002L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String echoParameter = request.getParameter("echoParameter");
        if (echoParameter != null) {
            SimpleEchoService service = new SimpleEchoService(new URL(getRequestBaseURL(request)
                    + "/SimpleEchoService?wsdl"), new QName("http://simple.web.jaxws.sample.wasdev/",
                    "SimpleEchoService"));
            SimpleEcho simpleEcho = service.getSimpleEchoPort();

            setEndpointAddress((BindingProvider) simpleEcho, request, "SimpleEchoService");

            String echoResponse = simpleEcho.echo(echoParameter);
            request.setAttribute("echoParameter", echoParameter);
            request.setAttribute("echoResponse", echoResponse);
        }
        request.getRequestDispatcher("simple_webservice_sample.jsp").forward(request, response);
    }
}