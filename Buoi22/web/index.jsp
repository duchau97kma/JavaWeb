<%-- 
    Document   : index
    Created on : Aug 18, 2019, 3:27:25 PM
    Author     : Winter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h2 style="text-align: center">Table Book</h2>
            
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${book}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.title}</td>
                        <td>${item.author}</td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                        <td> 
                            <a href="editBook?id=${item.id}">
                            <button type="button" class="btn btn-primary">Sửa</button>
                            </a>
                            <a href="deleteBook?id=${item.id}" onclick="return confirm('Delete ${item.id}')">
                                <button type="submit" class="btn btn-danger">Xóa</button> 
                            </a>
                        </td>
                    </tr>
                  </c:forEach>
                </tbody>
            </table>
                    <a href="addbook.jsp">
                        <button type="button" class="btn btn-success">Thêm mới</button>
                    </a>
            
        </div>

    </body>
</html>