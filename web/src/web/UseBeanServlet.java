package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UseBeanServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//インスタンス化
		EmpBean bean = new EmpBean();
		//EmpBeanのsetName
		bean.setName("KnowledgeTaro");
		//EmpBeanのsetAge
		bean.setAge(20);
		//リクエストオブジェクトに対して特定の名前を目印に値を格納
		request.setAttribute("emp", bean);
		//遷移先決定
		RequestDispatcher rd = request.getRequestDispatcher("/useBean.jsp");
		//rdにrequestとresponse渡す
		rd.forward(request, response);
	}
}
