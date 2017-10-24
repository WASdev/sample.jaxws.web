
package wasdev.sample.jaxws.web.catalog;

import javax.jws.WebService;

@WebService(serviceName = "Calculator", portName = "CalculatorPort", endpointInterface = "wasdev.sample.jaxws.web.catalog.Calculator",
            targetNamespace = "http://catalog.web.jaxws.sample.wasdev", wsdlLocation = "WEB-INF/wsdl/calculator.wsdl")
public class CalculatorService {

    /**
     * @param value1
     * @param value2
     * @return returns int
     */
    public int add(int value1, int value2) {
        return value1 + value2;
    }
}
