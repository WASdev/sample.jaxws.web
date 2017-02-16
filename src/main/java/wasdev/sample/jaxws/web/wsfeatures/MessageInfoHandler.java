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

package wasdev.sample.jaxws.web.wsfeatures;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 */
public class MessageInfoHandler implements Handler<SOAPMessageContext> {

    /*
     * (non-Javadoc)
     * 
     * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
     */
    public void close(MessageContext context) {
        System.out.println(this.getClass().getName() + " is closed");
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
     */
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println(this.getClass().getName() + " handling fault");
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
     */
    public boolean handleMessage(SOAPMessageContext context) {
        boolean isOut = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (isOut) {
            return true;
        }

        StringBuilder requestMessageBuilder = new StringBuilder();
        Map<String, List<String>> requestHeaders = (Map<String, java.util.List<String>>) context
                .get(MessageContext.HTTP_REQUEST_HEADERS);
        for (Map.Entry<String, List<String>> entry : requestHeaders.entrySet()) {
            requestMessageBuilder.append(entry.getKey() + " : " + entry.getValue() + "\n");
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            context.getMessage().writeTo(bos);
            requestMessageBuilder.append(bos.toString());
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        context.put("request.message", requestMessageBuilder.toString());
        context.setScope("request.message", MessageContext.Scope.APPLICATION);        
        return true;
    }
}
