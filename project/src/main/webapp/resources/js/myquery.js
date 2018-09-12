function comment_update(c_code){
	var commentList = $('#commentList').val();
	var b_code = $('#b_code').val();
    $.ajax({
        type:'GET',
        url : "commentList",
        dataType : "json",
        data : "commentList=" + commentList + "&b_code=" + b_code,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        success : function(data){
            
            var html = "";
            var cCnt = data.length;
            
            if(data.length > 0){
                
                for(i=0; i<data.length; i++){
                    html += "<div>";
                    html += "<div><table class='table'><h6><strong>"+data[i].writer+"</strong></h6>";
                    html += "<input type='text' value= "+ data[i].content+"><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>" +
                    		"<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>" +
                    		"<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>" +
                    		"<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>" +
                    		"<td><a href='#' onClick='comment_update()' " +
                    		"class='btn btn-warning btn-sm'>댓글수정</a>&nbsp" +
                    		"<a href='#' onClick='getCommentList()' " +
                    		"class='btn btn-danger btn-sm'>취소</a></td></tr>";
                    html += "</table></div>";
                    html += "</div>";
                }
                
            } else {
                
                html += "<div>";
                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                html += "</table></div>";
                html += "</div>";
                
            }
            
            $("#cCnt").html( cCnt );
            $("#commentList").html(html);
            
        },
        error:function(request,status,error){
            
       }
        
    });
}
//function comment_update(){
//	$('#commentupdateModal').modal('show');
//	$(".commentupdatemodal-body").html("<div class='col-md-1'></div><div class='input-group-prepend'><span class='input-group-text'>내용</span><input type='text'/></div>");
//	$('.modaldetail_btn2').text('취소');
//	$('.modaldetail_btn1').on('click',function(){
//		$.ajax({
//	        type:'GET',
//	        url : "commentDelete",
//	        data : "c_code=" + c_code,
//	        datatype : 'json',
//	        success : function(data){
//	            if(data=="success")
//	            {
//	                getCommentList();
//	            }
//	        },
//	        error:function(request,status,error){
//	            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//	       }
//	        
//	    });
//	});
//    
//}
function comment_delete(c_code){
	$('#commentdeleteModal').modal('show');
	$('.commentdeletemodal-body').text('삭제 하시겠습니까?');
	$('.modaldetail_btn2').text('취소');
	$('.modaldetail_btn1').on('click',function(){
		$.ajax({
	        type:'GET',
	        url : "commentDelete",
	        data : "c_code=" + c_code,
	        datatype : 'json',
	        success : function(data){
	            if(data=="success")
	            {
	                getCommentList();
	            }
	        },
	        error:function(request,status,error){
	            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	       }
	        
	    });
	});
    
}
function fn_comment(b_seq){
	var c_code = $('#c_code').val();
	var content = $('#content').val();
    $.ajax({
        type:'POST',
        url : "commentInsert",
        data : "content=" + content + "&b_seq=" + b_seq,
        datatype : 'json',
        contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
        success : function(data){
            if(data=="success")
            {
            	$("#content").val("");
                getCommentList();
                
            }
        },
        error:function(request,status,error){
            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
        
    });
}


// 초기 페이지 로딩시 댓글 불러오기
$(function(){
    
    getCommentList();
    
});
 
// 댓글 불러오기(Ajax)

function getCommentList(){
	var commentList = $('#commentList').val();
	var b_code = $('#b_code').val();
    $.ajax({
        type:'GET',
        url : "commentList",
        dataType : "json",
        data : "commentList=" + commentList + "&b_code=" + b_code,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
        success : function(data){
            
            var html = "";
            var cCnt = data.length;
            
            if(data.length > 0){
                
                for(i=0; i<data.length; i++){
                    html += "<div>";
                    html += "<div><table class='table'><h6><strong>"+data[i].writer+"</strong></h6>";
                    html += data[i].content + "<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>" +
                    		"<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>" +
                    		"<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>" +
                    		"<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>" +
                    		"<td><a href='#' onClick='comment_update()' " +
                    		"class='btn btn-warning btn-sm'>댓글수정</a>&nbsp" +
                    		"<a href='#' onClick='comment_delete("+ data[i].c_code +")' " +
                    		"class='btn btn-danger btn-sm'>댓글삭제</a></td></tr>";
                    html += "</table></div>";
                    html += "</div>";
                }
                
            } else {
                
                html += "<div>";
                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                html += "</table></div>";
                html += "</div>";
                
            }
            
            $("#cCnt").html(cCnt);
            $("#commentList").html(html);
            
        },
        error:function(request,status,error){
            
       }
        
    });
}


function ZipcodeFind() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
			var extraRoadAddr = ''; // 도로명 조합형 주소 변수

			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
				extraRoadAddr += data.bname;
			}
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if(data.buildingName !== '' && data.apartment === 'Y'){
				extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			}
			// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			if(extraRoadAddr !== ''){
				extraRoadAddr = ' (' + extraRoadAddr + ')';
			}
			// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
			if(fullRoadAddr !== ''){
				fullRoadAddr += extraRoadAddr;
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.	//vender
			document.getElementById('postno').value = data.zonecode; //5자리 새우편번호 사용
			document.getElementById('newaddr').value = fullRoadAddr;
			document.getElementById('oldaddr').value = data.jibunAddress;
		}
	}).open();
}

