package no.jlwcrews.anagram;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

public class AnagramServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>please send a POST request with a list of words</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var words = Arrays.asList(req.getReader().readLine().split(", "));
        var result = new AnagramFinder().findAnagrams(words).values();
        resp.setContentType("text/plain");
        resp.getWriter().println(result);
    }
}
