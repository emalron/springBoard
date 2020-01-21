// onclick event 등록
$(document).on('click', '#btnWriteForm', function(e) {
	e.preventDefault();
	location.href="/board/boardForm";
})

$(document).on('click', '#btnSave', function(e) {
	e.preventDefault();
	$("#form").submit();
})

$(document).on('click', '#btnList', function(e) {
	e.preventDefault();
	location.href="/board/getBoardList"
})

$(document).on('click', '#btnUpdate', function(e) {
	e.preventDefault()
	let num = $("#bid").text();
	let url = "/board/update/" + num;
	location.href= url;
})

$(document).on('click', '#btnDelete', function(e) {
	e.preventDefault();
	location.href="/board/getBoardList"
})


var fn_contentView = function(bid) {
	url = "/board/" + bid;
	location.href = url;
}