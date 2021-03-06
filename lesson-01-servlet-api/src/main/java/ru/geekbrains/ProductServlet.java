package ru.geekbrains;

import ru.geekbrains.repository.Product;
import ru.geekbrains.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        if (req.getParameter("id") != null) {
            Product product = productRepository.findById(Long.valueOf(req.getParameter("id")));
            wr.println(product.getId() + " " + product.getName());
        } else if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            wr.println("<table>");
            wr.println("<tr>");
            wr.println("<th>Id</th>");
            wr.println("<th>Name</th>");
            wr.println("</tr>");

            for (Product product : productRepository.findAll()) {
                wr.println("<tr>");
                wr.println("<td>" + product.getId() + "</td>");
                wr.println("<td> <a href='product?id=" + product.getId() + "'>" + product.getName() + "</a></td>");
                wr.println("</tr>");
            }

            wr.println("</table>");
        }
    }
}
