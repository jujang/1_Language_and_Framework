
//추첨 번호 저장
var lottery_group = [];
var lottery_number = {0:[], 1:[], 2:[], 3:[], 4:[], 5:[], 6:[], 7:[], 8:[], 9:[]};
var case_name = ['1st game: ', '2nd game: ', '3rd game: ', '4th game: ', '5th game: ', '6th game: ', '7th game: ', '8th game: ', '9th game: ', '10th game: '];

//로또 모드 추첨
function lotto(game_number) {

}
//연금 복권 모드 추첨
function pension_lottery(game_number) {
    for(var i = 0; i < game_number; i++){
        while(1){
            lottery_group[i] = Math.floor(Math.random()*5)+1; //1~6까지 정수 생성 가능
            if(lottery_group[i] != 6) { //6이 안 나오면 넘어가고 6이 나오면 랜덤값 생성 재수행
                break;
            }
        }
        for(var ii = 0; ii < 6; ii++){
            var temp;
            while(1) {
                var temp = Math.floor(Math.random()*10); //0~10까지 정수 생성 가능
                if(temp != 10) { // 10이 안 나오면 넘어가고 10이 나오면 랜덤값 생성 재수행
                    break;
                }
            }
            lottery_number[i].push(temp);
        }
    }
}


var exit = 'n';
while((exit == 'n') || (exit == 'N')) {
    //모드 입력
    var retry = 1;
    while (retry){
        var mode = prompt('복권 추첨 프로그램입니다. \n 원하는 모드를 입력해주세요 (1.로또, 2.연금복권)');
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
                if(mode == 1) {
                    //로또 모드~
                    alert('로또 모드 진행합니다~');

                }
                if(mode ==2) {
                    //연금 복권 모드~
                    alert('연금 복권 모드 진행합니다~');
                    pension_lottery(game_number);
                    var str = '';
                    for(var j=0; j<game_number; j++){
                        str += case_name[j];
                        str += lottery_group[j]+'조 ';
                        for(var jj=0; jj<6; jj++){
                            str += lottery_number[j][jj]+' ';
                        }
                        str += '\n';
                    }
                    alert(str);      
                }
            }
        }
        exit = 'Y';
    }

    //종료 안내문
    if (exit == 'Y' || exit == 'y') {
        alert('복권 추첨 프로그램을 종료합니다');
        continue;        
    }
}