var times = document.querySelectorAll(".style-scope ytd-thumbnail-overlay-time-status-renderer span");
var var_h = 0;
var var_m = 0;
var var_s = 0;
for(var i of times){
    var text = i.innerText;
    var time = text.split(':');
    if(time[2] != undefined) {
        var_h += parseInt(time[0]);
        var_m += parseInt(time[1]);
        var_s += parseInt(time[2]);
    }
    else {
    var_m += parseInt(time[0]);
    var_s += parseInt(time[1]);
    }
}
if(var_s >= 60) {
    var_m += Math.floor(var_s/60);
    var_s = var_s%60;
}
if(var_m >= 60) {
    var_h += Math.floor(var_m/60);
    var_m = var_m%60;
}
if(var_h > 0) {
    console.log(var_h+'h '+var_m+'m '+var_s+'s');
}
else if(var_m > 0) {
    console.log(var_m+'m '+var_s+'s');
}
else {
    console.log(var_s+'s');
}