<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" style="min-height:800px;">
	<div class="justify-content-md-center" style="padding:40px;">
		<h2 class="page-section-heading text-center text-primary text-secondary mb-0">결제/환불 내역</h2>
	</div>
	
<!-- 	<table style="margin-left:300px;"> -->
	<table>
		<tr>
			<td>
				<select class="form-control" name="searchType" id="searchType" onchange="searchListPayType()">
					<option>결제방식</option>
					<option value="kakaopay" ${pageMaker.cri.searchType eq 'kakaopay' ? 'selected':'' }>카카오페이</option>
					<option value="bankpay" ${pageMaker.cri.searchType eq 'bankpay' ? 'selected':'' }>무통장입금</option>
				</select>
			</td>
			<td>
				<select class="form-control" name="searchState" id="searchState" onchange="searchListRefundState()">
					<option>상태</option>
					<option value="payfinish" ${pageMaker.cri.searchType eq 'payfinish' ? 'selected':'' }>결제완료</option>
					<option value="askRefund" ${pageMaker.cri.searchType eq 'askRefund' ? 'selected':'' }>환불요청</option>
					<option value="refundFinish" ${pageMaker.cri.searchType eq 'refundFinish' ? 'selected':'' }>환불완료</option>
				</select>
			</td>
			<td style="width:100px">
			</td>
			<td>
				<select class="form-control border" name="searchType" id="searchType">
					<option value="pjt"  ${pageMaker.cri.searchType eq 'pjt' ? 'selected':'' }>프로젝트명</option>
				</select>
			</td>
			<td>
				<input class="form-control border" type="text" name="keyword" style="width:200px;" placeholder="검색어를 입력하세요." value="${param.keyword }"/>
			</td>
			<td>
				<button class="btn btn-navbar border" type="button" onclick="searchListKeyword();" data-card-widget="search"><i class="fas fa-search"></i></button>
			</td>
		</tr>
	</table>

	<div class="card-body table-responsive p-0">
			<table class="table table-head-fixed text-center border-bottom">					
				<tr style="font-size:0.95em;">
					<th style="width:10%;">no</th>
					<th style="width:10%;">유형</th>
					<th style="width:30%;">프로젝트</th>
					<th style="width:15%;">결제금액</th>
					<th style="width:10%;">날짜</th>
					<th style="width:10%;">상태</th>
					<th style="width:10%;">환불</th>
				</tr>				
				<c:if test="${empty list }" >
					<tr>
						<td colspan="6">
							<strong>해당 내용이 없습니다.</strong>
						</td>
					</tr>
				</c:if>						
				<c:forEach items="${list }" var="list">
					<tr style='font-size:0.85em;'>
						<td>${list.pjt_pay_num}</td>
						<td>
							<c:if test="${list.pjt_pay_type eq 'kakaopay' }">카카오페이</c:if>
							<c:if test="${list.pjt_pay_type eq 'kakao' }">카카오페이</c:if>
							<c:if test="${list.pjt_pay_type eq 'bankpay' }">무통장입금</c:if>
						</td>
						<td style="text-align:left;max-width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;"
								onclick="OpenWindow('<%= request.getContextPath() %>/mypage/paylist/detail?pjt_num=${list.pjt_num}', '프로젝트 상세보기', '1250', '900')">
								<a href=#>${list.pjt_title }</a>
						</td>
						<td style="width:15%;">${list.pjt_pay_amount }</td>
						<td>
							<fmt:formatDate value="${list.ptj_pay_date }" pattern="yyyy-MM-dd"/>
						</td>
<!-- 						<td style="width:10%;"><span class="statue">진행중</span></td> -->
						<td style="width:10%;"><span class="statue">
							<c:choose>
								<c:when test="${list.pjt_refund eq 0 }">결제완료</c:when>
								<c:when test="${list.pjt_refund eq 1 }">환불요청</c:when>
								<c:when test="${list.pjt_refund eq 2 }">환불완료</c:when>
								<c:otherwise>상태</c:otherwise>
							</c:choose>
							</span>
						</td>
						<td style="width:10%;">
							<c:if test="${list.pjt_refund eq 0 }">
								<button type="button" onclick="askRefundByAjax('${list.pjt_pay_num}')">환불요청</button>
							</c:if>
<%-- 								<a href="<%=request.getContextPath()%>/mypage/paylist/askRefund?pjt_pay_num=${paylist.pjt_pay_num}">환불요청</a> --%>
						</td>
						
					</tr>
				</c:forEach>
			</table>				
		</div>
		<%@ include file="/WEB-INF/views/mypage/paylist/paginationBypayList.jsp" %>	
	</div>
	
	<form style="display: hidden" method="POST" id="detailform">
	  <input type="hidden" name="pjt_num" value=""/>
	</form>
	
	
<script>

$(document).ready(function(){
// 	var today = new Date();
// 	var endday=${project.pjt_enddate }
// 	if(endday < today){
// 		$('.statue').text("종료");
// 	}

});



function askRefundByAjax(pjt_pay_num) {
	console.log(pjt_pay_num);
	
	var ret = confirm('환불 요청을 진행할까요?')
		
	if(ret) {
		$.ajax({
			url: "askRefund",
			data: {"pjt_pay_num": pjt_pay_num},
			success: function(data) {
				if(data.result) {
					alert("환불요청 완료되었습니다.");
				}	
				else {
					alert("환불 요청 실패!");
				}
			}
		});
	}
}

/* 디테일 이동 */
function detailgo(a){
	var jobForm=$('#detailform');
	jobForm.find("[name='pjt_num']").val(a);
	jobForm.attr("action","detail").attr("method","post");
	jobForm.submit();
}


</script>