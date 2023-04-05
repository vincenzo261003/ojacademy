let sec = 0;
let min = 0;
let ore = 0;
let intervallo;
let avviato = false;

function play(){
    if (!avviato){
        if (sec == min == ore == 0){
            sec = document.getElementById("inputSec").value;
            min = document.getElementById("inputMin").value;
            ore = document.getElementById("inputOre").value;
        }

        avviato = true;
        intervallo = setInterval(()=>{
            sec--;

            if (sec < 0) {
                min--;
                sec = 59;

                if (min < 0){
                    ore--;
                    min = 59;

                    if (ore < 0){
                        reset();
                    }
                }
            }

            document.getElementById("ore").innerText = ore.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
            document.getElementById("min").innerText = min.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
            document.getElementById("sec").innerText = sec.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});

        }, 10);
    }
    
}

function pause(){
    clearInterval(intervallo);
    avviato = false;
}

function reset(){
    avviato = false;
    sec = min = ore = 0;
    clearInterval(intervallo);
    document.getElementById("ore").innerText = ore.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
    document.getElementById("min").innerText = min.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
    document.getElementById("sec").innerText = sec.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});

}