<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Quickbooks</title>
    <script src="js/jquery-latest.js"></script>
    <script type="text/javascript">
        function qcall() {
        }
        $(document).ready(function () {
            var url = document.URL;
            $('#submit').click(function () {
                $.ajax({
                    type: "POST",
                    url: "https://mindapp-pulpy.rhcloud.com/Quickcall",
                    data: {
                        url: url
                    },
                    success: function (result) {
                        window.location = result;
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        alert("errorstatus: " + xhr.status + " ajaxoptions: " + ajaxOptions + " throwError: " + thrownError);
                    }
                });
            });
            $('#b1').click(function () {
                var id = "1", Arr = [];
                var docid, cdate, ddate, bal, tot, cust;
                $.ajax({
                    type: "POST",
                    url: "https://mindapp-pulpy.rhcloud.com/Quickbook",
                    data: {
                        id: id
                    },
                    success: function result(data) {
                        console.log(data);
                        $('#result').append(data);
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        alert("errorstatus: " + xhr.status + " ajaxoptions: " + ajaxOptions + " throwError: " + thrownError);
                    }
                });
            });
        });
    </script>
    <style>
        body {
            background-color: #0099cc;
        }

        #head {
            font-family: verdana;
            font-weight: bold;
            font-size: 23px;
            color: #FFFFFF;
        }

        input[type="button"], input[type="submit"] {
            color: #0099cc;
            font-size: 20px;
            background-color: #fff;
            font-family: verdana;
            height: 40px;
            border: solid 2px;
            border-color: #fff;
            border-radius: 3px;
            padding: 5px;
        }
    </style>
</head>
<body>
<br>
<br>
<center>
    <div id="head">Get Invoice from QuickBooks via MindPulpy<br><br>
        1,Account 2,BalanceSheet 3,CashFlow 4,ProfitAndLoss 5,Company Info</div>
    <br> <br>


    <a href="javascript:qcall()"><img src="images/qb.png" id="submit" width="120" height="120"></a><br><br>
    <input type="button" name="b1" id="b1" value="Get data from 5 Method"><br>
    <br>

    <textarea id="result" rows="20" cols="100" name="result"></textarea></center>
</div>
</body>
</html>
