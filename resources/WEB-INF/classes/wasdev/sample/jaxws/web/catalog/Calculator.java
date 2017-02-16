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

@WebService(name = "CalculatorPortType", targetNamespace = "http://catalog.web.jaxws.sample.wasdev")
public interface Calculator {

    public int add(int value1, int value2);

}
