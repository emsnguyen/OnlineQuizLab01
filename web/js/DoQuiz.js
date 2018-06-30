var timeLeft = 60;
var timer = document.getElementById("timer");
timer.value = timeLeft;
var result = document.getElementById("result");
result.value = "";
var options = document.querySelectorAll(".options");
function countdown() {
    var x = setInterval(function () {
        var y = setInterval(function() {
            setResult();
        },10);
        timer.innerHTML = timeLeft;
        timeLeft--;
        if (timeLeft < 0) {
            clearInterval(x);
            timer.innerHTML = "Time out";
        }
        console.log("result: " + result.value);
    }, 1000);
}
function setResult() {
    result.value = "";
    for (var i = 0; i < options.length; i++) {
        if (options[i].checked) {
            result.value += options[i].value;
        }
    }
    if (result.value === "") {
        result.value = "timeout";
    }
}