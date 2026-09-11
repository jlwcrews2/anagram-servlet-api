package no.jlwcrews.anagram;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.Arrays;

public class AnagramServlet extends HttpServlet {

    private final JsonMapper mapper = JsonMapper.builder().build();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>please send a POST request with a list of words</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var wordList = mapper.readValue(req.getInputStream(), WordList.class);
        var result = new AnagramFinder().findAnagrams(wordList.words()).values();
        resp.setContentType("application/json");
        resp.getWriter().println(mapper.writeValueAsString(result));
    }
}
