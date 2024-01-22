package com.servlet.Hibernate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeService extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eId = Integer.parseInt(req.getParameter("eId"));
		String eName = req.getParameter("eName");
		String eEmail = req.getParameter("eEmail");

		Employee e1 = new Employee();
		e1.seteId(eId);
		e1.seteName(eName);
		e1.seteEmail(eEmail);

		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class);

		SessionFactory sf = config.buildSessionFactory();

		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();

		session.save(e1);

		String message = eName+" Your Data added Succesfully...!";
		req.setAttribute("m1", message);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("outPut.jsp");
		requestDispatcher.forward(req, resp);

		trans.commit();
		session.close();

	}
}