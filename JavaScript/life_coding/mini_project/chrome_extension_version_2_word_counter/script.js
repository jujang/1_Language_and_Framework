document.querySelector('#user').addEventListener('change', function(){
    let user = document.querySelector('#user').value;

    chrome.tabs.executeScript({
        code:'document.querySelector("body").innerText'
    }, function(result) {
        user = user.toString();
        let bodyText = result[0].toString().toLowerCase();

        // let texts = bodyText.split(/ |\n|\t|\/|\(|\)|\[|\]|\<|\>|\{|\}|\\|\||\,|\.|\_|\…|\"|\=|\+|\^|\#|\★|\「|\」|\▲|\▼|\▶|\△|\▽|\*|\`|\'|\‘|\’|\“|\”|\!|\?|▌|ー|—|°|·|・|~|:|;|：|›|\ /);
        let texts = bodyText.split(' ').length;

        let myTextNum = 0;    
        let numberOfMatched = bodyText.match(new RegExp('(' + user + ')', 'gi'));
        if(numberOfMatched === null ) {
            myTextNum = 0;
        } else {
            myTextNum = numberOfMatched.length;
        }
        
        let text = (`${myTextNum} / ${texts} (${(Math.round((myTextNum/texts)*1000)/10)}%)`);
        document.querySelector('#result').innerText = text;
    });
});


