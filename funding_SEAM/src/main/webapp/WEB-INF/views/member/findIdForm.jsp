<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body class="hold-transition login-page text-center">
<br>
	<form class="container" role="form" action="" method="post" style="">
		<div class="form-group has-success has-feedback" for="">
			<label class="control-label" for="id">회원이름:</label>
			<input type="text" class="form-control" id="id" placeholder="회원이름을 입력하세요" name="mem_name">
		</div>
	
		<div class="form-group has-success has-feedback">
			<label class="control-label" for="id">휴대폰 번호:</label>
			<input type="text" class="form-control" id="phone" placeholder="휴대폰을 입력하세요" name="mem_phone" onKeyup="inputPhoneNumber(this) ">
		</div>
	
		<div class="form-group has-success has-feedback">
			<div>
				<button type="button" class="btn btn-outline-success btn-flat" onclick="FindId();">아이디 찾기</button>
			</div>
		</div>
	</form>

<script>

function FindId() {
	var mem_name = $('input[name="mem_name"]');
	var mem_phone = $('input[name="mem_phone"]');
	
	if(!mem_name.val()) {
		alert("회원이름을 입력하세요");
		mem_name.focus();
		return;
	}

	var temp1 = mem_name.val();		//name
	var temp2 = mem_phone.val();	//phone
	
	$.ajax({
		url : "requestFindId",
		type : "post",
		data : {"mem_name" : temp1,
				"mem_phone" : temp2		
		},
		success : function(data) {
			if(data.strResult == "") {
				//존재하는 아이디 없음
 				console.log("fail : no have id");
				alert("존재하는 아이디가 없습니다.");
				window.close();
			}
			else {
				//아이디 찾음
				console.log(data.strResult);
				var strRes = data.strResult;
				window.location.href="<%=request.getContextPath()%>/member/findId_ok?email=" + strRes;
			}
		},
		error : function(data) {
			alert("아이디 확인이 불가능합니다.")
		}
	});
}

function inputPhoneNumber(obj) {
    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";

    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
}

function SubmitFindId(formRole){
	var form = $('form[role="'+formRole+'"]');
	form.submit();
}

</script>
	
</body>
