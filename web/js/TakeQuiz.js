function setResult() {
    var opts = document.getElementsByClassName("opt");
    var result = document.getElementById("result");
    for (var o in opts) {
        if (o.checked()) {
            result.value = o.value;
        }
    }
}
function submit() {
    document.getElementById("frm1").submit();
}