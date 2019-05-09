package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//送信されてくるパラメータのエンコーディングの指定
		req.setCharacterEncoding("UTF-8");
		//送信したパラメータの取得(文字列)
		String str = req.getParameter("param");
		String age = req.getParameter("age");
		String sei = req.getParameter("sei");
		String gengo1 = req.getParameter("gengo1");
		String gengo2 = req.getParameter("gengo2");
		String gengo3 = req.getParameter("gengo3");
		String hitokoto = req.getParameter("hitokoto");
		//エンコーディングとMIMEタイプの設定
		resp.setContentType("text/html;charset = UTF-8");
		//ServaletでHTMLを書くための準備
		PrintWriter out = resp.getWriter();
		//変数名の形式でHTMLが書ける
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>" + "申し込み入力画面");
		out.println("<h2>" + "お名前" + "</h2>");
		out.println("<h3>" + str + "</h3>");

		out.println("<h2>" + "年齢" + "</h2>");
		out.println("<h3>" + age + "</h3>");

		out.println("<h2>" + "性別" + "</h2>");
		out.println("<h3>" + sei + "</h3>");

		out.println("<h2>" + "興味のある言語" + "</h2>");
		if (req.getParameter("gengo1") == null) {

		} else
			out.print("<h3>" + gengo1 + "</h3>");
		if (req.getParameter("gengo2") == null) {

		} else
			out.print("<h3>" + gengo2 + "</h3>");
		if (req.getParameter("gengo3") == null) {

		} else
			out.print("<h3>" + gengo3 + "</h3>");

		if (req.getParameter("gengo1") == null) {
			if (req.getParameter("gengo2") == null) {
				if (req.getParameter("gengo3") == null) {
					out.print("<h3>" + "特になし" + "</h3>");
				}
			}
		}

		out.println("<h2>" + "なにか一言" + "</h2>");
		out.println("<h3>" + hitokoto + "</h3>");

		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		//HTMLが終わったらcloseする
		out.close();
	}
}
