/**
 * 
 */

$(function(){
	$('.rollover').each(function(){
		var a = $(this);
		var img = a.find('img');
		
		// [필수]img 에 속성 중에서 src 값 변경 (attr() 이용)
		// [선택]replace('a','b') 이용
		a.hover(function(){
			img.attr('src',img.attr('src').replace('off','on'));
		},function(){
			img.attr('src',img.attr('src').replace('on','off'));
		})
	});
	
});