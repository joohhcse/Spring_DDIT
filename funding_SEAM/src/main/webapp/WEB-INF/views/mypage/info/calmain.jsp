<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
	
<!-- Tell the browser to be responsive to screen width -->
 <meta name="viewport" content="width=device-width, initial-scale=1">
<%-- <!-- Font Awesome -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css"> --%>
<%-- <!-- Theme style -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css"> --%>
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- fullCalendar -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar/main.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-daygrid/main.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-timegrid/main.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-bootstrap/main.min.css">
<!-- Google Font: Source Sans Pro -->
<!-- <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">  -->
	
	
	
	
<%-- <!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script> --%>
<!-- Bootstrap -->                                   
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jQuery UI -->                                   
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery-ui/jquery-ui.min.js"></script>
<%-- <!-- AdminLTE App -->                                
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script> --%>
<!-- AdminLTE for demo purposes -->                  
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/demo.js"></script>
<!-- fullCalendar 2.2.5 -->                          
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar/main.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-daygrid/main.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-timegrid/main.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-interaction/main.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-bootstrap/main.min.js"></script>

<title>calendar - FUN&#36;&#123;SEAM&#125;DING</title>

</head>

<body>
	<input type="hidden" name="mem_email" value="${member.mem_email}">
	<input type="hidden" name="mem_num" value="${member.mem_num}">
	
	<div id="calendar"></div>
</body>

<script>
var calendarResult;
window.addEventListener('load', function(){
// 	calendar().render();
	//	   searchTypeDatepickerAble('select[name=searchType]');
	console.log('addeventListener');
 	calendar(getCalendarJsonData()).render();
	
});

var getCalendarJsonData = function() {
	var result;
	$.ajax({
		url: '${pageContext.request.contextPath}/mypage/info/loadDailyChk',
		type: 'post',
		data: {
			"mem_num" : ${member.mem_num}
		},
		eventLimit: true,
		async: false,
		success: function(data) {
			console.log('getCalendarJsonData');
			console.log(data);
			result = data; 
		},
		error: function(xhr) {
			alert('Error');
		}
	})
	return result;	
}

var calendar = function(data){
	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();
	
	var calendarData;
	
	console.log('calendar function loadDailyChk');
	
	// ajax 통해서 전체 리스트형식으로 가져오기
// 	$.ajax({
// 		url : '${pageContext.request.contextPath}/mypage/info/loadDailyChk?mem_num=${mem_num}',
// 		type : 'post',
// 		data : {
// 		},
// 		async : false,
// 		success : function(data){
// 			calendarData = data;
			
// 			console.log(data);
			
// 		}
// 	})

	var calendarEl = document.getElementById('calendar');
	calendarResult = new FullCalendar.Calendar(calendarEl, {
	   plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid' ],
	   header: {
	      left: "prev,next dailyChk",
	      center: "title",
	      right: ""
	   },
	   events: data,
	   customButtons: {
		   dailyChk: {
			   text: '출석체크',
			   id: 'check',
			   click: function() {
				   $.ajax({
					 url: '${pageContext.request.contextPath}/mypage/info/dailychk?mem_email=${member.mem_email}',
					 type: 'get',
					 data: {
						
					 },
					 success: function(data) {
						result = data;
						console.log(data);
						
						var startDate = new Date(data.start);
						var endDate = new Date(data.end);
						
						calendarResult.addEvent({
							title: data.title,
							start: startDate,
							end: endDate
						})
						
					 },
					 error: function(xhr) {
						 alert("에러!");
					 },
				   })
			   }
		   }
	   },
	});
	
	return calendarResult;
}
</script>


<!-- </html> -->