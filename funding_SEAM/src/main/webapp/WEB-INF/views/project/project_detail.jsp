<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
#pictureView{
height:400px;
}
#pjtTitle{
font-size:2.5rem;
}
#map{
height:350px;
}

@media (max-width: 978px) {
    .container {
      padding:0px;
      margin:0;
    }

    body {
      padding:0;
    }
    
    #pictureView{
    	height: 250px;
    }
    
    #pjtTitle{
		font-size:2rem;
	}
	.noticeDiv{
		display:none;
	}
	#map{
		height:250px;
	}

}
</style>

	<body>
		<div class="container">
        <div class="row justify-content-md-center">
          <div class="col-md-12">
                    <div style="display:none;">
                 		<jsp:useBean id="now" class="java.util.Date" />
						<fmt:parseNumber value="${now.time }" integerOnly="true" var="startD" scope="request"/>
                        <fmt:formatDate value="${project.pjt_enddate }" pattern="yyyyMMdd" />
						<fmt:parseNumber value="${project.pjt_enddate.time }" integerOnly="true" var="endD" scope="request"/>
					</div>
              
              	<div class="container">
        			<div class="row justify-content-md-center p-5">
              			<div class="col-md-12 text-center">
        				 	<p id="pjtTitle" style=" font-weight: bold;">${project.pjt_title }</p>
              			</div>
              		<div class="col-md-12 text-center p-5">

							<!-- 이미지DIV -->
				            <div class="col-md-8" id="pictureView" style="width:100%; margin: 0 auto; display:inline-block;">
				            
				             </div>
				            <div class="col-md-4" id="content" style="float:right;">
								<fmt:formatNumber value="${project.pjtPaySum/project.pjt_cash*100 }" pattern=".0" var="a"/><br>
								
								${project.pjt_category }<br>
		              			${project.comName }<br>
		              			<fmt:parseNumber value="${((endD-startD)/(60*1000*60*24))+(1-(((endD-startD)/(60*1000*60*24))%1))%1}" 
		              			integerOnly="true" var="dday" scope="request"/>
								<h3>D-${dday }</h3>
								

								목표금액 <fmt:formatNumber value="${project.pjt_cash }" pattern="#,###" />원<br>
								<fmt:formatNumber value="${project.pjtPaySum}" pattern="#,###" />원 달성 [ ${a }% ]<br>
								
	                      <!-- 그래프 -->
						  <div class="col-sm-12">
		                    <span class="irs irs--flat js-irs-3"><span class="irs">
		                    <span class="irs-line" tabindex="0"></span>
		                    <span class="irs-min" style="visibility: visible;">0%</span>
		                    <span class="irs-max" style="visibility: visible;">100%</span>
		                    <%-- <span class="irs-single" style="left: ${a}%;">달성</span> --%>
		                    <span class="irs-from" style="visibility: hidden;">0</span>
		                    <span class="irs-to" style="visibility: hidden;">0</span>
		                    </span><span class="irs-grid"></span>
		                    <span class="irs-bar irs-bar--single" style="left: 0px; width: ${a}%;"></span><span class="irs-shadow shadow-single" style="display: none;"></span>
		                    </span>
		                    <input id="range_6" type="text" name="range_6" value="" class="irs-hidden-input" tabindex="-1" readonly="">
		                  </div><br>
		                  
		                  <div class="btn-group">
	                        <button type="button" class="btn btn-outline-success btn-flat" onclick="likePjt()">
	                        <i class="far fa-heart"></i></button>
	                        <button type="button" class="btn btn-outline-success btn-flat" onclick="goPayForm()">참여하기</button>
	                        <button type="button" class="btn btn-outline-success btn-flat" onclick="share()">공유하기</button>
	                      </div>
		                  
							<div id="share" style="display:none;">
								<button type="button" class="btn" id="faceBookBtn" onclick="getURL('facebook')"><i class="fab fa-facebook fa-2x"></i></button>
								<button type="button" class="btn" id="twitterBtn" onclick="getURL('twitter')"><i class="fab fa-twitter fa-2x"></i></button>
								<button type="button" class="btn" id="linkBtn" onclick="Copy();"><i class="fas fa-link fa-2x"></i></button>
							</div><br>
		              		</div><br>
					</div>
					
					
					<!-- 내용 부분 -->
					<div class="col-md-12">
							<hr>
							
							<ul class="nav nav-pills row justify-content-md-center m-4" id="custom-content-below-tab" role="tablist">
				              <li class="nav-item">
				                <a class="nav-link active" id="custom-content-below-home-tab" data-toggle="pill" href="#custom-content-below-home" role="tab" aria-controls="custom-content-below-home" aria-selected="true">상세보기</a>
				              </li>
				              <li class="nav-item">
				                <a class="nav-link" id="custom-content-below-profile-tab" data-toggle="pill" href="#custom-content-below-profile" role="tab" aria-controls="custom-content-below-profile" aria-selected="false">댓글</a>
				              </li>
				            </ul>
							
							
							<div class="tab-content" id="custom-content-below-tabContent">
				              <div class="tab-pane fade active show" id="custom-content-below-home" role="tabpanel" aria-labelledby="custom-content-below-home-tab">
						                  		${project.pjt_contents }<br>
				              </div>
				              <div class="tab-pane fade" id="custom-content-below-profile" role="tabpanel" aria-labelledby="custom-content-below-profile-tab">
	                 			<div class="input-group input-group-sm mb-0 col-12 registDiv">
									<textarea class="form-control" rows="3" wrap=hard placeholder="Enter ..." id="replyText"></textarea>
			                          <div class="input-group-append">
			                            <button type="button" class="btn btn-outline-success btn-flat" onclick="replyRegist()">Send</button>
			                          </div>
		                        </div>
		                        <br>
		                        <c:if test="${loginUser.code_num eq 0 }">
			                        <div class="input-group input-group-sm mb-0 col-10">
			                        	<button type="button" id="checkAll" class="btn btn-outline-success btn-flat" style="display:visible;">전체 선택</button>
										<button type="button" id="checkClearAll" class="btn btn-outline-success btn-flat" style="display:none;">전체 해제</button>
			                       	 	<button type="button" class="btn btn-outline-success btn-flat" id="blind">블라인드</button>
			                       	</div>
		                        </c:if>
		                        <hr>
								<!-- timeline time label -->
								<div class="" id="repliesDiv">

					                
								</div>
				              </div>
				            </div>
							<div class="col-12">
							<br>
								<div id="map" style="width:100%;height:350px;"></div>
							</div>
				  </div>
						<button type="button" class="btn btn-outline-success btn-flat mt-3" onclick="back()">목록보기</button>

				 </div>
	            </div>
            </div>
			</div>
		</div>

	<form style="display: hidden" method="POST" id="payform">
	  <input type="hidden" name="pjt_num" value="${project.pjt_num }"/>
	</form>	

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3b4ec82fc93c11e654e65f80c9360c07&libraries=services"></script>
<script>
var imageURL="picture/get?picture=${sumnail}";
$('div#pictureView').css({'background-image':'url('+imageURL+')',
						  'background-position':'center',
						  'background-size':'cover',
						  'background-repeat':'no-repeat'
});


