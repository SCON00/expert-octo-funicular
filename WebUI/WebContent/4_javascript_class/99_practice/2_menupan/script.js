/**
 * 
 */

window.onload = function (){

	var price;
	var content ='';
	var menu;
	var total = new Array();

	//#### 1. TD에 이벤트 발생
	for(var i = 1; i < 7; i++){
		document.getElementById('menu' + i).onclick = function(e){
			colorBack();
			var item = e.target;
			item.style.background = "#32353D";
			item.style.color = "#99B4FF";
			/*alert(item.textContent);*/
			var product = item.textContent;
			
			price = parseInt(product.replace(/[^0-9]/g,''));
			
			menu = product.substring(0, product.indexOf(price));
		}
	}
	
	//#####  2. 확인 버튼 클릭시 선택한 TD의 색을 다시 흰색으로
	document.getElementById('btn').onclick = function(){
		var ct = document.getElementById('content');
		var count = document.getElementById('count').value;
		var subTotal = price*count;
		content += menu + " * " + count + " = " + (subTotal) + '<br/>';
		ct.innerHTML = content;
		total.push(subTotal);
		getTotal();
		colorBack();
	}
	
	function colorBack(){
		for(var i = 1; i < 7; i++){
			var item = document.getElementById('menu' + i);
			item.style.background = "#FFF";
			item.style.color = "#000";
		}
	}
	//#####  3. 값 계산하여 총합 구하기 - 각각 TD 클릭시 배열에 저장하였다가 계산
	function getTotal(){
		var sum = 0;
		for(var i in total){
			sum += total[i];
		}
		document.getElementById('total').value = sum;
	}
}