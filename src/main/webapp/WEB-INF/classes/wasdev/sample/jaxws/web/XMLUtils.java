
package wasdev.sample.jaxws.web;

public class XMLUtils {

    public static String escapeXML(String xml) {
        if (xml == null) {
            return null;
        }
        xml = xml.replace("&", "&amp;");
        xml = xml.replace("<", "&lt;");
        xml = xml.replace(">", "&gt;");
        xml = xml.replace(" ", "&nbsp;");
        xml = xml.replace("\t", "&nbsp; &nbsp; ");
        return xml;
    }
}
