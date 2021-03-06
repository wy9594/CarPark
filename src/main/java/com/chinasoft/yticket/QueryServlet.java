package com.chinasoft.yticket;

import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;
import com.chinasoft.service.TicketService;
import com.chinasoft.service.UserService;
import com.chinasoft.service.impl.TicketServiceImpl;
import com.chinasoft.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
//查询月票
@WebServlet("/tquery")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
       TicketService Service = new TicketServiceImpl();
        List<Ticket> tickets = Service.findticketAll();
        request.setAttribute("ticket",tickets);

        request.getRequestDispatcher("/mTicket.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
