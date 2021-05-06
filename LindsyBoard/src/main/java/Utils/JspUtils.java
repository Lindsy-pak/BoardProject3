package Utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspUtils {
	public static void moveToJsp(HttpServletRequest request, HttpServletResponse response, String jsp) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/" + jsp + ".jsp").forward(request, response);
	}
}
