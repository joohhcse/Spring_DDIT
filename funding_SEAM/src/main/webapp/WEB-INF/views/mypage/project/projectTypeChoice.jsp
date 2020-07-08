<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>

		<div class="album py-5 bg-light">
		    <div class="container">
		      <div class="row contents text-center">
		      
		 <div class="col-md-6">
          <div class="card mb-6 shadow-sm  projectCard" style="cursor:pointer;">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" 
            onclick="donationPjt();" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail">
              <title>후원형</title>
               <rect width="100%" height="100%" fill="#55595c"></rect></svg>
                   <div class="card-body">
				 	<h3>후원형</h3>
            </div>
          </div>
        </div>
        		 <div class="col-md-6">
          <div class="card mb-6 shadow-sm  projectCard" style="cursor:pointer;">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" 
            onclick="loanPjt();" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail">
              <title>대출형</title>
               <rect width="100%" height="100%" fill="#55595c"></rect></svg>
                   <div class="card-body">
				 	<h3>대출형</h3>
            </div>
          </div>
        </div>
		        
		
		      </div>
		    </div>
		  </div>

<script>
function donationPjt(){
	if(!'${loginUser.mem_num}'){
		alert('로그인이 필요합니다.');
		return;
	}
	location.href='/mypage/project/projectRegistForm_donation?mem_num=${loginUser.mem_num }';
}

function loanPjt(){
	if(!'${loginUser.mem_num}'){
		alert('로그인이 필요합니다.');
		return;
	}
	location.href='/mypage/project/projectRegistForm_loan?mem_num=${loginUser.mem_num }';
}


</script>
</body>
