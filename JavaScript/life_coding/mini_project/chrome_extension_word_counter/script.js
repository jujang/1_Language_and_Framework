// alert('hello');

// 'use strict';
// let bodyText = document.querySelector('body').innerText;
// alert(bodyText);

// chrome.tabs.executeScript({
//     code:'let bodyText = document.querySelector("body").innerText;alert(bodyText);'
// })


// // MV3
// function refresh() {
//     window.location.reload();
// };

// chrome.tabs.query({ active: true, currentWindow: true }, function(tabs) {
//     chrome.scripting.executeScript({
//         target: {tabId: tabs[0].id},
//         function: refresh,
//     });
// });


function qq() {
    let bodyText = document.querySelector('body').innerText;
    alert(bodyText);
}
chrome.tabs.query({ active: true, currentWindow: true }, 
    function(tabs) {
        chrome.scripting.executeScript({
        function: qq
    });
});