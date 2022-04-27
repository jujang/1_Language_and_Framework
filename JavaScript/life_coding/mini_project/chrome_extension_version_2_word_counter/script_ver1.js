document.querySelector('#user').addEventListener('change', function(){
    let user = document.querySelector('#user').value;

    chrome.tabs.executeScript({
        code:'document.querySelector("body").innerText'
    }, function(result) {
        let bodyText = result[0];

        let bodyNum = bodyText.split(' ').length;

        let myNum = bodyText.match(new RegExp('\\b(' + user + ')\\b', 'gi')).length;

        let per = myNum / bodyNum * 100;
        per = per.toFixed(1);
        document.querySelector('#result').innerText = myNum + '/' + bodyNum + '(' + (per) + '%)';

    });
});


