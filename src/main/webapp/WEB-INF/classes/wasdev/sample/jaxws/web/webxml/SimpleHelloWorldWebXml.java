
package wasdev.sample.jaxws.web.webxml;

import javax.jws.WebService;

@WebService
public class SimpleHelloWorldWebXml {

    public String hello(String name) {
        return "Hello, " + name;
    }
}
