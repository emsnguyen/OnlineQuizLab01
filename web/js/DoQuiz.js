var timeLeft = 10;
var timer = document.getElementById("timer");
timer.value = timeLeft;
var result = document.getElementById("result");
result.value = "";
var options = document.querySelectorAll(".options");
function countdown() {
    var x = setInterval(function() {
        timer.innerHTML = timeLeft;
        timeLeft--;
        setResult();
        if (timeLeft < 0) {
            clearInterval(x);
            timer.innerHTML = "Time out";
        }
        console.log('time left: ' + timeLeft);
    }, 1000);
}
function setResult() {
    for (var i = 0; i< options.length; i++) {
        if (options[i].checked) {
            result.value = options[i].value;
        }
    }
    if (result.value === "") {
        result.value = "timeout";
    }
    console.log(result);
}