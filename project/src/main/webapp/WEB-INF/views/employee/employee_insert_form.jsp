<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="employee_insert_form" name="employee_insert_form" method="post" action="employeeInsert" data-parsley-validate="true">
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="input-group mb-3 col-md-4 ">
					<div class="input-group-prepend">
						<span style="text-align: center; font-style: inherit; margin-bottom: 20px; font-size: 30px">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	직원 등록 </span>
					</div>
				</div>
				<div class="col-md-4"></div>
			</div>
			
			<div class="row">
				<div class="col-md-5"></div>
				<div class="input-group mb-3 col-md-4 ">
					<a href="#">
						<img id="image" name="image" src="resources/img/noimage1.png" title="클릭 후 이미지 변경"
							alt="클릭 후 이미지 변경" class="rounded-circle" style="border: 1px solid;" width="140px" height="140px"> 
					</a>
				</div>
				<div class="col-md-3"></div>
			</div>

			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6 text-center">
					<div>
						<input type="file" id="photo" name="imgfile" style="visibility: hidden;">
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>

			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 사원번호 </span>
					</div>
					<input type="text" id="empcode" name="empcode" class="form-control" placeholder="사원번호" 
					 style="ime-mode: disabled" aria-describedby="basic-addon1" maxlength="6">
					<button type="button" id="employee_confirm" class="btn btn-primary" style="color: #000000">중복확인</button>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 이름 </span>
					</div>
					<input type="text" id="name" name="name" class="form-control" placeholder="이름" 
					 style="ime-mode: disabled" aria-describedby="basic-addon1" maxlength="20">
				</div>
			</div>

			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 나이 </span>
					</div>
					<input type="text" id="age" name="age" class="form-control" placeholder="" 
					 style="ime-mode: disabled" aria-describedby="basic-addon1" maxlength="">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 성별 </span>
					</div>
					<div class="input-group-prepend btn-group btn-group-toggle" data-toggle="buttons">
        				 <label class="btn btn-secondary active">
        				 	<input type="radio" name="gender" id="gender" value="남자" autocomplete="off" checked> 남자 </label>
        				 <label class="btn btn-secondary">
        				 	<input type="radio" name="gender" id="gender" value="여자" autocomplete="off"> 여자 </label>
					</div>
				</div>
			</div>
			
			<div class="row">
			<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 생년월일 </span>
					</div>
					<!-- Date input, salary_insert_form.jsp -->
					<input class="form-control" id="date" name="birthday" placeholder="MM/DD/YYY" type="date" />
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 우편번호</span>
					</div>
					<input id="postno" name="postno" type="text" class="form-control" placeholder="PostNo" aria-label="Usernzipcode" aria-describedby="basic-addon1">
					<button onclick="ZipcodeFind()" type="button" class="btn btn-primary" style="color: #000000">찾기</button>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 신 주소 </span>
					</div>
					<input id="newaddr" name="newaddr" type="text" class="form-control" placeholder="신 주소" aria-label="Usernzipcode" aria-describedby="basic-addon1">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 구 주소 </span>
					</div>
					<input id="oldaddr" name="oldaddr" type="text" class="form-control" placeholder="구 주소" aria-label="Usernzipcode" aria-describedby="basic-addon1">
				</div>
			</div>

			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 상세 주소 </span>
					</div>
					<input id="detailaddr" name="detailaddr" type="text" class="form-control" placeholder="상세 주소" aria-label="Usernzipcode" aria-describedby="basic-addon1">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 전화번호 </span>
					</div>
					<input id="phone" name="phone" type="text" class="form-control" placeholder="ex)01012345678" aria-label="Usernzipcode" aria-describedby="basic-addon1">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3"></div>
				<div class="input-group mb-3 col-md-6 ">
					<div class="input-group-prepend">
						<span class="input-group-text" style="width: 120px"> 직급 </span>
					</div>
					<div class="input-group-prepend btn-group btn-group-toggle" data-toggle="buttons">
        				 <label class="btn btn-secondary active">
        				 	<input type="radio" name="memlevel" id="memlevel" value="사장" autocomplete="off" checked> 사장 </label>
        				 <label class="btn btn-secondary">
        				 	<input type="radio" name="memlevel" id="memlevel" value="매니저" autocomplete="off"> 매니저 </label>
        				 <label class="btn btn-secondary">
        				 	<input type="radio" name="memlevel" id="memlevel" value="직원" autocomplete="off"> 직원 </label>
					</div>
				</div>
			</div>
			
			<div class="row" style="margin-bottom: 100px; margin-top: 20px">
				<div class="col-md-5"></div>
				<div class="col-md-4">
					<button id="employee_save_btn" name="employee_save_btn" type="submit"	class="btn btn-success save" style="color: #000000">등 록</button>
					<button id="cancel_btn" name="cancel_btn" type="button"	class="btn btn-danger save" style="margin-left: 10px; color: #000000">취 소</button>
				</div>
				<div class="col-md-3"></div>
			</div>
			
		</div>
	</form>

</body>
</html>