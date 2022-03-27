
//추첨 번호 저장
var lottery_group = [];
var lottery_number = {0:[], 1:[], 2:[], 3:[], 4:[], 5:[], 6:[], 7:[], 8:[], 9:[]};
var case_name = ['1st game: ', '2nd game: ', '3rd game: ', '4th game: ', '5th game: ', '6th game: ', '7th game: ', '8th game: ', '9th game: ', '10th game: '];

//로또 모드 추첨
function lotto(game_number) {
    for(var k = 0; k < game_number; k++){
        for(var kk = 0; kk < 6; kk++){
            var temp_L;
            while(1) {
                temp_L = Math.floor(Math.random()*45)+1; //1~46까지의 범위에서 정수 생성
                var flag = 0;
                if(temp_L == 46) { // 46이 나오면 flag: 1
                    flag = 1;
                }
                for(var x = 0; x < lottery_number[k].length; x++){ //만약 나온 랜덤값을 이미 추첨받은 번호라면 flag:1
                    if(temp_L == lottery_number[k][x]){
                        flag = 1;
                    }
                }
                if(flag == 0){ //위 경우들에 해당하지 않는다면 반복 멈추기
                    break;
                }

            }
            lottery_number[k].push(temp_L); //추첨된 번호 배열에 넣기
        }
        lottery_number[k].sort(function(a,b){ //추첨된 번호 오름차순으로 정렬
            return a - b;
        });
    }
}
//연금 복권 모드 추첨
function pension_lottery(game_number) {
    for(var i = 0; i < game_number; i++){
        while(1){
            lottery_group[i] = Math.floor(Math.random()*5)+1; //1~6까지의 범위에서 정수 생성
            if(lottery_group[i] != 6) { //6이 안 나오면 넘어가고 6이 나오면 랜덤 번호 생성 재수행
                break;
            }
        }
        for(var ii = 0; ii < 6; ii++){
            var temp;
            while(1) {
                temp = Math.floor(Math.random()*10); //0~10까지 정수 생성 가능
                if(temp != 10) { // 10이 안 나오면 넘어가고 10이 나오면 랜덤 번호 생성 재수행
                    break;
                }
            }
            lottery_number[i].push(temp);
        }
    }
}


var exit = 'N';
while(exit == 'N') {
    //모드 입력
    var retry = 1;
    while (retry){
        var mode = prompt('복권 추첨 프로그램입니다. \n원하는 모드를 입력해주세요 (1.로또, 2.연금복권)');
        if (mode == null) {
            retry = 0;
            exit = 'Y';
        } else if ((mode != 1) && (mode != 2)) {
            alert('잘못 입력하였습니다');
        }  else {
            retry = 0;
        }
    }

    if (exit != 'Y') {
        var retry_game_number = 1;
        while(retry_game_number) {
            var game_number = prompt('희망하는 게임수를 입력해주세요 (1~10)');
            if (game_number == null) {
                exit = 'Y';
                var retry_game_number = 0;
            } else if (!(game_number >= 1 && game_number <= 10)) {
                alert('잘못 입력하였습니다');
            } else {
                retry_game_number = 0;
                
                var str = '';
                //로또 모드~
                if(mode == 1) {
                    lotto(game_number);
                    str += '로또 번호 추첨 결과입니다\n';
                }
                //연금 복권 모드~
                else if(mode ==2) {
                    pension_lottery(game_number);
                    str += '연금복권 번호 추첨 결과입니다\n';
                }

                //추첨값 출력
                for(var j=0; j<game_number; j++){
                    str += case_name[j];
                    if(mode==2){
                        str += lottery_group[j]+'조 ';
                    }
                    for(var jj=0; jj<6; jj++){
                        str += lottery_number[j][jj]+' ';
                    }
                    str += '\n';
                }
                alert(str);

            }
        }
        exit = 'Y';
    }

    //종료 안내문
    if (exit == 'Y') {
        alert('복권 추첨 프로그램을 종료합니다. \n- Programmed by ggojang -');        
    }
}