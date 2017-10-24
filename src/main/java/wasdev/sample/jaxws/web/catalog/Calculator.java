
package wasdev.sample.jaxws.web.catalog;

import javax.jws.WebService;

@WebService(name = "CalculatorPortType", targetNamespace = "http://catalog.web.jaxws.sample.wasdev")
public interface Calculator {

    public int add(int value1, int value2);

}
