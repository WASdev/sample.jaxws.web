
package wasdev.sample.jaxws.web.catalog.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import wasdev.sample.jaxws.web.BaseClientServlet;

@WebServlet("/CatalogClientServlet")
public class CatalogClientServlet extends BaseClientServlet {

    private static final long serialVersionUID = 16643294765074943L;

    @WebServiceRef(value = Calculator.class)
    private CalculatorPortType calculatorPortType;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String parameter1 = request.getParameter("parameter1");
        String parameter2 = request.getParameter("parameter2");
        request.setAttribute("parameter1", parameter1);
        request.setAttribute("parameter2", parameter2);
        if (parameter1 != null && parameter2 != null) {
            try {
                int intValue1 = Integer.parseInt(parameter1);
                int intValue2 = Integer.parseInt(parameter2);
                setEndpointAddress((BindingProvider) calculatorPortType, request, "Calculator");
                int result = calculatorPortType.add(intValue1, intValue2);
                request.setAttribute("result", String.valueOf(result));
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", e.getMessage());
            }
        }
        request.getRequestDispatcher("catalog_sample.jsp").forward(request, response);
    }

}
