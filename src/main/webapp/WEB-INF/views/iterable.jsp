<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="col-sm-8 text-left">
	<h2 class="subject">${subject}</h2>
	<spring:url value="/{slug}" var="slug">
		<spring:param name="slug" value="${slug}" />
	</spring:url>
	<security:authorize access="hasRole('ROLE_ADMIN')">
	<h2>Адміністрування</h2>
		<form method="post" action="/iterable/save-iterable-post/${slug}">
  			<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"> </input>
			<textarea id="myTextarea" name="text"></textarea>
			<input type="submit" value="Зберегти!" />
		</form>
  		<hr>
  	</security:authorize>
	<div>
		
		<table>
			<c:forEach var="post" items="${posts}">
				<tr>
					<td>
						<p></p>
						<hr style="width: 90%">
						<span>${post.text}</span>
					</td>
				</tr>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<tr>
						<c:url value="/iterable/delete-iterable-post/${slug}/${post.id}" var="url" />
						<td><a href="${url}">Видалити</a></td>
					</tr>
				</security:authorize>
			</c:forEach>
		</table>
	</div>
</div>
      				
<script type="text/javascript" src="<c:url value="/resources/js/tinymce/tinymce.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/tinymce/tinymce_properties.js"/>"></script>  