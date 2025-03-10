package jp.jc21.t.yoshizawa.WEB01;



import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/sresult")
public class SResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request
			.setCharacterEncoding("UTF-8");
		String string = 
			request.getParameter("string");
		try {
			Sentiment2 result = Sentiment.getSentiment(string);
			float message = result.documents[0].confidenceScores.negative;
			float message2 = result.documents[0].confidenceScores.neutral;
			float message3 = result.documents[0].confidenceScores.positive;
			request.setAttribute("message", message);
			request.setAttribute("message2", message2);
			request.setAttribute("message3", message3);
			
			request.getRequestDispatcher("/WEB-INF/jsp/SentimentKeyresult.jsp")
				.forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
