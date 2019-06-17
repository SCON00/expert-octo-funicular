$(function() {
	var anchors = $('.tabSet a');
	var panelDivs = $('.tabSet').find('div.panel');
	
	anchors.show();
	panelDivs.hide();

	var lastAnchor = anchors.filter('.on');
	var lastPanel = $(lastAnchor.attr('href'));
	lastPanel.show();
	anchors.click(function(){
		lastAnchor.removeClass('on');
		lastPanel.hide();
		lastAnchor = $(this).addClass('on');
		lastPanel = $($(this).attr('href')).show();
	});
});