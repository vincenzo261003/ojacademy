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
                <button type="button" class="btn btn-warning" onclick="modifica('${item.codice}')">Modifica</button>
            </td>
            <td>
                <button type="button" class="btn btn-danger" onclick="elimina('${item.codice}')">Elimina</button>
            </td>
        </tr>
        `;
    }

    $("#corpo-tabella").html(corpoTabella);
}

function rimuoviCaffe(cod) {
    $.ajax(
        {
            url: "http://localhost:8080/caffe/c/" + cod + "?azione=-",
            type: "PATCH",
            success: function(res){
                if (res)
                    stampa()
                else
                    alert("Errore")
                
            },
            error: function(err){
                console.log(err)
            }
        }
    )
}

function aggiungiCaffe(cod) {
    $.ajax(
        {
            url: "http://localhost:8080/caffe/c/" + cod + "?azione=add",
            type: "PATCH",
            success: function(res){
                if (res)
                    stampa()
                else
                    alert("Errore")
                
            },
            error: function(err){
                console.log(err)
            }
        }
    )
}

function rimuoviMolt(cod) {
    $.ajax(
        {
            url: "http://localhost:8080/caffe/m/" + cod + "?azione=-",
            type: "PATCH",
            success: function(res){
                if (res)
                    stampa()
                else
                    alert("Errore")
                
            },
            error: function(err){
                console.log(err)
            }
        }
    )
}

function aggiungiMolt(cod) {
    $.ajax(
        {
            url: "http://localhost:8080/caffe/m/" + cod + "?azione=add",
            type: "PATCH",
            success: function(res){
                if (res)
                    stampa()
                else
                    alert("Errore")
                
            },
            error: function(err){
                console.log(err)
            }
        }
    )
}

function inserisci(){
    let nome = $("#inputNome").val();
    let cognome = $("#inputCognome").val();
    let codice = $("#inputCodice").val();

    $.ajax({
        url: "http://localhost:8080/caffe",
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
            $("#exampleModal").modal("hide");
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
            url: "http://localhost:8080/caffe/" + id,
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
            url: "http://localhost:8080/caffe/" + id,
            type: "GET",
            success: function(res){
                $("#exampleModal").modal("show");
                $("#exampleModalLabel").html("Modifica studente");

                $("#inputCodice").val(res.codice);
                $("#inputCodice").prop("readonly", true);
                $("#inputNome").val(res.nome);
                $("#inputCognome").val(res.cognome);

                $("#pulsanteSalva").click(
                    ()=>{
                        effettuaModifica();
                    }
                );
                
            },
            error: function(err){
                console.log(err)
            }
        }
    )
}

function effettuaModifica() {

    $("#pulsanteSalva").click(
        ()=>{
            inserisci();
        }
    );

    let nome = $("#inputNome").val();
    let cognome = $("#inputCognome").val();
    let codice = $("#inputCodice").val();

    $.ajax({
        url: "http://localhost:8080/caffe/" + codice,
        type: "PUT",
        data: JSON.stringify({
            nome,
            cognome,
            codice
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

        $("#bottoneAggiungi").click(
            ()=>{
                $("#inputCodice").prop("readonly", false);
                $("#inputNome").val("");
                $("#inputCognome").val("");
                $("#inputCodice").val("");
                $("#exampleModalLabel").html("Aggiungi studente");
            }
        );

    }
)