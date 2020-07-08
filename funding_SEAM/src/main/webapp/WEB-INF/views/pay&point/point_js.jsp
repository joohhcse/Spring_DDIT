<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	$('#checkUse').on('click',function(){
			$('#point').css('background-color','');
			$('#point').attr('readonly',false);
			
	});
	
	$('#checkNotUse').on('click',function(){
			$('#point').css('background-color','lightgray');
			$('#point').attr('readonly',true);
			$('#point').val("");
			
	});
	
	$('#checkUse2').on('click',function(){
			$('#pointAttend').css('background-color','');
			$('#pointAttend').attr('readonly',false);
	});
	
	$('#checkNotUse2').on('click',function(){
			$('#pointAttend').css('background-color','lightgray');
			$('#pointAttend').attr('readonly',true);
			$('#pointAttend').val("");
			
	});
	
	function checkuse(){
		$('input[name=check1]').prop('checked',false);
	}
	
	function checkNotuse(){
		$('input[name=check1]').prop('checked',false);
	}
	
	function checkuse1(){
		$('input[name=check]').prop('checked',false);
	}
	function checkNotuse1(){
		$('input[name=check]').prop('checked',false);
	}
	
	

	$('#saveBtn').on('click',function(){
		var point = $('#point').val();
		var pointAttend = $('#pointAttend').val();
		if($('#checkUse').is(':checked')){
			if(point==""){
				alert('지급할 포인트를 입력해주세요.');
				$('#point').focus();
				return false;
			}
			location.href="<%=request.getContextPath()%>/admin/join/point?point="+point;
		}else if($('#checkNotUse').is(':checked')){
			location.href="<%=request.getContextPath()%>/admin/join/noPoint";
		}else if($('#checkUse2').is(':checked')){
			 $('input[name=check]').removeAttr('checked');
			if(pointAttend==""){
				alert('지급할 포인트를 입력해주세요.');
				$('#pointAttend').focus();
				return false;
			}
			location.href="<%=request.getContextPath()%>/admin/attend/point?point="+pointAttend;
		}else if($('#checkNotUse2').is(':checked')){
			location.href="<%=request.getContextPath()%>/admin/attend/noPoint";
		}			
				
		
	});
</script>