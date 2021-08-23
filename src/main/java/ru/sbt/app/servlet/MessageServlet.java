package ru.sbt.app.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sbt.app.MessageStore;
import ru.sbt.app.entity.Message;
import ru.sbt.app.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameterMap().keySet());
        User user = (User) req.getSession().getAttribute("user");
        String messageText = req.getParameter("message");
        System.out.println(messageText);
        Message message = new Message(messageText, user);
        MessageStore.addMessage(message);
        System.out.println(MessageStore.getMessages());
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/view/chat.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(MessageStore.getMessages());
        ObjectMapper objectMapper = new ObjectMapper();
        String strMessage = objectMapper.writeValueAsString(MessageStore.getMessages());
        resp.getWriter().print(strMessage);
    }
}
