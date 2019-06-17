/**
 * 
 */
$(function(){
	$('#signup > form').validate({
		rules : {
			name : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			website : {
				url : true
			},
			password : {
				required : true,
				minlength : 6
			},
			passconf : {
				equalTo : '#password'
			}
		},
		success : function(label){
			label.addClass('valid');
			label.text('valid');
		}
	});
	
	// 체크박스 선택시
	$('.stats > .check-all').click(function(){
		var check = $(this).is(':checked');
		$('.stats > .agree').prop('checked', check);		
	});
});