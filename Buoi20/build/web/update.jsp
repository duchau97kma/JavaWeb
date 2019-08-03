<%-- 
    Document   : update
    Created on : Jul 28, 2019, 4:03:00 PM
    Author     : Winter
--%>

<%@page import="Bean.SinhVien"%>
<%@page import="Model.SinhVienModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <h2>Update Student</h2>
            <% 
            SinhVien sv = new SinhVienModel().getSvById(Integer.parseInt(request.getParameter("id")));
            %>
            <form action="updateSV" method="post">
                
                <div class="form-group">
                    <label>ID</label>
                    <input type="text" readonly="" class="form-control"  name="id" value="<%= sv.getId()%>">
                </div>
                <div class="form-group">
                    <label>Họ và tên</label>
                    <input type="text" class="form-control" name="name" value="<%= sv.getHoten() %>">
                </div>
                <div class="form-group">
                    <label>Khoa</label>
                    <input type="text" class="form-control" name="khoa" value="<%= sv.getKhoa() %>">
                </div>
                <div class="form-group">
                    <label>Lớp</label>
                    <input type="text" class="form-control" name="lop" value="<%= sv.getLop() %>">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            
        </div>

    </body>
</html>