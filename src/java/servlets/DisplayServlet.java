/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Applicant;
import repository.ApplicantDaoImpl;

/**
 *
 * @author moses
 */
@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

    public ApplicantDaoImpl applicantDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("showAllApplication") != null) {
            List<Applicant> allApplicant = new ArrayList<Applicant>();
            System.out.println(allApplicant.size());
            allApplicant = applicantDao.findAllApplicants();
            req.setAttribute("applicantList", allApplicant);
            RequestDispatcher rd = req.getRequestDispatcher("all-applicant.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
