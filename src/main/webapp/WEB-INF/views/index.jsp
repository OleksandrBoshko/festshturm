<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="col-sm-8 text-left">
<c:if test="${showSlider}">
	<div id="carousel" class="carousel slide" data-ride="carousel" style="margin-top: 10px;">
		<div class="carousel-inner">
			<c:forEach var="image" items="${images}" varStatus="status">
				<div class="item ${status.first ? 'active' : ''}">
					<img src="/static/${image}" style="height: 351px; margin: auto;" />
				</div>
			</c:forEach>
		</div>
		<a href="#carousel" class="left carousel-control" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a> <a href="#carousel" class="right carousel-control" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
</c:if>	
	<spring:url value="/{slug}" var="slug">
		<spring:param name="slug" value="${slug}" />
	</spring:url>
	<security:authorize access="hasRole('ROLE_ADMIN')">
	<h2>Адміністрування</h2>
		<form method="post" action="/show/save-post/${slug}">
  			<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}"/>
  			<input type="hidden" value="${post.id}" name="id"/>
			<textarea id="myTextarea" name="text">${post.text}</textarea>
			<input type="submit" value="Зберегти!" />
		</form>
  		<hr>
  	</security:authorize>
	<div>
		<h2 class="subject">${post.subject}</h2>
		<span>${post.text}</span>
		<p></p>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<c:url value="/show/deletePost/${slug}/${post.id}" var="url" />
			<a href="${url}">Видалити</a>
		</security:authorize>
	</div>
</div>
      				
<script type="text/javascript" src="<c:url value="/resources/js/tinymce/tinymce.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/tinymce/tinymce_properties.js"/>"></script>  
