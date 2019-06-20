$(function(){
	// #######[1] 날짜 출력 ########
	// 현재 날짜 가져오기
	var today = new Date();			// 현재 날짜
	var yyyy = today.getFullYear();	// 현재 년도
	var mm = today.getMonth()+1;	// 현재 월
	var dd = today.getDate();		// 현재 일
	// 가져온 날짜를 text에 붙히기
	$('.year').text(yyyy)
	$('.month').text(mm)
	$('.date').text(dd)
	
	// ########[2] 검색어폼 ########
	// 갖다대면 없어지고 마우스 때면 나타나게 한다.
	$('#keyword').mouseover(function(){
		$('#keyword').css('background-position', '0 -500px');
	}).mouseout(function(){
		$('#keyword').css('background-position', '0 0');
	});
	
	// ########[3] 탭메뉴 ########
	// 탭메뉴 지점
	var anchors = $('#tabmenu').find('dt');
	// 탭메뉴 지점의 내용
	var panelDivs = $('#tabmenu').find('dd');
	// 더보기
	var seeMore = panelDivs.children('p');
	
	// 탭메뉴 지점 첫번째 이름에 addClass를 통해 'on'붙혀준다.
	$('#tabmenu').find('dt:first').addClass('on');
	
	// 마지막지점 탭메뉴 지점에 on을 찾는다.
	var lastAnchors = anchors.filter('.on');
	// 마지막 지점의 내용의 다음꺼를 찾아준다.
	var lastPanelDivs = lastAnchors.next();

	var img_over = lastAnchors.find('img:first').attr('src');   // *_over
	var img_out = img_over.replace('_over', '_out');   // *_out
	
	// 더보기가 눌려졋을 때 
	seeMore.click(function(){
		// 공지사항 더보기
		if($(this).is(seeMore.eq(0))){
			window.location.href = "http://www.easyspub.co.kr/12_Menu/BoardList/C200/PUB";
		// 질문과답변 더보기
		}else if($(this).is(seeMore.eq(1))){
			window.location.href = "http://www.easyspub.co.kr/40_Menu/QnaWrite/PUB";
		// 저자문의 더보기
		}else if($(this).is(seeMore.eq(2))){
			window.location.href = "http://www.easyspub.co.kr/20_Menu/BookList/PUB";
		}
	});
	
	// 지점을 클릭했을 때
	anchors.click(function(){
		// 마지막 지점의 removeClass를 통해 on을 지워준다.
		lastAnchors.removeClass('on');
		// 마지막 지점의 내용을 숨긴다.
		lastPanelDivs.hide();
		lastAnchors.find('img').attr('src', img_out);   // *_out 기존것.
		
		// 현재 지점에 addClass에 on을 붙혀준다.
		$(this).addClass('on');
		
		lastAnchors = $(this);
		
		img_out = lastAnchors.find('img').attr('src');   // *_out 바뀔것 원래.
		img_over = img_out.replace('_out', '_over');   // *_over 바뀔것
		lastAnchors.find('img').attr('src', img_over);
		lastPanelDivs = lastAnchors.next();
		lastPanelDivs.show();
	});

	// ########[4] 베스트북 이미지 슬라이더(bxSlider 이용) ########
    // 슬라이더 설정
    var slider = $('#best_bg > ul').bxSlider({
       minSlides : 5,    // 최소 노출 갯수
       maxSlides : 5,    // 최대 노출 갯수
       slideMargin : 10,    // 슬라이드의 간격
       slideWidth : 150,    // 슬라이드의 너비
       auto : true,    // 자동 실행 여부
       speed : 500,    // 이동 속도 설정
       moveSlides : 1,    // 슬라이드 이동 갯수
       pager: false    // 현재 위치 페이징 표시 여부 설정
    });
    // 이전버튼을 클릭하면 이전슬라이드로 전환
    $('.prev_btn').on('click', function(){
       slider.goToPrevSlide();    // 이전 슬라이드 배너로 이동
    });
    // 다음버튼을 클릭하면 다음슬라이드로 전환
    $('.next_btn').on('click', function(){
       slider.goToNextSlide();    // 다음 슬라이드 배너로 이동
    });
    // 슬라이더 왼쪽에 공간을 줌
    slider.css( 'margin-left', '10px' );
    
	// ########[5] 로그인 ########
	// 로그인  클릭
	$('.login_wrap>a').click(function(){
		// 폼의 animate() 이용하여 top 위치를 20px로 지정
		$('#login_f').animate({
			'top' : '20px'
		});
	});
	// 폼의 닫기 클릭 
	$('.login_close_btn>a').click(function(){
		// 폼의 animate() 이용하여 top 위치를 -500px로 지정
		$('#login_f').animate({
			'top' : '-500px'
		});
	});
	
	// ########[6] 전체메뉴 보이기 ########
	// 전체 메뉴 클릭
	$('#total_btn>a').click(function(){
		// 전체 메뉴 보여주기
		$('#total_menu').show(500);
	});
	// 전체 메뉴 닫기 클릭
	$('#total_close>a').click(function(){
		// 전체 메뉴 닫아주기
		$('#total_menu').hide();
	});
	
	// #######[7] 팝배너 ########
	// 팝 배너 설정
	var popBanner = $('#roll_banner_wrap>dl').bxSlider({
	       minSlides : 1,	// 최소 노출 갯수
	       auto : true,		// 자동 실행 여부
	       speed : 500,		// 이동 속도 설정
	       moveSlides : 1	// 슬라이드 이동 갯수		
	});
	
	// 버튼을 클릭 했을 때 
	$('#roll_banner_wrap>dt').click(function(){
		alert('ok');
//		popBanner.goToSlide();
	});

	// 재생버튼을 클릭할 떼
	$('.playBtn').on('click', function(){
		popBanner.startAuto();    // 슬라이드 재생
	});
	// 정지버튼을 클릭할 때
	$('.stopBtn').on('click', function(){
		popBanner.stopAuto();    // 슬라이드 정지
	});	
	
});