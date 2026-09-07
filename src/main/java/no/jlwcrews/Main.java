package no.jlwcrews;

import jakarta.servlet.Filter;
import no.jlwcrews.anagram.AnagramServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;

public class Main {
    public static void main(String[] args) {

        Tomcat server = new Tomcat();
        server.setPort(8080);

        Context ctx = server.addContext("", null);
        Tomcat.addServlet(ctx, "anagram", new AnagramServlet());
        ctx.addServletMapping("/api/v1/anagram/*", "anagram");


        try {
            server.start();
            System.out.println(server.getConnector().getPort());
            System.out.println("server all started and such");
        } catch (LifecycleException e) {
            System.out.println("oh shit, got error");
            throw new RuntimeException(e);
        }

        server.getServer().await();
    }
}