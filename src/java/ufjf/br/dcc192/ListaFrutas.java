/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.br.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author douglas
 */
@WebServlet(name = "ListaFrutas", urlPatterns = {"/listafrutas.html"})
public class ListaFrutas extends HttpServlet {

    List<String> frutas;
    Comparador comparador = new Comparador();

    public ListaFrutas() {
        frutas = new ArrayList<String>();
        frutas.add("Marça");
        frutas.add("Banana");
        frutas.add("Pera");
        frutas.add("Jabuticaba");
        frutas.add("Carambola");
        frutas.add("Goiaba");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comando = req.getParameter("comando");
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaFrutas</title > ");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaFrutas at " + req.getContextPath() + "</h1>");
            out.println("<p><a href ='?comando=alfabetica'>Ordem Alfabetica</a></p>");
            out.println("<p><a href ='?comando=numeroLetras'>Número de Letras</a></p>");
            out.println("<p><a href ='?comando=aleatoria'>Aleatoria</a></p>");
            switch (comando) {
                case "alfabetica":
                    Collections.sort(frutas);
                    break;

                case "aleatoria":
                    Collections.shuffle(frutas);
                    break;

                case "numeroLetras":
                    Collections.sort(frutas, comparador);
            }
            for (String fruta : frutas) {
                out.println("<li>" + fruta + "</li>");

            }
            out.println("</body>");
            out.println("</html>");
        }
    }

}
