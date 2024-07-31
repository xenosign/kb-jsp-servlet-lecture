package org.example.kbjspservletlecture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/jstl")
public class JstlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        request.setAttribute("list", list);
        request.setAttribute("condition", true);

        boolean isJSTL = "true".equals(request.getParameter("jstl")) ? true : false;

        if(isJSTL) {
            // jstl 사용
            request.getRequestDispatcher("jstl.jsp").forward(request, response);
        } else {
            // 일반 스크립틀렛으로 구현
            request.getRequestDispatcher("scriptlet.jsp").forward(request, response);
        }
    }
}
