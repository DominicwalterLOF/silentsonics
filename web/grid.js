var cols = 100;
var rows = 100;
var rr = ""
for (let r = 0; r < rows; r++) {
    var inn = ""
    for (let c = 0; c < cols; c++) {
        var temp = r + "a" + c
        inn += "<input class= 'cell' value = " + temp + " id = '" + r + "a" + c + "'></input>"
    }
    rr += "<div class = 'row'>" + inn + "</div>"
}

document.getElementById("main").innerHTML = rr;