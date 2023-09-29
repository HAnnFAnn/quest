package ru.javarush.filippova.quest.controller;

import ru.javarush.filippova.quest.QuestConstants;
import ru.javarush.filippova.quest.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "initServlet", value = "/start")
public class InitServlet extends HttpServlet implements QuestConstants {
    QuestionService questionService = new QuestionService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);

        String username = req.getParameter("username");

        currentSession.setAttribute("username", username);
        currentSession.setAttribute("countGames", 0);

        req.setAttribute("question", questionService.getQuestionById(QuestConstants.FIRST_QUESTION_ID));
        getServletContext().getRequestDispatcher("/step-quest.jsp").forward(req, resp);

    }
}
