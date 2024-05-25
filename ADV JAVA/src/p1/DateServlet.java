package p1;

import jakarta.servlet.*;
import java.util.*;
import java.io.*;

public class DateServlet extends GenericServlet{

    public void service (ServletRequest req, ServletResponse res) throws ServletException,IOException {

        PrintWriter pw = res.getWriter();
        Date d = new Date();

    }
}