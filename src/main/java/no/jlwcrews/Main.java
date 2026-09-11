package no.jlwcrews;

import no.jlwcrews.anagram.AnagramServlet;
import no.jlwcrews.brackets.BracketsServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;

public class Main {
    public static void main(String[] args) {

        Tomcat server = new Tomcat();
        server.setPort(8080);
        server.getConnector();

        Context ctx = server.addContext("", null);
        Tomcat.addServlet(ctx, "anagram", new AnagramServlet());
        Tomcat.addServlet(ctx, "brackets", new BracketsServlet());
        ctx.addServletMapping("/anagram", "anagram");
        ctx.addServletMapping("/brackets", "brackets");

        FilterDef filterDef = new FilterDef();
        filterDef.setFilterName("logFilter");
        filterDef.setFilter(new LogFilter());
        ctx.addFilterDef(filterDef);

        FilterMap filterMap = new FilterMap();
        filterMap.setFilterName("logFilter");
        filterMap.addURLPattern("/*");
        ctx.addFilterMap(filterMap);

        try {
            server.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }

        server.getServer().await();
    }
}