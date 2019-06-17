/**
 * 
 */

$(function(){
	// (1) 테이블의 홀수행 배경색 변경
	$('#celebs tbody').find('tr:odd').addClass('table_striping');
	
	// (2) 테이블에 마우스 올라가면 색 변경
	// (css 파일에 있는 td_mouseover 클래스 지정)
	$('#celebs tr').hover(function(){
		$(this).toggleClass('td_mouseover');
	});
	
	// (3) 감추기 보이기 버튼
	$('#hideButton').click(function(){
		$('#intro > img').slideUp();
	});
	$('#showButton').click(function(){
		$('#intro > img').slideDown();
	});
	$('#toggleButton').click(function(){
		$('#intro > img').fadeToggle();
	});
});