
package wasdev.sample.jaxws.web.simple;

import javax.jws.WebService;

@WebService
public class SimpleEcho {

    public String echo(String value) {
        return "Echo Response [" + value + "]";
    }
}
