package com.asyncservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/op", asyncSupported = true)
public class OrderProcessingServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("async Supported: " +req.isAsyncSupported());
		AsyncContext asyncContext = req.startAsync();
		asyncContext.start(() -> {
			// process the order
			try {
				Thread.sleep(1000L);
				ServletResponse response = asyncContext.getResponse();
				PrintWriter out = response.getWriter();
				out.print("Your order has been created with order no: 1");
				out.close();
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		});
	}

}
