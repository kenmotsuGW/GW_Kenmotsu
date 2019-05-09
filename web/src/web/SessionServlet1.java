package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {
	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*その時点でセッションが開始していない（セッションオブジェクトがない）場合は、
		新たなセッションIDを発行し、セッションオブジェクトを生成して返す
		すでにセッションが開始済みの場合は、既存のセッションオブジェクトを返す*/
		HttpSession session = request.getSession(true);
		//HttpSessionへのデータ格納
		session.setAttribute("loginUser", "KnowledgeTaro");
		response.setContentType("text/html;charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Session Servlet 1</title></head>");
		out.println("<body>");
		out.println("<h1>Session Servlet 1</h1>");
		out.println("<p>セッションを開始しました</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
