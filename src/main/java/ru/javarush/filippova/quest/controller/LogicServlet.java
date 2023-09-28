package ru.javarush.filippova.quest.controller;

import ru.javarush.filippova.quest.domain.entity.Question;
import ru.javarush.filippova.quest.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "logicServlet", value = "/quest")
public class LogicServlet extends HttpServlet {
    QuestionService questionService = new QuestionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long questionId = Long.valueOf(req.getParameter("questionId"));
        Question question = questionService.getQuestionById(questionId);
        req.setAttribute("question", question);
        getServletContext().getRequestDispatcher("/step-quest.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        currentSession.setAttribute("user", "aaa");
        super.doPost(req, resp);
    }
}
