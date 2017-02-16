/*
 * IBM Confidential
 *
 * OCO Source Materials
 *
 * Copyright IBM Corp. 2012
 *
 * The source code for this program is not published or otherwise divested 
 * of its trade secrets, irrespective of what has been deposited with the 
 * U.S. Copyright Office.
 */

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
