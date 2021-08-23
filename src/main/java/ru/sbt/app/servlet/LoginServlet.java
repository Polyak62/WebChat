package ru.sbt.app.servlet;

import ru.sbt.app.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private List<User> users;
    private final static String login = "/WEB-INF/view/login.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final HttpSession session = req.getSession();
        session.removeAttribute("login");
        req.setAttribute("users", users);
        req.getRequestDispatcher(login).forward(req, resp);
        resp.sendRedirect(super.getServletContext().getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =  req.getParameter("name");
        User user = new User(name);
        req.getSession().setAttribute("user", user);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/view/chat.jsp");
        requestDispatcher.forward(req, resp);
    }
}
