<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<!-- 일반 회원 리스트 -->
	<div class="container">
      <div class="col-12">
            <h3 style="color:#4f4f4f;">배너 리스트</h3>
            <button style="float:right;" type="button" class="btn btn-outline-success btn-flat" id="registBtn">배너 등록</button>
          <!-- /.card-header -->
          <div class="card-body table-responsive p-0" style="height: auto;">
         
            
            <table class="table table-head-fixed text-center">
              <thead>
                <tr>
                  <th>번 호</th>
                  <th>배너 이름</th>
                  <th>유형</th>
                  <th>상태</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
			<c:forEach items="${banner }" var="banner">
				<tr style='font-size:0.85em;'>
					<td>${banner.b_num }</td>
					<input class="bnum" type="hidden" value="${banner.b_num }">
					<td>${banner.b_name }</td>
					<td>${banner.b_type }</td>
					<td>${banner.b_enable }</td>
					<td>
						<button type="button" class="btn btn-outline-success btn-flat" id="modifyBtn" name="modifyBtn">수정</button>&nbsp;
						<button type="button" class="btn btn-outline-success btn-flat" id="deleteBtn" name="deleteBtn">삭제</button>&nbsp;
						<c:if test="${banner.b_enable eq '게시중' }">
						<button type="button" class="btn btn-outline-success btn-flat" id="stopBtn" name="stopBtn">중지</button>
						</c:if>
						<c:if test="${banner.b_enable eq '중단됨' or banner.b_enable eq '대기'}">
						<button type="button" class="btn btn-outline-success btn-flat" id="enableBtn" name="enableBtn">활성</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
          </tbody>
         </table>
         <%@include file="pagination.jsp" %>
       </div>
   <%@include file="list_js.jsp"%>
      <!-- /.card-body -->
    <!-- /.card -->
    </div>
   </div>