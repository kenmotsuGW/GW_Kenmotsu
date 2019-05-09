<%@page contentType="text/html;charset=Windows-31J"%>
<%-- webPackageのEmpBeanクラスを使うための定義 --%>
<jsp:useBean id="emp" scope="request" class="web.EmpBean" />
<html>
<body>
	<h1>UseBean</h1>
	<table border=1>
		<tr>
			<td>Name</td>
			<%-- リクエストオブジェクトに格納されている
			beanの中のプロパティー名がnameの値を取得している
			 --%>
			<td><jsp:getProperty name="emp" property="name" /></td>
		</tr>
		<tr>
			<td>Age</td>
			<%-- リクエストオブジェクトに格納されている
			beanの中のプロパティー名がageの値を取得している
			 --%>
			<td><jsp:getProperty name="emp" property="age" /></td>
		</tr>
	</table>
</body>
</html>