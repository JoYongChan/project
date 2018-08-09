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


$(document).ready(function(){
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
	
});

$(document).ready(function(){
	
	$('#logout1').on('click',function(){
	});
	//<!-- Bootstrap - DataTables -->
	$('#example').DataTable();
});
	