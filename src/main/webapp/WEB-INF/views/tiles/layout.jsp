<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-2.2.2.js" integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/TimeCircles.css"/>"/>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	
  	
  	
	
<title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>

<body>
	<div class="container-fluid">
	<div>
		<tiles:insertAttribute name="jumbotron"></tiles:insertAttribute>
	</div>
	<div>
		<tiles:insertAttribute name="menu"></tiles:insertAttribute>
	</div>
	<div class="container-fluid text-center">    
		<div class="row content">
			<div>
				<tiles:insertAttribute name="left-side"></tiles:insertAttribute>
			</div>
			<div>
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>
			<div>
				<tiles:insertAttribute name="right-side"></tiles:insertAttribute>
			</div>
		</div>
	</div>
	<div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>	
	</div>

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/TimeCircles.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/countdown.js" />"></script>

</body>
</html>