var arr = []
for(var i = 0; i < 5; i++) {
    arr[i] = function() {
        console.log(i);
    }
}