/* 이미 관심추가했으면 색칠된 하트로 변경 */
	$(document).ready(function(){
		//반응형 content img 사이즈 조정
		$('#custom-tabs-four-detail img').attr('style','width:100%;');
		
		//달성율 100% 초과시 그래프 길이 제한
		if(${a} > 100){
			$('.irs-bar').css('width','100%');
		}
		
		$.ajax({
			url : "<%=request.getContextPath()%>/project/isInterest",
			type:"post",		
			data:JSON.stringify(interestdata),	
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"post"
			},
			success:function(data){
				if(data=='SUCCESS'){
					
				}
				if(data=='FAIL'){
					$('.fa-heart').attr('class','fas fa-heart');
				}
						
			}
		});
	});

	var path = location.pathname;
	var url = location.search;
	var page ='192.168.205.27'+path+url;
	
	$("meta[property='og\\:title']").attr("content", '${project.pjt_title }' );
	$("meta[property='og\\:url']").attr("content", page);                    
	$("meta[property='og\\:description']").attr("content", '페이지설명넣기' );
	$("meta[property='og\\:image']").attr("content", '이미지주소넣기' );

	/* 동적으로 페이지 타이틀 수정하기 */
	$(document).ready(function() {
	    document.title = 'FunSEAMding - ${project.pjt_title }';
	});
	
	/* 뒤로가기 버튼 */
	function back(){
		history.go(-1);
	}
	
	/* 결제하기 버튼 */
	function goPayForm(){
		if(!'${loginUser.mem_num}'){
			alert('로그인이 필요합니다.');
			location.href="/commons/loginForm";
			return;
		}
		var jobForm=$('#payform');
		jobForm.attr("action","payForm").attr("method","post");
		jobForm.submit();
	}
	
	/* 공유하기 버튼 누르면 토글로 공유 버튼들이 나왔다 사라짐 */
	function share(){
		if($('#share').css('display')=='none'){
		$("#share").show();
		}else{
		$("#share").hide();
		}
	}
	
	/* 페이스북, 트위터 공유 */
	function getURL(from){
		if(from=='facebook'){
		window.open('http://www.facebook.com/sharer/sharer.php?u='+encodeURIComponent(page),'','width=300,height=400');
		}
		if(from=='twitter'){
		window.open('http://twitter.com/share?url='+encodeURIComponent(page)+'&text=${project.pjt_title }','','width=300,height=400');
		}
	}
	
	/* 링크 복사 */
    function Copy() {
        var t = document.createElement("textarea");
        document.body.appendChild(t);
        t.value = page;
        t.select();
        document.execCommand('copy');
        document.body.removeChild(t);
    }
    
    /* 지도 */
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('${project.comAddr1}', function(result, status) {
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});
	 
	/* 관심프로젝트 추가  */
	var interestdata={	
		"pjt_num":"${project.pjt_num}",
		"mem_num":"${loginUser.mem_num}"
	}
	
	function likePjt(){
		if(!'${loginUser.mem_num}'){
			alert('로그인 후 이용해주세요.');
			location.href="/commons/loginForm";
			return;
		}
		
		//관심리스트에 있는지 확인
		$.ajax({
			url : "<%=request.getContextPath()%>/project/isInterest",
			type:"post",		
			data:JSON.stringify(interestdata),	
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"post"
			},
			success:function(data){
				
				if(data=='SUCCESS'){
					//관심리스트에 추가
					$.ajax({
						url : "<%=request.getContextPath()%>/project/interest",
						type:"post",		
						data:JSON.stringify(interestdata),	
						headers:{
							"Content-Type":"application/json",
							"X-HTTP-Method-Override":"post"
						},
						success:function(interestdata){
							alert('관심 프로젝트에 추가하였습니다.');
							$('.fa-heart').attr('class','fas fa-heart');
						},
						error:function(error){
							alert('서버가 지연되고 있습니다.');
						}
					});
					
				}
				if(data=='FAIL'){
					//관심리스트에서 삭제
					$.ajax({
						url : "<%=request.getContextPath()%>/project/interestCancle",
						type:"post",		
						data:JSON.stringify(interestdata),	
						headers:{
							"Content-Type":"application/json",
							"X-HTTP-Method-Override":"post"
						},
						success:function(interestdata){
							alert('관심 프로젝트에 삭제하였습니다.');
							$('.fa-heart').attr('class','far fa-heart');
						},
						error:function(error){
							alert('서버가 지연되고 있습니다.');
						}
					});
				}
			},
			error:function(error){
				alert('서버가 지연되고 있습니다.');
			}
		});
	}
	
	

	

</script>
<%@ include file="./Pjtreply_js.jsp" %>
</body>