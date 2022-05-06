var cols = 100;
var rows = 50;
var rr = ""
for (let r = 0; r < rows; r++) {
    var inn = "<div class = 'cell rowNumber' >" + r + "</div><input class= 'cell Name' value = 'NAME " + r + "' id = '" + r + "aN" + "'>"
    if (r == 0) {
        inn = "<div class = 'cell colNumber init' >Student Name</div>";
    }
    
    for (let c = 0; c < cols; c++) {
        if (r == 0) {
            inn += "<div class = 'cell colNumber'>" + c + "</div>";
        }
        else {
            var temp = r + "a" + c
            inn += "<input class= 'cell' value = " + temp + " id = '" + temp + "'>"
        }
        
    }
    rr += "<div class = 'row'>" + inn + "</div>"
}

document.getElementById("main").innerHTML = rr;


for (let i = 0; i < 5; i++) {
    document.getElementById("cls").innerHTML += "<div class = 'classCard></div>'";
}