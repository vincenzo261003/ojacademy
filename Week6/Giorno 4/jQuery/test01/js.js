$(document).ready(
    function () {

        $("#res").hide();
        
        $("#bottoneSalva").click(
            ()=>{
                let nome = $("#inputNome").val();
                let cogn = $("#inputCognome").val();
                let matr = $("#inputMatricola").val();

                $("#res").html(`${nome} ${cogn} ${matr}`);

                $("#res").show(500);
            }
        )

    }
)