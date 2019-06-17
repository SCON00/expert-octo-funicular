/**
 * 
 */
$(document).ready(function(){
	$('.accordion').each(function(){
		var allDt = $(this).find('dt');
		var allDd = $(this).find('dd');
		
		allDd.hide();
		allDt.css('cursor','pointer');
		allDt.click(function(){
			$(this).next().slideToggle();			
		});
	});
});