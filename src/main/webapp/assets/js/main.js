const baseAjaxUrl = "";
const username = 'hawkeye'
const password = 'undY11r7el'
const ajaxHeaders = {
    'Version': 1,
    'Content-Type': 'application/json',
}
const tournameListDropdown = document.getElementById('tournamentList')
tournameListDropdown.innerHTML = ''

const populateTournamentList =() => {
    $.ajax({
        type: "POST",
        url: baseAjaxUrl+"/data/getTournamentList",
        username: username,
        password: password,
        headers: ajaxHeaders,
        beforeSend: function() {
            tournameListDropdown.append(`<option selected>Select a tournament</option>`)
        },    
        success: function (result, status, xhr) {
            tournameListDropdown.innerHTML = ''
            result.forEach(element => {
                const toAppend = `<option value="${element.tournamentName}">${element.tournamentName}</option>`
                tournameListDropdown.innerHTML += toAppend
            });
        },
        error: function (xhr, status, error) {
            
            // pElem.innerHTML = xhr.responseJSON.message
            // alert("Result: " + status + " " + error + " " + xhr.status + " " + xhr.statusText)
        },
        complete: function() {
            init()
        }
    });   
}

function init() {
    if($('#outputType option:selected').val() === 'venue'){
        $('#venue').show();
        $('#player').hide();
        $('#match').hide();
        $("#venueList").dataTable().fnDestroy();
        $('#venueList').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": baseAjaxUrl+"/data/getDataByType",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    var data = $.extend( {}, d, {
                        "type": $('#outputType option:selected').val(),
                        "tournamentName":$('#tournamentList option:selected').val(),
                        "tournamentYear":$('#tournamentYear').val(),
                    } );
                    console.log(data);
                    return JSON.stringify(data);
                }
            },
            "columns": [
                {"data": "srNo", "width": "20%",orderable: false},
                {"data": "venue", "width": "20%"},
            ]
        });
    }else if($('#outputType option:selected').val() === 'player') {
        $('#venue').hide();
        $('#player').show();
        $('#match').hide();

        $("#playerList").dataTable().fnDestroy();
        $('#playerList').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": baseAjaxUrl+"/data/getDataByType",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    var data = $.extend( {}, d, {
                        "type": $('#outputType option:selected').val(),
                        "tournamentName":$('#tournamentList option:selected').val(),
                        "tournamentYear":$('#tournamentYear').val(),
                    } );
                    return JSON.stringify(data);
                }
            },
            "columns": [
                {"data": "srNo", "width": "33%" ,orderable: false},
                {"data": "playerName", "width": "33%"},
                {"data": "team", "width": "33%"},
            ]
        });
    }else if($('#outputType option:selected').val() === 'match') {
        $('#venue').hide();
        $('#player').hide();
        $('#match').show();

        $("#matchList").dataTable().fnDestroy();
        $('#matchList').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": baseAjaxUrl+"/data/getDataByType",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    var data = $.extend( {}, d, {
                        "type": $('#outputType option:selected').val(),
                        "tournamentName":$('#tournamentList option:selected').val(),
                        "tournamentYear":$('#tournamentYear').val(),
                    } );
                    return JSON.stringify(data);
                }
            },
            "columns": [
                {"data": "srNo", "width": "20%",orderable: false},
                {"data": "matchName", "width": "20%"},
                {"data": "team1", "width": "20%"},
                {"data": "team2", "width": "20%"},
                {"data": "venue", "width": "20%"},
                {"data": "timeCode", "width": "20%"},
            ]
        });
    }
}


window.addEventListener('load', populateTournamentList)