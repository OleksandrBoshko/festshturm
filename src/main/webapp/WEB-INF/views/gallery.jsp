<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="col-sm-8 text-left">
	<c:url value="/upload" var="upload" />
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<h2>Адміністрування</h2>

		<form method="POST"
			action="/upload?${_csrf.parameterName}=${_csrf.token}"
			enctype="multipart/form-data">

			<input type="file" name="image" value="Upload!" /> <input
				type="submit" value="Зберегти!" />
		</form>
		<hr>
	</security:authorize>

	<div>

		<table>
			<c:forEach var="image" items="${images}">
				<tr>
					<td>
						<img src="/static/${image}" style="width:100px; hight:auto" />
						<hr style="width: 90%"> <span>/static/${image}</span>
					</td>
				</tr>
				<!-- 
								<security:authorize access="hasRole('ROLE_ADMIN')">
					<tr>
						<c:url value="/iterable/delete-iterable-post/${slug}/${post.id}"
							var="url" />
						<td><a href="${url}">Видалити</a></td>
					</tr>
				</security:authorize>
				 -->

			</c:forEach>
		</table>
	</div>

</div>

