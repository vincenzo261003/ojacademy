function popolaTabella(elenco){
    let corpoTabella = "";
    for(let [idx, item] of elenco.entries()){
        corpoTabella += `
        <tr>
            <td>${item.codice}</td>
            <td>${item.nome}</td>
            <td>${item.cognome}</td>
            <td>
                <button type="button" class="btn btn-danger mr-3" onclick="rimuoviCaffe('${item.codice}')">-</button>
                    ${item.caffe}
                <button type="button" class="btn btn-success ml-3" onclick="aggiungiCaffe('${item.codice}')">+</button>
            </td>
            <td>
                <button type="button" class="btn btn-danger mr-3" onclick="rimuoviMolt('${item.codice}')">-</button>
                    ${item.moltiplicatori}
                <button type="button" class="btn btn-success ml-3" onclick="aggiungiMolt('${item.codice}')">+</button>
            </td>
            <td>
                <button type="button" class="btn btn-warning" onclick="modifica('${item.id}')">Modifica</button>
            </td>
            <td>
                <button type="button" class="btn btn-danger" onclick="elimina('${item.id}')">Elimina</button>
            </td>
        </tr>
        `;
    }

    $("#corpo-tabella").html(corpoTabella);
}

function inserisci(){
    let nome = $("#inputNome").val();
    let cognome = $("#inputCognome").val();
    let codice = $("#inputCodice").val();

    $.ajax({
        url: "http://localhost:8080/studente",
        type: "POST",
        data: JSON.stringify({
            nome,
            cognome,
            codice
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
            url: "http://localhost:8080/caffe/all",
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