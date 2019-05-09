package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");
		//送信したパラメータの取得(文字列)
		String str = req.getParameter("param");
		//エンコーディングとMIMEタイプの設定
		resp.setContentType("text/html;charset = UTF-8");
		//ServaletでHTMLを書くための準備
		PrintWriter out = resp.getWriter();
		//変数名の形式でHTMLが書ける
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>" + str + "</h1>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		//HTMLが終わったらcloseする
		out.close();
	}
}
