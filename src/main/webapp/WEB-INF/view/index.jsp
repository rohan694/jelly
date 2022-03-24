<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" type="text/css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="../resources/static/index.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
       init();
   });
</script>
</head>
<body>
    <div style="margin: auto;width: 70%;padding: 10px;margin-top: 10%;">
        <input type="text" onkeyup="init()" style="margin-right: 30px" id="tournamentName" placeholder="Tournament Name">
        <input type="text" onkeyup="init()" style="margin-right: 30px" id="tournamentYear" placeholder="Tournament Year">
        <select id="type" onchange="init()">
            <option value="player">Player Names</option>
            <option value="match">Matches</option>
            <option value="venue">Venues</option>
        </select>
        <br/>
        <div id= "venue" style="margin: auto;width: 100%;border: 1px solid black;padding: 10px;margin-top: 10px;">
            <table id="venueList" class="display" style="width: 100%">
                <thead>
                    <tr>
                        <th>Sr No.</th>
                        <th>Venue</th>
                    </tr>
                </thead>
            </table>
        </div>
        <div id= "player" style="margin: auto;width: 100%;border: 1px solid black;padding: 10px;margin-top: 10px; display: none">
            <table id="playerList" class="display" style="width: 100%">
                <thead>
                <tr>
                    <th>Sr No.</th>
                    <th>Player Name</th>
                    <th>Team</th>
                </tr>
                </thead>
            </table>
        </div>
        <div id= "match" style="margin: auto;width: 100%;border: 1px solid black;padding: 10px;margin-top: 10px;display: none">
            <table id="matchList" class="display" style="width: 100%">
                <thead>
                <tr>
                    <th>Sr No.</th>
                    <th>Match Name</th>
                    <th>Team 1</th>
                    <th>Team 2</th>
                    <th>Venue</th>
                    <th>Date (Time Code)</th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
</body>
</html>