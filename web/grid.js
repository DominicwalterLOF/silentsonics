var cols = 30;
var rows = 100;
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
d("main").innerHTML = rr;

for (let i = 0; i < 5; i++) {
    d("cls").innerHTML += "<div class = 'classCard></div>'";
}
function toggleOverlay() {
    var o = d("overlay").style.display;
    if (o == "none") {
        d("overlay").style.display = "block";
    }
    else {
        d("overlay").style.display = "none";
    }
}

function d(e) {
    return document.getElementById(e);
}

function returnToast(toastMessage, bcolor, tcounter) {
    tm = '<div class="tomsg glassFrost" id = "modalContainer' + tcounter;
    tm += '"><p style="color: white;">Server ::::</p><div class="whiteLine" style="border-color: white; height: 1px; width: 30%; margin:4px; margin-left: 0px;"></div><p id = "toastCont">';
    tm += toastMessage + '</p></div>';
    return tm;
}

var toastCount = 0;

function showToast(toastMessage, bbcolor, time) {
    if (true) {
        if (bbcolor == 1) {
            var xc = "greenyellow";
        }
        else if (bbcolor == 2) {
            var xc = "red";
        }
        toastCount = toastCount + 1;
        toastRAW = returnToast(toastMessage, xc, toastCount);
        renderToast(toastRAW, toastCount, time);

    }


}

function renderToast(toastRAW, tcnt, timeTo) {
    d("mcm").innerHTML += toastRAW;
    setTimeout(() => {
        d("modalContainer" + tcnt).style.display = "none";
    }, timeTo * 1000)
}


function fadeFrost() {
    let box = document.getElementById('frostOverlay');
    if (box.classList.contains('hidden')) {
        box.classList.remove('hidden');
        setTimeout(function () {
            box.classList.remove('visuallyhidden');
        }, 20);
    } else {
        box.classList.add('visuallyhidden');
        box.addEventListener('transitionend', function (e) {
            box.classList.add('hidden');
        }, {
            capture: false,
            once: true,
            passive: false
        });
    }

}
