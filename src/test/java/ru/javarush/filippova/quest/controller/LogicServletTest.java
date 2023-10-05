package ru.javarush.filippova.quest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class LogicServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private ServletContext servletContext;

    private final static String questJSP = "/step-quest.jsp";

    @Test
    public void testDoGet() throws ServletException, IOException {

        LogicServlet servlet = new LogicServlet();
        servlet.init(servletConfig);
        when(request.getParameter("questionId")).thenReturn(String.valueOf(1L));
        when(request.getParameter("answerId")).thenReturn(String.valueOf(1L));
        when(request.getSession()).thenReturn(session);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher(questJSP)).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(servletContext).getRequestDispatcher("/step-quest.jsp");
    }

}