<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<!-- 일반 회원 리스트 -->
	<div class="container">
      <div class="col-12">
            <h3 style="color:#4f4f4f;">팝업 리스트</h3>
            <div style="width:100%;text-align:right;">
            <button type="button" class="btn btn-outline-success btn-flat" id="registBtn">팝업 등록</button>
            </div> 
          <!-- /.card-header -->
          <div class="card-body table-responsive p-0" style="height: auto;">
         
            
            <table class="table table-head-fixed text-center">
              <thead>
                <tr>
                  <th>번 호</th>
                  <th>팝업 이름</th>
                  <th>Top</th>
                  <th>Left</th>
                  <th>가로</th>
                  <th>세로</th>
                  <th>등록일</th>
                  <th>종료일</th>
                  <th>상태</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
			<c:forEach items="${popup }" var="pop">
				<tr style='font-size:0.85em;'>
					<td>${pop.p_num }</td>
					<input class="pnum" type="hidden" value=${pop.p_num }>
					<td>${pop.p_name }</td>
					<td>${pop.p_top }</td>
					<td>${pop.p_left }</td>
					<td>${pop.p_width}</td>
					<td>${pop.p_height}</td>
					<td style="width:130px;"><fmt:formatDate value="${pop.p_startdate}" pattern="yyyy-MM-dd"/></td>
					<td style="width:130px;"><fmt:formatDate value="${pop.p_enddate}" pattern="yyyy-MM-dd"/></td>
					<td>${pop.p_enable }</td>
					<td>
						<button type="button" class="btn btn-outline-success btn-flat" id="modifyBtn" name="modifyBtn">수정</button>&nbsp;
						<button type="button" class="btn btn-outline-success btn-flat" id="deleteBtn" name="deleteBtn">삭제</button>&nbsp;
						<c:if test="${pop.p_enable eq '게시중' }">
						<button type="button" class="btn btn-outline-success btn-flat" id="stopBtn" name="stopBtn">중지</button>
						</c:if>
						<c:if test="${pop.p_enable eq '중단됨' or pop.p_enable eq '대기' }">
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