<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

  <div class="col-sm-8 text-left">
	<h2>Вхід</h2>
	<c:url value="/login" var="login"/>
	<form method="Post">
		<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"> </input>
		<table>
			<tr>
				<th>Нікнейм:  </th>
				<td>
					<input name="username" />
				</td>
			</tr>

			<tr>
				<th>Пароль:  </th>
				<td><input name="password" type="password" /></td>
			</tr>
			
			<tr>
				<th></th>
				<td><input type="submit" value="Увійти!" /></td>
			</tr>
		</table>
	</form>
</div>