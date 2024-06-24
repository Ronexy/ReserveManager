package servlet;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callender")
public class Callender extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Callender() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String yearStr = request.getParameter("year");
        String monthStr = request.getParameter("month");
        
        LocalDate currentDate;
        if (yearStr != null && monthStr != null) {
            int year = Integer.parseInt(yearStr);
            int month = Integer.parseInt(monthStr);
            currentDate = LocalDate.of(year, month, 1);
        } else {
            currentDate = LocalDate.now();
        }

        request.setAttribute("currentDate", currentDate);
        
        String forwardPath = "WEB-INF/jsp/Callender.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String selectedDate = request.getParameter("selectedDate");

         // Print the selected date to the console
         System.out.println("Selected Date: " + selectedDate);

         // Forward to the same page with the current date
         doGet(request, response);
    }
}
