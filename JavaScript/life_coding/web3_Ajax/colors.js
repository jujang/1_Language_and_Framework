var Links = {
    setColor:function(color) {
        var alist = document.querySelectorAll('a');
        var i = 0;
        while(i < alist.length) {
            console.log(alist[i]);
            alist[i].style.color = color;
            i = i + 1;
        }
    }
}
var Body = {
    setColor:function(color) {
        document.querySelector('body').style.color = color;    
    },
    setBackgroundColor:function(color) {
        document.querySelector('body').style.backgroundColor = color;    
    }
}

function nightDayHandler(self) {
    var target = document.querySelector('body');
    if(self.value === 'night 모드로 변경') {
        Body.setBackgroundColor('black');
        Body.setColor('white');
        self.value = 'day 모드로 변경';
        Links.setColor('powderblue');
    } else {
        Body.setBackgroundColor('white');
        Body.setColor('black');
        self.value = 'night 모드로 변경';
        Links.setColor('blue');
    }
}