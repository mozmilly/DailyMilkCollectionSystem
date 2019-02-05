<%-- 
    Document   : tender
    Created on : Jan 27, 2019, 8:35:29 PM
    Author     : TOLBERT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/tendering.css">
        <script src="validation.js"></script>
        <jsp:include page="./includes/global_stylesheets.jsp"/>
        <title>tendering</title>
    </head>
    <body>
        <br><br>
        <h1 style="text-align: center ;font-family: inherit"> Create a tender</h1>
        <form name="tenderform" action="create-tender" id="form1" method="POST" onsubmit="return validate()" enctype="multipart/form-data">
            <table  >
                <thead>
                    <tr>
                        <th style="text-align: center"><b>Create Tender</b></th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><label for="field1"><span><b>Title</b><span class="required"></span></span></label> </td>
                        <td><input type="text" name="title" class="input-field"/></td>
                    </tr>
                    <tr>
                        <td><b>Tender document</b> </td>
                        <td>
                            <input type="file" id="file1" name="file_upload" accept="image/png, image/jpeg ,.doc,.docx,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document"/>
                        </td> 
                    </tr>
                    <tr>
                        <td>Open date for application</td>
                        <td>
                            <input type="date" name="start_date" required/>
                        </td>

                    </tr>
                    <tr>
                        <td>End date for application</td>
                        <td>
                            <input type="date" name="end_date" required/>
                        </td>

                    </tr>
                    <tr>
                        <td> <input type="submit" value="Clear" /></td>
                        <td ><label><span><input type="submit"  value="Create"  name="create" id="btn" /> </span></label>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
