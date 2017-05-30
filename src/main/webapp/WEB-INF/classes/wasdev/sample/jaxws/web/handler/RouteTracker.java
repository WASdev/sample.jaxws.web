
package wasdev.sample.jaxws.web.handler;

import javax.jws.HandlerChain;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 */
@WebService(name = "RouteTracker", serviceName = "RouteTrackerService", portName = "RouteTrackerPort", targetNamespace = "http://web.jaxws.sample.wasdev/")
@HandlerChain(file = "handler-test.xml")
public class RouteTracker {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String track(@WebParam(name = "message") String message) {

        System.out.println(getClass().getName());
        return "response [" + message + "] Please check the outputs on the console";
    }
}
