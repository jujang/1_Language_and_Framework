// 현재 페이지에서 text 가져오기
var text = document.getElementsByTagName('body')[0].innerText;

// 영문의 경우, 모두 소문자로 변환하기
text = text.toLowerCase();

// 쓸모없는 텍스트 필터링하기(1)
var texts = text.split(/ |\n|\t|\/|\(|\)|\[|\]|\<|\>|\{|\}|\\|\||\,|\.|\_|\…|\"|\=|\+|\^|\#|\★|\「|\」|\▲|\▼|\▶|\△|\▽|\*|\`|\'|\‘|\’|\“|\”|\!|\?|▌|ー|°|·|・|~|:|;|：| /);

// 객체에서 출현빈도 계산하기
var text_obj = {};
for(i of texts){
    if(text_obj[i] == undefined ) {
        text_obj[i] = 1;
    } else {
        text_obj[i] += 1;
    }
}

// 정렬을 위해 배열에 옮겨 담기
var text_arr = [];
for (ii in text_obj){
    text_arr.push([ii, text_obj[ii]]);
}

//필요한 것 : 텍스트 필터링하기(2) - 공백과 '(쉼표)
text_arr = text_arr.filter(function(item){
    return (item[0] !=='') && (item[0] !=="'") && (item[0] !=="-") && (item[0] !=="–") && (item[0] !=="·") && (item[0] !=="&");
});

// 내림차순으로 정렬하기
text_arr.sort(function(a, b) {
    return b[1] - a[1];
});

// 정렬된 값 alert창으로 출력하기
var str = '';
for(iii of text_arr){
    // console.log(iii[0]);
    str += iii[0]+' : '+iii[1]+'\n';
}
alert(str);