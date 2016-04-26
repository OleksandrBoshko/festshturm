<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="jumbotron text-center">
		<div class="row">
				<div class="col-sm-4">
	          		<div><img src="<c:url value="/resources/images/logo.jpg"/>" height="210" width="auto" alt="Logo"></div>  
	    		</div>
	    		<div class="col-sm-4">
					<div class="skole">
						<h4>29-31 Липня м.Сколе, Львівська обл.</h4>
					</div>
	        		<div class="rightmusic">
						<h3>фестиваль правильної музики</h3>
					</div>
				</div>	
	    		<div class="col-sm-4">
	    			<h4 class="start">до штурму залишилось:</h4>
	    			<div id="DateCountdown" data-date="2016-07-29 00:00:00"></div>
	    		
	    			<!-- 
	    			<ul class="countdown">
	    				<h4 class="start">до ШТУРМУ залишилось:</h4>
						<li> <span class="days">00</span>
							<p class="days_ref">days</p>
						</li>
						<li class="seperator">.</li>
						<li> <span class="hours">00</span>
							<p class="hours_ref">hours</p>
						</li>
						<li class="seperator">:</li>
						<li> <span class="minutes">00</span>
							<p class="minutes_ref">minutes</p>
						</li>
						<li class="seperator">:</li>
						<li> <span class="seconds">00</span>
							<p class="seconds_ref">seconds</p>
						</li>
					</ul>
	    			 -->
	    		
	    	</div>	
	    </div>
	</div>



