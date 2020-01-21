<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>board</title>

</head>
<body>
	<script>
		$(document).ready(function() {
			var mode = '<c:out value="${mode}"/>';

			console.log(`mode: ${mode}`);
		})
	</script>
	<article>
		<div class="container" role="main">
			<h2>board Form</h2>
			<form:form name="form" id="form" role="form" modelAttribute="board" method="post" action="/board/saveBoard">
				<form:hidden path="bid" /><input type="hidden" name="mode">
				<div class="mb-3">
					<label for="title">제목</label>
					<form:input path="title" id="title" class="form-control" placeholder="제목을 입력해주세요." />
				</div>
				<div class="mb-3">
					<label for="reg_id">작성자</label>
					<form:input path="reg_id" id="reg_id" class="form-control" placeholder="이름을 입력해주세요." />
				</div>
				<div class="mb-3">
					<label for="content">내용</label>
					<form:textarea path="content" id="content" class="form-control" rows="5" placeholder="내용을 입력해주세요."></form:textarea>
				</div>
				<div class="mb-3">
					<label for="tag">태그</label>
					<form:input path="tag" id="tag" class="form-control" placeholder="태그를 입력해주세요." />
				</div>
				<div class="mb-3">
					<label for="cate_cd">카테고리</label>
					<form:input path="cate_cd" id="cate_cd" class="form-control" placeholder="카테고리를 입력해주세요" />
				</div>
				<div>
					<button type="button" class="btn btn-sm btn-primary" id="btnSave">저장</button>
					<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
				</div>
			</form:form>
		</div>
	</article>
	

	
	<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>
</body>
</html>