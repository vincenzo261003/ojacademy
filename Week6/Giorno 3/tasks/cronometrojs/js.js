let sec = 0;
let min = 0;
let ore = 0;
let intervallo;
let avviato = false;

function play(){
    if (!avviato){
        avviato = true;
        intervallo = setInterval(()=>{
            sec++;
            if (sec == 60) {
                min++;
                sec = 0;

                if (min == 60){
                    ore++;
                    min = 0;
                }
            }

            document.getElementById("ore").innerText = ore.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
            document.getElementById("min").innerText = min.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});
            document.getElementById("sec").innerText = sec.toLocaleString('en-US', {minimumIntegerDigits: 2, useGrouping:false});

        }, 1);
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