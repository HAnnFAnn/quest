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

@WebServlet(name = "logicServlet", value = "/quest")
public class LogicServlet extends HttpServlet implements QuestConstants {
    QuestionService questionService = new QuestionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession currentSession = req.getSession();


        Long questionId = !req.getParameter("questionId").isBlank() && req.getParameter("questionId") != null
                ? Long.parseLong(req.getParameter("questionId"))
                : !currentSession.getAttribute("questionId").toString().isBlank()
                ? (Long) currentSession.getAttribute("questionId")
                : QuestConstants.FIRST_QUESTION_ID;


        Long answerId = Long.valueOf(req.getParameter("answerId"));
        if (answerId.equals(QuestConstants.FINAL_ANSWER_ID)) {
            Object count = currentSession.getAttribute("countGames");
            if (count == null) {
                count = 0;
            } else {
                count = (int) count + 1;
            }
            currentSession.setAttribute("countGames", count);
        }

        req.setAttribute("question", questionService.getQuestionById(questionId));
        getServletContext().getRequestDispatcher("/step-quest.jsp").forward(req, resp);
    }

}
