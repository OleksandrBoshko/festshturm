<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav class="navbar navbar-inverse">
 	<div class="container-fluid">
   		<div class="navbar-header">
   			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
     			<span class="icon-bar"></span>
     			<span class="icon-bar"></span>
     			<span class="icon-bar"></span>                        
   			</button>
   			<a class="navbar-brand" href="/show/home/">Штурм</a>
   		</div>
   		<div class="collapse navbar-collapse" id="myNavbar">
     		<ul class="nav navbar-nav"> 
				<li class="dropdown">
       				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Програма<span class="caret"></span></a>
         			<ul class="dropdown-menu">
          				<li><a href="/show/main-scene/">Головна сцена</a></li>
						<li><a href="/show/second-scene/">Мала сцена</a></li>
						<li><a href="/show/literary-scene/">Літературна сцена</a></li>
						<li><a href="/show/fair/">Ярмарок</a></li>
            			<li><a href="/show/food-territory/">Територія їжі</a></li>
						<li><a href="/show/cossack-area/">Козацька галявина</a></li>
						<li><a href="/show/children-playground/">Дитячий майданчик</a></li>
						<li><a href="/show/night-film-show/">Нічний кінопоказ</a></li>
						<li><a href="/show/ecoclub/">Екоклуб</a></li>
         			</ul>
       			</li>
       			<li>
					<a href="/iterable/participants/">
						<span>Учасники</span>
					</a>
				</li>
				<li class="dropdown">
       				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Відвідувачам<span class="caret"></span></a>
         					<ul class="dropdown-menu">
           					<li><a href="/show/tickets/">Квитки</a></li>
							<li><a href="/show/how-to-get-to/">Як дістатись</a></li>
							<li><a href="/show/rules/">Правила</a></li>
							<li><a href="/show/residency/">Проживання</a></li>
							<li><a href="/show/faq/">Часті питання</a></li>
         					</ul>
       			</li>
				<li>
					<a href="/show/gallery/">
						<span>Галерея</span>
					</a>
				</li>
				<li>
					<a href="/iterable/news/">
						<span>Новини</span>
					</a>
				</li>
				<li>
					<a href="/show/partners/">
						<span>Партнери</span>
					</a>
				</li>
				<li>
					<a href="/show/contacts/">
						<span>Контакти</span>
					</a>
				</li>
     		</ul>
     		<ul class="nav navbar-nav navbar-right">
       			<li><a href="https://plus.google.com/u/0/116251473756722894097/posts"><i class="fa fa-google-plus fa-lg"></i></a></li>
       			<li><a href="https://vk.com/shturmfest"><i class="fa fa-vk fa-lg"></i></a></li>
       			<li><a href="https://www.youtube.com/channel/UCbZtM8jEk3YhyiMoFV-kwBg"><i class="fa fa-youtube fa-lg"></i></a></li>
       			<li><a href="https://www.facebook.com/shturmfest"><i class="fa fa-facebook fa-lg"></i></a></li>
     		</ul>
   		</div>
 	</div>	
</nav>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

