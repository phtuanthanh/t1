<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.error-message {
            color: black;
            padding: 10px;
            margin: 10px 0;
            <% if (request.getAttribute("errorMessage") != null) { %>
                display: block;
            <% } else { %>
                display: none;
            <% } %>
        }
 .searchResult {
            color: black;
            padding: 10px;
            margin: 10px 0;
            <% if (request.getAttribute("searchResult") != null) { %>
                display: list-item;
            <% } else { %>
                display: none;
            <% } %>
        }
</style>
</head>
<body>
<h1>HTShop</h1>
<h2>Xin chào</h2>
<form action="<%=request.getContextPath()%>/index" method="post">
    <div class="error-message">
        <%= request.getAttribute("errorMessage") %>
    </div>
    <br></br>
   <label for="ID">ID:</label>
        <input type="text" id="ID" name="ID">
         <button type="submit" style="top:unset; bottom: 6%;">Tim kiem</button>
 
   </form>
   <form action="<%=request.getContextPath()%>/index" method="get">
      <div class="searchResult">
        <%= request.getAttribute("searchResult") %>
    </div>
   </form>

</body>
</html>
