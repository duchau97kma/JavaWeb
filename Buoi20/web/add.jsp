<%-- 
    Document   : add
    Created on : Jul 28, 2019, 3:20:03 PM
    Author     : Winter
--%>

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
            <h2>Add Student</h2>
            <form action="addSV" method="post">
                <div class="form-group">
                    <label>Họ và tên</label>
                    <input type="text" class="form-control" placeholder="Nhập họ và tên" name="name">
                </div>
                <div class="form-group">
                    <label>Khoa</label>
                    <input type="text" class="form-control" placeholder="Nhập khoa" name="khoa">
                </div>
                <div class="form-group">
                    <label>Lớp</label>
                    <input type="text" class="form-control" placeholder="Nhập lớp" name="lop">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

    </body>
</html>
