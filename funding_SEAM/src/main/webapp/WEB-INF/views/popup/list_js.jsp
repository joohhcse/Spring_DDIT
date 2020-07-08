<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	$('#registBtn').on('click',function(){
		OpenWindow('<%=request.getContextPath()%>/admin/popup/regist','등록',1280,950);
	});
	
	/* 수정버튼 클릭 */
	$(':button[name="modifyBtn"]').on('click',function(){
		var p_num=$(this).parent().prevAll('.pnum').val();
		OpenWindow('<%=request.getContextPath()%>/admin/popup/modify?p_num='+p_num,'수정',1280,950);
	});
	
	/* 삭제버튼 클릭 */
	$(':button[name="deleteBtn"]').on('click',function(){
		
		var p_num=$(this).parent().prevAll('.pnum').val();
		var ask = confirm('정말 삭제하시겠습니까?');
		if(ask){
			location.href="<%=request.getContextPath()%>/admin/popup/delete?p_num="+p_num;
		}
	});
	
	/* 중지버튼 클릭 */
	$('button[name="stopBtn"]').on('click',function(){
		var p_num=$(this).parent().prevAll('.pnum').val();
		var ask = confirm('해당 팝업을 중지하시겠습니까?');
		if(ask){
			location.href="<%=request.getContextPath()%>/admin/popup/disabled?p_num="+p_num;
		}
	});
	
	/* 활성버튼 클릭 */
	$('button[name="enableBtn"]').on('click',function(){
		var p_num=$(this).parent().prevAll('.pnum').val();
		var ask = confirm('해당 팝업을 활성화 하시겠습니까?');
		if(ask){
			location.href="<%=request.getContextPath()%>/admin/popup/enabled?p_num="+p_num;
		}
	});
</script>