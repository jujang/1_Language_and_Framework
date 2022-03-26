var times = document.querySelectorAll('.style-scope ytd-thumbnail-overlay-time-status-renderer span');
var time_h = 0;
var time_m = 0;
var time_s = 0;
for (i of times) {
    var text = i.innerText;
    var splited_t = text.split(':');  
    if(splited_t[2] == undefined) {
        time_m += parseInt(splited_t[0]);
        time_s += parseInt(splited_t[1]);
    } else {
        time_h += parseInt(splited_t[0]);
        time_m += parseInt(splited_t[1]);
        time_s += parseInt(splited_t[2]);
    }
}
if(time_s >= 60) {
    var time_s_over = Math.floor(time_s/60);
    time_s = time_s%60;
    time_m += time_s_over;
}
if(time_m >=60) {
    var time_m_over = Math.floor(time_m/60);
    time_m = time_m%60;
    time_h += time_m_over;
}
if (time_h == 0 && time_m == 0) {
    console.log('Total time: '+time_s+'s');
} else if (time_h == 0) {
    console.log('Total time: '+time_m+'m '+time_s+'s');
} else {
    console.log('Total time: '+time_h+'h '+time_m+'m '+time_s+'s');
}