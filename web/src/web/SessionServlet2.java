package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Session Servlet 2</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 2</h1>");
		/*その時点でセッションが開始していない（セッションオブジェクトがない）場合は、nullを返す
		すでにセッションが開始済みの場合は、既存のセッションオブジェクトを返す*/
		HttpSession session = request.getSession(false);
		if (session == null) {
			//セッションが継続していないのでエラー処理を行う
			out.println("<p>セッションが開始されていません</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		out.println("<p>セッションが継続しています</p>");
		out.println("<p>" + session.getAttribute("loginUser") + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
