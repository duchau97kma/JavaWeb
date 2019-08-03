<%-- 
    Document   : index
    Created on : Jul 28, 2019, 3:11:28 PM
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
            <h2 style="text-align: center">Table Student</h2>
            
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Họ tên</th>
                        <th>Khoa</th>
                        <th>Lớp</th>
                        <th>Chức năng</th>
                    </tr>
                </thead>
                <tbody>
                    <% SinhVienModel model = new SinhVienModel();
                        for (SinhVien sv : model.showSV()) {


                    %>
                    <tr>
                        <td><%=sv.getId()%></td>
                        <td><%= sv.getHoten()%></td>
                        <td><%= sv.getKhoa()%></td>
                        <td><%= sv.getLop()%></td>
                        <td> 
                            <a href="update.jsp?id=<%= sv.getId() %>">
                            <button type="button" class="btn btn-primary">Sửa</button>
                            </a>
                            <a href="deleteSV?id=<%= sv.getId()%> " onclick="return confirm('Delete sv <%= sv.getId()%>')">
                                <button type="submit" class="btn btn-danger">Xóa</button> 
                            </a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
                    <a href="add.jsp">
                        <button type="button" class="btn btn-success">Thêm mới</button>
                    </a>
            
        </div>

    </body>
</html>
