document.querySelector('#user').addEventListener('change', function(){
    let user = document.querySelector('#user').value;

    chrome.tabs.executeScript({
        code:'document.querySelector("body").innerText'
    }, function(result) {
        bodyText = result.toString().toLowerCase();
    
        let texts = bodyText.split(/ |\n|\t|\/|\(|\)|\[|\]|\<|\>|\{|\}|\\|\||\,|\.|\_|\…|\"|\=|\+|\^|\#|\★|\「|\」|\▲|\▼|\▶|\△|\▽|\*|\`|\'|\‘|\’|\“|\”|\!|\?|▌|ー|—|°|·|・|~|:|;|：|›|\ /);
    
        let text_obj = {};
        for(let i of texts) {
            if(text_obj[i] == undefined ) {
                text_obj[i] = 1;
            } else {
                text_obj[i] += 1;
            } 
        }
    
        let text_arr = [];
        for (let ii in text_obj){
            text_arr.push([ii, text_obj[ii]]);
        }
    
        text_arr = text_arr.filter(function(item){
            return (item[0] !=='') && (item[0] !=='\ ') && (item[0] !=="'") && (item[0] !=="-") && (item[0] !=="–") && (item[0] !=="·") && (item[0] !=="&");
        });
    
        text_arr.sort(function(a, b) {
            return b[1] - a[1];
        });
    
        // let str = '';
        let myText = user; // 내가 원하는 입력받는 텍스트
        // let myText = user;
        let myTextNum = 0;
        let totalTextNum = 0;
        for(let iii of text_arr){
            // console.log(iii[0], iii[1]);
            // str += iii[0]+' : '+iii[1]+'\n';
            if(myText == iii[0]) {
                myTextNum += iii[1];    
            }
            totalTextNum += iii[1];
        }
        let text = (`${myTextNum} / ${totalTextNum} (${(Math.round((myTextNum/totalTextNum)*1000)/1000)}%)`);
        document.querySelector('#result').innerText = text;
    });
});


