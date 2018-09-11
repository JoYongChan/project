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
	$('#storecode').keyup(function () { 
	    this.value = this.value.replace(/[^0-9]/g,'');
	});
	$('#ceocode').keyup(function () { 
		this.value = this.value.replace(/[^0-9]/g,'');
	});
	$('#busno').keyup(function () { 
		this.value = this.value.replace(/[^0-9]/g,'');
	});
	$('#storephone').keyup(function () { 
		this.value = this.value.replace(/[^0-9]/g,'');
	});
	$('#phone').keyup(function () { 
		this.value = this.value.replace(/[^0-9]/g,'');
	});
	$('#age').keyup(function () { 
		this.value = this.value.replace(/[^0-9]/g,'');
	});
	
	$('#cancel_btn').on('click',function(){
		$(location).attr('href',"home");
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
	 $('#storedatatable').DataTable({});
	 $('#tabledatatable').DataTable({});
	 $('#employeesalarydatatable').DataTable({}); 
	 $('#employeecommutedatatable').DataTable({}); 
	 $('#employeesalaryrollListdatatable').DataTable({}); 
	 
	 $('#selectstore').on('change',function () { 
			var storename = $(this).children('option:selected').text();
			var empcode = $(this).val();
			$.ajax({
				type : 'POST',
				data : "empcode="+empcode,
				url : 'storeSelected',
				success : function(data){
					$('#storename').attr('value',data.storename);
				},
				error : function(xhr, status, error){
					alert('ajax error'+error);
				}
			});
		});
	 
	//store_insert_form
	 $('#store_confirm').on('click',function(){ 
			var storecode = $('#storecode').val();
			if(storecode==""){
				$('#confirmModal').modal('show');
				$('#confirm-modal-body').text('매장번호를 입력하세요.');
				$('#confirm_modal_btn1').text("확인");
				$('#confirm_modal_btn2').hide();
				return;
			}else{
				$.ajax({
					type : 'POST',
					data : "storecode="+storecode,
					url : 'storecodeConfirm',
					success : function(data){
						if(data == 0){
							$('#confirmModal').modal('show');
							$('#confirm-modal-body').text('사용가능한 매장번호입니다.');
							$('#confirm_modal_btn1').on('click',function(){
								$('#storeconfirm_yn').val("y");
							});
						}else{
							$('#confirmModal').modal('show');
							$('#confirm-modal-body').text('중복된 매장번호입니다.\n다시 입력해주세요.');
							$('#confirm_modal_btn1').text("확인");
							$('#confirm_modal_btn2').hide();
						}
						
					},
					error : function(xhr, status, error){
						alert('ajax error');
					}
				});
			}
		});
	 
	//store_insert_form
	$('#store_save_btn').on('click',function(){
		if($('#storeconfirm_yn').val() == "n"){
			 $('#confirmModal').modal('show');
			 $('#confirm-modal-body').text('매장번호를 중복체크 하세요.');
			 $('#confirm_modal_btn1').text("확인");
			 $('#confirm_modal_btn2').hide();
			return;
		}
		$('#store_insert_form').submit();
	});
	
	$('#store_delete_btn').on('click',function(){
		$('#confirmModal').modal('show');
		$('#confirm-modal-body').text('정말 삭제 하시겠습니까?');
		$('#confirm_modal_btn1').text("삭제");
		$('#confirm_modal_btn2').text("취소");
		$('#confirm_modal_btn1').on('click',function(){
			var url = "storeDelete?storecode="+$('#storecode').val();
			$(location).attr('href',url);
		});
	});
	
	//tableaccount
	$('#table_confirm').on('click',function(){
		 var tablecode = $('#tablecode').val();
		 if(tablecode==""){
			 $('#confirmModal').modal('show');
			 $('#confirm-modal-body').text('테이블코드를 입력하세요.');
			 $('#confirm_modal_btn1').text("확인");
			 $('#confirm_modal_btn2').hide();
			 return;
		 }else{
			 $.ajax({
				 type : 'POST',
				 data : "tablecode="+tablecode,
				 url : 'tablecodeConfirm',
				 success : function(data){
					 if(data == 0){
						 $('#confirmModal').modal('show');
						 $('#confirm-modal-body').text('사용가능한 테이블코드입니다.');
						 $('#confirm_modal_btn1').on('click',function(){
							 $('#tableconfirm_yn').val("y");
						 });
					 }else{
						 $('#confirmModal').modal('show');
						 $('#confirm-modal-body').text('중복된 테이블코드입니다.\n다시 입력해주세요.');
						 $('#confirm_modal_btn1').text("확인");
						 $('#confirm_modal_btn2').hide();
					 }
					 
				 },
				 error : function(xhr, status, error){
					 alert('ajax error');
				 }
			 });
		 }
	 });
	
	
	$('#table_save_btn').on('click',function(){
		if($('#tableconfirm_yn').val() == "n"){
			 $('#confirmModal').modal('show');
			 $('#confirm-modal-body').text('테이블코드를 중복체크 하세요.');
			 $('#confirm_modal_btn1').text("확인");
			 $('#confirm_modal_btn2').hide();
			return;
		}
		$('#table_insert_form').submit();
	});
	
	$('#table_delete_btn').on('click',function(){
		$('#confirmModal').modal('show');
		$('#confirm-modal-body').text('정말 삭제 하시겠습니까?');
		$('#confirm_modal_btn1').text("삭제");
		$('#confirm_modal_btn2').text("취소");
		$('#confirm_modal_btn1').on('click',function(){
			var url = "tableDelete?tablecode="+$('#tablecode').val();
			$(location).attr('href',url);
		});
	});
	
	//employee_insert_form
	//employee_confirm
	 $('#employee_confirm').on('click',function(){ 
			var empcode = $('#empcode').val();
			if(empcode==""){
				$('#confirmModal').modal('show');
				$('#confirm-modal-body').text('사원번호를 입력하세요.');
				$('#confirm_modal_btn1').text("확인");
				$('#confirm_modal_btn2').hide();
				return;
			}else{
				$.ajax({
					type : 'POST',
					data : "empcode="+empcode,
					url : 'empcodeConfirm',
					success : function(data){
						if(data == 0){
							$('#confirmModal').modal('show');
							$('#confirm-modal-body').text('사용가능한 사원번호입니다.');
							$('#confirm_modal_btn1').on('click',function(){
								$('#employeeconfirm_yn').val("y");
							});
						}else{
							$('#confirmModal').modal('show');
							$('#confirm-modal-body').text('중복된 사원번호입니다.\n다시 입력해주세요.');
							$('#confirm_modal_btn1').text("확인");
							$('#confirm_modal_btn2').hide();
						}
						
					},
					error : function(xhr, status, error){
						alert('ajax error');
					}
				});
			}
		});
	 
	$('#employee_save_btn').on('click',function(){
		if($('#employeeconfirm_yn').val() == "n"){
			 $('#confirmModal').modal('show');
			 $('#confirm-modal-body').text('사원번호를 중복체크 하세요.');
			 $('#confirm_modal_btn1').text("확인");
			 $('#confirm_modal_btn2').hide();
			return;
		}
		$('#employee_insert_form').submit();
	});
	
	$('#employee_delete_btn').on('click',function(){
			$('#confirmModal').modal('show');
			$('#confirm-modal-body').text('사원정보를 삭제하시겠습니까?');
			$('#confirm_modal_btn1').text("확인");
			$('#confirm_modal_btn2').text("취소");
			$('#confirm_modal_btn1').on('click',function(){
				var url = "employeeDelete?empcode="+$('#empcode').val();
				$(location).attr('href',url);
			});
	});
	
	$('#selectemployee').on('change',function () { 
		var name = $(this).children('option:selected').text();
		var empcode = $(this).val();
		$.ajax({
			type : 'POST',
			data : "empcode="+empcode,
			url : 'employeeSelected',
			success : function(data){
				$('#name').attr('value',data.name);
				$('#gender').attr('value',data.gender);
				$('#age').attr('value',data.age);
				$('#hiredate').attr('value',data.hiredate);
				$('#memlevel').attr('value',data.memlevel);
				$('#attendancetype').attr('value',data.attendancetype);
				$('#leaveworktype').attr('value',data.leaveworktype);
			},
			error : function(xhr, status, error){
				alert('ajax error'+error);
			}
		});
	});
	
	$('#employee_salary_save_btn').on('click',function(){
		$('#employee_salary_form').submit();
	});
	
	$('#employee_salary_delete_btn').on('click',function(){
		$('#confirmModal').modal('show');
		$('#confirm-modal-body').text('사원 급여를 삭제 하시겠습니까?');
		$('#confirm_modal_btn1').text("삭제");
		$('#confirm_modal_btn2').text("취소");
		$('#confirm_modal_btn1').on('click',function(){
			var url = "employeeSalaryDelete?empcode="+$('#empcode').val();
			$(location).attr('href',url);
		});
	});
	
	$('#employee_commute_delete_btn').on('click',function(){
		var empcode =$('#empcode').val();
		var commutedate =$('#commutedate').val();
		$('#confirmModal').modal('show');
		$('#confirm-modal-body').text('사원 근태를 삭제 하시겠습니까?');
		$('#confirm_modal_btn1').text("삭제");
		$('#confirm_modal_btn2').text("취소");
		$('#confirm_modal_btn1').on('click',function(){
			location.href="employeeCommuteDelete?empcode="+empcode+"&commutedate="+commutedate;
		});
	});
	
	  //급여 계산
    $('#salarytax_insert_btn').on('click',function(){
		$('#confirmModal').modal('show');
		$('#confirm-modal-body').text('데이터가 지워지고 다시 생성됩니다.\n계산 처리 하시겠습니까?');
		$('#confirm_modal_btn1').text("등록");
		$('#confirm_modal_btn2').text("취소");
		$('#confirm_modal_btn1').on('click',function(){
			$('#employee_salarytax_form').attr('action', 'employeeSalaryTax');
			$('#employee_salarytax_form').submit();
		});
		
	});
    
});

	