//<!-- 번호입력시 자동으로 다음 input으로 focus -->
function phone2_lengthchk(code) {
	if (code.value.length == 4) {
		document.guest_insert_form.phone3.focus();
	}
}

//<!-- input에 영어 입력못하게하기 -->
function onlyNumber(event){
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 || keyID == 9) 
		return;
	else
		return false;
}
function removeChar(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 || keyID == 9 ) 
		return;
	else
		event.target.value = event.target.value.replace(/[^0-9]/g, "");
}

$(document).ready(function(){
	// board_detail
	$('#board_detail_boarddeletebtn').on('click',function(){
		var b_seq = $('#boardb_seq').val();
		var b_ref = $('#boardb_ref').val();
		$('#detailModal').modal('show');
		$('.detailmodal-body').text('삭제 하시겠습니까?');
		$('.modaldetail_btn2').text('취소');
		$('.modaldetail_btn1').on('click',function(){
			location.href="boardDelete?b_seq="+b_seq+"&b_ref="+b_ref;
			alert("E-mail을 입력하세요!")
		});
	});
	//guest update delete
	$('#guest_update_form_delete').on('click', function(){
		$('#guest_update_form_myModal').modal('show');
		$('.modal-body').text("삭제 하시겠습니까?");
		$('.modal_btn1').text("삭제");
		$('.modal_btn2').text("취소");
		$('.modal_btn1').on('click', function(){
			var url = "guestDelete?phone="+ $('#phone1').val()+$('#phone2').val()+$('#phone3').val();
			// location.href="url";
			$(location).attr('href',url);
		});
	});

	//table_insert_form
	$('#table_confirm').on('click',function(){
		alert('중복체크');
	});
	//store_insert_form
	$('#store_confirm').on('click',function(){
		alert('중복체크');
	});
	
	$('#ceo_confirm').on('click',function(){
		alert('중복체크');
	});
	//table_insert_form
	$('#table_save_btn').on('click',function(){
		alert('테이블계정저장');
	});
	//store_insert_form
	$('#store_save_btn').on('click',function(){
	});
	
	$('#cancel_btn').on('click',function(){
		$(location).attr('href',"loginForm");
	});
	//employee_insert_form image
	$('#image').on('click',function(){
		$('input[type=file]').click();
		return false
	});
	
	$('#photo').change(function(event){
		var tmppath = URL.createObjectURL(event.target.files[0]);
		$('#image').attr('src',tmppath);
	});
	
	 $('#employeedatatable').DataTable({});
	 
		//<!-- Bootstrap - DataTables -->
		$('#example').DataTable();
		
		//<!-- geustinsertform -->
		$('#guset_insert_form_save').on('click', function() {
			$('#guest_insert_form').submit();
		});
		
	
	
});
	