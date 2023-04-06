function popolaTabella(elenco){
    let corpoTabella = "";
    for(let [idx, item] of elenco.entries()){
        corpoTabella += `
        <tr>
            <td>${item.nominativo}</td>
            <td>${item.matricola}</td>
            <td>
                <button type="button" class="btn btn-warning" onclick="modifica('${item.id}')">Modifica</button>
                <button type="button" class="btn btn-danger" onclick="elimina('${item.id}')">Elimina</button>
            </td>
        </tr>
        `;
    }

    $("#corpo-tabella").html(corpoTabella);
}

function inserisci(){
    let nomi = $("#inputNominativo").val();
    let matr = $("#inputMatricola").val();

    $.ajax({
        url: "http://localhost:8080/studente",
        type: "POST",
        data: JSON.stringify({
            nominativo: nomi,
            matricola: matr
        }),
        contentType: "application/json",
        dataType: "JSON", 
        success: function(res){
            stampa();
        },
        error: function(err){
            console.log(err);
        }
    });
}

function stampa(){

    $.ajax(
        {
            url: "http://localhost:8080/studente/all",
            type: "GET",
            success: function(res){
                popolaTabella(res);
            },
            error: function(err){
                console.log(err)
            }
        }
    )

}

function elimina(id){
    $.ajax(
        {
            url: "http://localhost:8080/studente/" + id,
            type: "DELETE",
            success: function(res){
                stampa();
            },
            error: function(err){
                console.log(err)
            }
        }
    )
}

function modifica(id){
    $.ajax(
        {
            url: "http://localhost:8080/studente/" + id,
            type: "GET",
            success: function(res){
                $("#updateNominativo").val(res.nominativo);
                $("#updateMatricola").val(res.matricola);
                $("#pulsanteUpdate").data("id", res.id);

                $("#exampleModal").modal("show");
            },
            error: function(err){
                console.log(err)
            }
        }
    )
}

function effettuaModifica(varThis) {
    let id = $(varThis).data("id");
    let nominativo = $("#updateNominativo").val();
    let matricola = $("#updateMatricola").val();

    $.ajax({
        url: "http://localhost:8080/studente/" + id,
        type: "PUT",
        data: JSON.stringify({
            nominativo,
            matricola
        }),
        contentType: "application/json",
        dataType: "JSON", 
        success: function(res){
            $("#exampleModal").modal("hide");
            stampa();
        },
        error: function(err){
            console.log(err);
        }
    });
}

$(document).ready(
    function () {
        stampa();

        $("#pulsanteSalva").click(
            ()=>{
                inserisci();
            }
        );

    }
)