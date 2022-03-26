function init() {
    if($('#type option:selected').val() === 'venue'){
        $('#venue').show();
        $('#player').hide();
        $('#match').hide();
        $("#venueList").dataTable().fnDestroy();
        $('#venueList').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "/data/getDataByType",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    var data = $.extend( {}, d, {
                        "type": $('#type option:selected').val(),
                        "tournamentName":$('#tournamentName').val(),
                        "tournamentYear":$('#tournamentYear').val(),
                    } );
                    return JSON.stringify(data);
                }
            },
            "columns": [
                {"data": "srNo", "width": "20%",orderable: false},
                {"data": "venue", "width": "20%"},
            ]
        });
    }else if($('#type option:selected').val() === 'player') {
        $('#venue').hide();
        $('#player').show();
        $('#match').hide();

        $("#playerList").dataTable().fnDestroy();
        $('#playerList').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "/data/getDataByType",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    var data = $.extend( {}, d, {
                        "type": $('#type option:selected').val(),
                        "tournamentName":$('#tournamentName').val(),
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
    }else if($('#type option:selected').val() === 'match') {
        $('#venue').hide();
        $('#player').hide();
        $('#match').show();

        $("#matchList").dataTable().fnDestroy();
        $('#matchList').DataTable({
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "/data/getDataByType",
                "type": "POST",
                "dataType": "json",
                "contentType": "application/json",
                "data": function (d) {
                    var data = $.extend( {}, d, {
                        "type": $('#type option:selected').val(),
                        "tournamentName":$('#tournamentName').val(),
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