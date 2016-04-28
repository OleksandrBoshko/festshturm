<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="col-sm-8 text-center">
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

	<c:url value="/upload" var="upload" />
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<h2>Адміністрування</h2>

		<form method="POST"
			action="/upload?${_csrf.parameterName}=${_csrf.token}"
			enctype="multipart/form-data">

			<input type="file" name="image" value="Upload!" />
			<input type="radio" name="imageType" value="photo" checked>в галерею<br>
  			<input type="radio" name="imageType" value="picture">на головну<br> 
			<input type="submit" value="Зберегти!" />
		</form>
		<hr>
	</security:authorize>

	<div>

		<table>
			<c:forEach var="image" items="${images}">
				<tr>
					<td>
						<img src="/static/${image}" style="width:100px; hight:auto" />
						<hr style="width: 90%"> 
						<!-- <span>/static/${image}</span> -->
					</td>
				</tr>
				 
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<tr>
						<c:url value="/upload/file-delete?image=${image}" var="url" />
						<td><a href="${url}">Видалити: ${image}</a></td>
					</tr>
				</security:authorize>
				 

			</c:forEach>
		</table>
	</div>

</div>

