<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<body>
<br>
	<div class="container">

		<div class="row justify-content-md-center">
			<div class="col-12">
				<div class="text-center">
					<h3 >등록한 프로젝트 상세보기</h3>
				</div>
					<br>
			</div>
			<div class="col-12">
				<form class="form-horizontal" name="projectModify" action="pjtModify_donation" method="post" enctype="multipart/form-data">
					<div class="card-body">
						<div class="form-group row">
							<label for="comName" class="col-sm-3">상호명</label>
							<div class="col-sm-6">
								${comMember.com_bsns_name}
							</div>
						</div>
						<div class="form-group row">
							<label for="Addr" class="col-sm-3">사업장 주소</label>
							<div class="col-sm-6">
								${comMember.com_zipcode }&nbsp;
								${comMember.com_addr1 }&nbsp;
								${comMember.com_addr2 }
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-3">연락처</label>
							<div class="col-sm-6">
								${comMember.com_bsns_phone }
							</div>
						</div>
						<div class="form-group row">
							<label for="pjt_category" class="col-sm-3">업종</label>
							<div class="col-sm-6">
								${project.pjt_category}
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-3">통장 사본</label>
							<div class="col-sm-6">
				                      <c:set var="TextValue" value="${pjtBankSumAttach.pjt_atc_bankbook_name}"/>
				                      ${fn:substringAfter(TextValue, '$$') }
							</div>
						</div>
						<hr>
						<div class="form-group row">
							<label for="pjtTitle" class="col-sm-3">프로젝트 유형</label>
							<div class="col-sm-6">
								${project_type_code_val}형
							</div>
						</div>
						<div class="form-group row">
							<label for="pjtTitle" class="col-sm-3">프로젝트 제목</label>
							<div class="col-sm-6">
								${project.pjt_title }
							</div>
						</div>
						<div class="form-group row">
							<label for="pjtCash" class="col-sm-3">목표 금액</label>
							<div class="col-sm-6">
							<fmt:formatNumber value="${project.pjt_cash }" pattern="#,###" />
							</div>
						</div>

						<div class="form-group row">
							<label for="date" class="col-sm-3">프로젝트 기간</label>
							<div class="col-sm-6 input-group-prepend">
								<fmt:formatDate value="${project.pjt_startdate}" pattern="yyyy-MM-dd" /> ~
								<fmt:formatDate value="${project.pjt_enddate}" pattern="yyyy-MM-dd" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-3">대표 이미지</label>
							<div class="col-sm-6">
										<c:set var="TextValue" value="${pjtBankSumAttach.pjt_atc_sum_name}"/>
				                      ${fn:substringAfter(TextValue, '$$') }
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-3">미리보기</label>
							<div class="col-sm-6" >
								<div id="sumImgPreView" class="col-sm-12 no-padding" style="height:400px;width:100%;border:1px solid lightgray;"></div>
							</div>
						</div>
						
					<hr>
						<div class="form-group row">
							<label class="col-sm-3">상세내용</label>
							<div class="col-sm-12">
								${project.pjt_contents }
							</div>
						</div>
						
					<hr>
					<c:if test="${project.pjt_state_code eq 3 }">
					<div class="form-group row">
							<label for="pjtTitle" class="col-sm-2 col-form-label">보류 사유</label>
							<div class="col-sm-8">
								${project.pjt_state_comment }
							</div>
						</div>
					
					</c:if>
					
					</div>
					<!-- /.card-body -->
					<div class="card-footer">
						<div class="row justify-content-md-center">
					<c:if test="${project.pjt_state_code eq 3 }">
							<button type="button" class="btn btn-outline-success btn-flat"
								onclick="modifyForm();">재등록</button>
					</c:if>
							<button type="button" class="btn btn-outline-success btn-flat"
								onclick="javaScript:history.go(-1)">목록</button>
						</div>
					</div>
					<!-- /.card-footer -->
				</form>

			</div>
		</div>
	</div>
		<form style="display: hidden" method="POST" id="modifyform">
	  <input type="hidden" name="pjt_num" value="${project.pjt_num }"/>
	  <input type="hidden" name="mem_num" value="${loginUser.mem_num }"/>
	</form>
<script>
	var imageURL="/project/picture/get?picture=${pjtBankSumAttach.pjt_atc_sum_name}";
	$('div#sumImgPreView').css({'background-image':'url('+imageURL+')',
							  'background-position':'center',
							  'background-size':'cover',
							  'background-repeat':'no-repeat'
	});
	
	function modifyForm(){
		var jobForm=$('#modifyform');
		jobForm.attr("method","post");
		
		if('${project.pjt_type_code}' == '1'){
			jobForm.attr("action","/mypage/project/projectModifyForm_donation");		
		}
		
		if('${project.pjt_type_code}'=='2'){
			jobForm.attr("action","/mypage/project/projectModifyForm_loan");		
		}
		jobForm.submit();
	}
</script>

</body>