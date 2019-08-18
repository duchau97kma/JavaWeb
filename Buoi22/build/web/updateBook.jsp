<%-- 
    Document   : addbook
    Created on : Aug 18, 2019, 3:37:40 PM
    Author     : Winter
--%>

<%@page import="Model.BookModel"%>
<%@page import="DTO.Book"%>
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
            <h2>Update Student</h2>
            <form action="updateBook" method="post">
                <input type="hidden" name="id" value="<c:out value='${item.id}' />" />
                <div class="form-group">
                    <label>Title</label>
                    <input type="text" class="form-control" value="<c:out value='${item.title}' />" name="title">
                </div>
                <div class="form-group">
                    <label>Author</label>
                    <input type="text" class="form-control" value="<c:out value='${item.author}' />" name="author">
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="text" class="form-control" value="<c:out value='${item.price}' />" name="price">
                </div>
                <div class="form-group">
                    <label>Quantity</label>
                    <input type="text" class="form-control" value="<c:out value='${item.quantity}' />" name="quantity">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

    </body>
</html>
