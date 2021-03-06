<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>상세보기</title>
<body>
	<!-- Content Wrapper. Contains page content -->
	<div class="container">

		<div class="justify-content-md-center" style="padding:40px;">
		<h2 class="page-section-heading text-center text-primary text-secondary mb-0">${notice.notice_title }</h2>
			<div class="float-right">
				<c:if test="${loginUser.mem_num eq 1}">					
					<button type="button" class="btn btn-outline-success btn-flat" id="modifyBtn">수정</button>
					&nbsp;		
					<button type="button" class="btn btn-outline-success btn-flat" id="removeBtn">삭제</button>	
				</c:if>
			</div>
					<!-- <button type="button" name="listBtn" class="btn btn-outline-success btn-flat">목록</button> -->
			<br>
	</div>
		<!-- Main content -->
		<div class="post" style="border-bottom: none;">
		<div class="user-block border-top border-bottom row" style="padding:10px;">
			<div class="col-md-12" style="padding: 0px;">
		          <img class="img-circle img-bordered-sm" src="<%= request.getContextPath() %>/displayProfileImg?mem_email=${member.mem_email}&fileName=${member.mem_profile_img}" onerror="this.src='<%= request.getContextPath() %>/resources/images/profile-picture.png'" alt="user profile image">
		          <span class="username">${notice.mem_num }</span>
			          <div>
			          	<span class="" style="margin-left: 10px;"><fmt:formatDate value="${notice.notice_regdate}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
							<div class="col-xs-9 float-right" style="float: right;">조회수 <input type="number" id="notice_view_cnt"
							value="${notice.notice_view_cnt }" readonly style="border: none; border-width: 0; box-shadow: none; width: 50px;" /></div>
	        		  </div>
        	</div>
        
        </div>
        <br>
			<div class="row" id="notice_contents" style="min-height: 200px; max-height: auto;">${notice.notice_contents }
			</div>

		<br/>
			<br>
			<div class="form-group">
				<i class="ace-icon fa fa-folder-open" style="font-size: 16px;"></i>
				<!-- 								<i class="ace-icon fa fa-level-down" style="font-size: 16px;"></i> -->
				<span style="">첨부파일 목록</span>
				<div class="fileDrop">
					<ul class="mailbox-attachments clearfix uploadedList"></ul>
				</div>
			</div>
					
				
				<div class="user-block border-top border-bottom row">
					<table>
						<tbody>
							<tr>
								<td><i class="fas fa-angle-up"></i>&nbsp;<a href="#a" id="next">다음글 : ${notice.next_notice_title}</a></td>
							</tr>
							<tr>
								<td style="height: 5px;"></td>
							</tr>
							<tr>
								<td><i class="fas fa-angle-down"></i>&nbsp;<a href="#a" id="prev">이전글 : ${notice.prev_notice_title}</a></td>
							</tr>
							
						</tbody>
					</table>
				</div>
			
			<br>
			<div class="container">
				<div class="bottom-center" style="text-align: center;" >
					<button type="button" name="listBtn" class="btn btn-outline-success btn-flat" >목록</button>
				</div>
			</div>
			
		
		
		
		
		
		
		<%-- 
		<section class="content container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="card card-outline card-info">
						<div class="card-header">
							<h3 class="card-title">공지사항</h3>
						</div>
						<div class="card-body">
							<div class="form-group col-sm-12">
								<label for="title">제 목</label> <input type="text"
									class="form-control" id="notice_title"
									value="${notice.notice_title }" readonly />

							</div>
							<div class="form-group row center">
								<div class="form-group col-sm-3">
									<label for="writer">작성자</label> <input type="text"
										class="form-control" id="mem_num" value="${notice.mem_num }"
										readonly />
								</div>

								<div class="form-group col-sm-3">
									<label for="regDate">작성일</label> <input type="text"
										class="form-control" id="notice_regdate"
										value="<fmt:formatDate value="${notice.notice_regdate }" pattern="yyyy-MM-dd" />"
										readonly />

								</div>

								<div class="form-group col-sm-3 ">
									<label for="increaseViewCnt">조회수</label> <input type="text"
										class="form-control" id="notice_view_cnt"
										value="${notice.notice_view_cnt }" readonly />
								</div>

							</div>
							<div class="form-group col-sm-12">
								<label for="content">내 용</label>
								<div id="notice_contents">${notice.notice_contents }</div>
							</div>
							<br>
							<div class="form-group">
								<i class="ace-icon fa fa-folder-open" style="font-size: 16px;"></i>
								<!-- 								<i class="ace-icon fa fa-level-down" style="font-size: 16px;"></i> -->
								<span style="">첨부파일 목록</span>
								<div class="fileDrop">
									<ul class="mailbox-attachments clearfix uploadedList"></ul>
								</div>
							</div>
							<br>
							<div>
								<table>
									<tbody>

										<tr>
											<td><a 
												href="#a" id="prev">이전글
													: ${notice.prev_notice_title}</a></td>
										</tr>
										<tr>
											<td><a
												href="#a" id="next">다음글
													: ${notice.next_notice_title}</a></td>
										</tr>
									</tbody>
								</table>
							</div>



						</div>
						<div class="card-footer">
							<c:if test="${loginUser.mem_num eq 1}">
								<button type="button" id="modifyBtn" class="btn btn-warning">MODIFY</button>
								<button type="button" id="removeBtn" class="btn btn-danger">REMOVE</button>
							</c:if>
							<button type="button" id="listBtn" class="btn btn-primary">목록</button>
						</div>
					</div>
					<!-- end card -->
				</div>
				<!-- end col-md-12 -->
			</div>
			<!-- end row  -->


		</section> --%>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	</div>

	<form role="form">
		<input type='hidden' name='notice_num' value="${notice.notice_num}">
	</form>

	<%@ include file="/WEB-INF/views/board/notice/notice_detail_js.jsp"%>

	<script>
		var formObj = $("form[role='form']");
		$('button#modifyBtn').on('click', function(e) {
		//	alert('modify btn click');
			formObj.attr({
				'action' : 'notice_modify',
				'method' : 'get'
			});
			formObj.submit();
		});

		 $("#removeBtn").on("click", function() {
		/* 	var answer = confirm("정말 삭제하시겠습니까?");
			if (answer) {
				formObj.attr("action", "remove");
				formObj.attr("method", "post");
				formObj.submit();
			}
			 */
			
			/* 첨부파일 삭제 요청  */
			var arr=[];
			$('.uploadedList li').each(function(event){
				arr.push($(this).attr("data-src"));			
			});
			
			if(arr.length>0){
				var answer=confirm(arr.length+"개의 첨부파일이 존재합니다.\n 정말 삭제하시겠습니까?");
				if(answer){
					
					$.post('<%=request.getContextPath()%>/deleteAllFiles',
							{files:arr},function(){});
				}else{
					return;
				}
				
			}
			formObj.attr("action", "remove");
			formObj.attr("method", "post");
			formObj.submit();
		}); 

		 
		$("button[name='listBtn']").on("click", function() {
			location.href='notice_list.page';
		});
		
		var prev_num = "${notice.prev_notice_num}";
		//alert(prev_num);
		
		$("#prev").on('click',function(){
			
		if(prev_num=='0'){
			alert('마지막 게시물입니다');
			return;
		}
		
		location.href="<%=request.getContextPath() %>/board/notice/detail?notice_num=${notice.prev_notice_num }";
		
		});
		
		var next_num = "${notice.next_notice_num}";
		
		$("#next").on('click',function(){
			
		if(next_num=='0'){
			alert('마지막 게시물입니다');
			return;
		}
		
		location.href="<%=request.getContextPath() %>/board/notice/detail?notice_num=${notice.next_notice_num }";
		
		});
	</script>

</body>














