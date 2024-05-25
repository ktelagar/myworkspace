package com.kr.servlet;

import jakarta.servlet.*;
import java.util.*;
import java.io.*;

public class DateServlet extends GenericServlet{

    public void service (ServletRequest req, ServletResponse res) throws ServletException,IOException {

        PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
        Date d = new Date();
		String sysDate = d.toString();
		pw.println("<h1 style='color:red; text-align:center'>"+sysDate+"</h1>");
		pw.println("<br><b> our servlet class obj hash code ::"+this.hashCode()+"</br>");
		pw.println("<br><b> req obj hash code ::"+req.hashCode()+"</br>");
		pw.println("<br><b> res obj hash code ::"+res.hashCode()+"</br>");
		pw.println("<br><b> ocurrent Thread  hash code ::"+Thread.currentThread().hashCode()+"</br>");
		pw.close();
		
		System.out.println("checking println statement");

    }
}