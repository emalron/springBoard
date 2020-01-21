<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>board</title>
</head>
<body>
	<article>
		<div class="container" role="main">
			<h2>board Content</h2>
			<div class="bg-white rounded shadow-sm">
				<div id="bid" style="display:none">${board.bid}</div>
				<div class="board_title">${board.title}</div>
				<div class="board_info_box">
					<span class="board_author"><c:out value="${board.reg_id}" /></span><span class="board_date"><c:out value="${board.reg_dt }" /></span>
				</div>
				<div class="board_content">${board.content }</div>
				<div class="board_tag">${board.tag }</div>
			</div>
						
			<div style="margin-top:20px">
				<button type="button" class="btn btn-sm btn-secondary" id="btnUpdate">수정</button>
				<button type="button" class="btn btn-sm btn-danger" id="btnDelete">삭제</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
		

	</article>
	
	<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>
</body>
</html>