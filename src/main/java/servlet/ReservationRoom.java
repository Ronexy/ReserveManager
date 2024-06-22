package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.RoomBean;
import model.RoomDAO;

@WebServlet("/reservationroom")
public class ReservationRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservationRoom() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "WEB-INF/jsp/ReservationRoom.jsp";
		RoomDAO roomDAO = new RoomDAO();
		List<RoomBean> roomList = roomDAO.getAllRooms();
		request.setAttribute("roomList", roomList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
