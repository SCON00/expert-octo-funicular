window.onload = function(){

		//var frm = document.getElementById('frm');
		//var inputs = document.getElementsByTagName('input');
		var frm = document.querySelector('#frm');
		var inputs = document.querySelectorAll("input");
		
		frm.onclick = function(e){
//			e.preventDefault();
//			e.stopPropagation();
			var agree = frm.agree;
			if(!agree.checked){
				alert('반드시 확인하셔야 합니다.');
				return;
			}
			// 별칭이 ['babo','geni','idiot','gdb']
			var nName = new Array('babo','geni','idiot','gdb');
			if(!nName.includes(frm.nickname.value)){
				alert('별칭이 문제다!');
				return;
			}
			frm.submit();
		}

	}