    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title></title>
     
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
         type="text/javascript"></script>
        <script src="http://code.jquery.com/ui/1.8.20/jquery-ui.min.js"
         type="text/javascript"></script>
        <script src="http://jquery-ui.googlecode.com/svn/tags/latest/external/jquery.bgiframe-2.1.2.js"
            type="text/javascript"></script>
        <script src="http://jquery-ui.googlecode.com/svn/tags/latest/ui/minified/i18n/jquery-ui-i18n.min.js"
            type="text/javascript"></script>
        <style>
            .textarea{background: #fff;}
            .dragitems{width: 20%; float: left; background: #f1f1f1;}
            .dropitems{width: 70%;float: left;background: #f1f1f1;
                       margin-left: 20px;padding:5px 5px 5px 5px;}
            .dragitems ul{list-style-type: none;padding-left: 5px;
                       display: block;}
            #content{height: 400px;width: 650px;}
        </style>
        <script language="javascript" type="text/javascript">
            $(function() {
                $("#allfields li").draggable({
                    appendTo: "body",
                    helper: "clone",
                    cursor: "select",
                    revert: "invalid"
                });
                initDroppable($("#TextArea1"));
                function initDroppable($elements) {
                    $elements.droppable({
                        hoverClass: "textarea",
                        accept: ":not(.ui-sortable-helper)",
                        drop: function(event, ui) {
                            var $this = $(this);
                            var dropText;
                            var tempid = ui.draggable.text();
                            if (tempid=="Textview")
                            	{
                                 dropText = " <input type=text> ";
                            	}
                            else if (tempid=="Editview")
                        	{
                             dropText = " <input type=text> ";
                        	}
                            else if (tempid=="Button")
                        	{
                                dropText = " <input type=fdsf> ";
                           	}
                            else if (tempid=="Image")
                        	{
                                dropText = " <input type=text> ";
                           	}
                           
                            var droparea = document.getElementById('TextArea1');
                            var range1 = droparea.selectionStart;
                            var range2 = droparea.selectionEnd;
                            var val = droparea.value;
                            var str1 = val.substring(0, range1);
                            var str3 = val.substring(range1, val.length);
                            droparea.value = str1 + dropText + str3;
                        }
                    });
                }
            });
        </script>
     
    </head>
    <body>
        <form id="form1" runat="server">
        <div id="content">
            <div class="dragitems">
                <h3>
                    <span>Available Fields</span></h3>
                <ul id="allfields" runat="server">
                    <li id="node1" >Textview</li>
                    <li id="node2">Edittext</li>
                    <li id="node3">Button</li>
                    <li id="node4">Image</li>
                    
                </ul>
            </div>
            <div class="dropitems">
                <textarea id="TextArea1" cols="50" name="S1"
                rows="20"></textarea>
            </div>
        </div>
        </form>
    </body>
    </html>