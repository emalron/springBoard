<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/layouts/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
	<article>
		<div class="container">
			<div class="table-responsive">
				<h2>board list</h2>
				<table class="table table-striped table-sm">
					<colgroup>
						<col style="width:5%;" />
						<col style="width:auto%;" />
						<col style="width:15%;" />
						<col style="width:10%;" />
						<col style="width:10%;" />
					</colgroup>
					<thead>
						<tr>
							<th>NO</th>
							<th>글 제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty boardList}">
								<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
							</c:when>
							<c:when test="${!empty boardList}">
								<c:forEach var="list" items="${boardList}">
									<tr>
										<td><c:out value="${list.bid}" /></td>
										<td><a href="#" onclick="fn_contentView(${list.bid})"><c:out value="${list.title}" /></a></td>
										<td><c:out value="${list.reg_id}" /></td>
										<td><c:out value="${list.view_cnt}" /></td>
										<td><c:out value="${list.reg_dt}" /></td>
									</tr>
								</c:forEach>
							</c:when>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnWriteForm">글쓰기</button>
			</div>
		</div>
	</article>
	<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>
</body>
</html>