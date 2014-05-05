<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<script type="text/javascript">
function drawArrows(doc) {
    var ctx = doc.getCSSCanvasContext("2d", "arrowRight", 10, 11);
    ctx.fillStyle = "rgb(90,90,90)";
    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.lineTo(0, 8);
    ctx.lineTo(7, 4);
    ctx.lineTo(0, 0);
    ctx.fill();
    ctx.closePath();

    var ctx = doc.getCSSCanvasContext("2d", "arrowDown", 11, 10);

    ctx.fillStyle = "rgb(90,90,90)";
    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.lineTo(8, 0);
    ctx.lineTo(4, 7);
    ctx.lineTo(0, 0);
    ctx.fill();
    ctx.closePath();
}

function loadXml(src) {
    var win = window.open (src,"","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,copyhistory=no,width=1,height=1,top=5000,left=5000");

    window.setTimeout(populateXml(win, 0), 100);
}

function populateXml(win, counter) {
    return function() {
        var doc = document.getElementById("xml").contentDocument;
        var head = doc.getElementsByTagName("head")[0];
        var fromStyle = win.document.getElementsByTagName("style")[0];
        if(!fromStyle) {
            if(counter < 50) {
                window.setTimeout(populateXml(win, counter + 1), 100);
            } else {
                doc.location = win.location;
                win.close();
            }
            return;
        }
        var style = doc.createElement("style");
        style.type = "text/css";
        style.id = fromStyle.id;
        style.appendChild(doc.createTextNode(fromStyle.textContent));
        head.appendChild(style);
        $(doc.body).html($(win.document.body).children());

        style = doc.createElement("style");
        style.type = "text/css";
        style.appendChild(doc.createTextNode(".webkit-html-tag {color: #881280;}.webkit-html-attribute-name {color:  #994500;}.webkit-html-attribute-value {color: #1A1AA6;}"));
        head.appendChild(style);

        var arr = doc.getElementsByClassName("button collapse-button");
        for(var i = 0; i < arr.length; i++) {
            var o = arr[i];
            var p = $(o).parents("div.collapsible:first").get(0);

            if(p) {
                o.onclick = (function(document, sectionId) {
                    return eval("(" + o.onclick.toString() + ")");
                })(doc, p.id);
            }
        }

        arr = doc.getElementsByClassName("button expand-button");
        for(var i = 0; i < arr.length; i++) {
            var o = arr[i];
            var p = $(o).parents("div.collapsible:first").get(0);

            if(p) {
                o.onclick = (function(document, sectionId) {
                    return eval("(" + o.onclick.toString() + ")");
                })(doc, p.id);
            }
        }
        win.close();
        drawArrows(doc);
    };
}
</script>
<iframe src="about:blank" id="xml" 
      width="500px" height="500px"></iframe>
<br>
<input type="button" value="Load Xml" onclick="loadXml('xml/sam.xml')">
</body>
</html>