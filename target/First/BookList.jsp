<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>bookList.jsp</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->

    </head>

    <body>
        <form action="${pageContext.request.contextPath}/getBookList.action">
            <input name="sub" type="submit" value="显示全部" />
            <tr>
                <td>书籍ID</td>
                <td>书名</td>
                <td>类别代码</td>
                <td>剩余数量</td>
            </tr>
            <tr>
                <c:forEach items="${bookList}" var="book">
                    <td>${book.bookID}</td>
                    <td>${book.bookName}</td>
                    <td>${book.category}</td>
                    <td>${book.remainNum}</td>
                </c:forEach>
            </tr>
        </form>
    </body>

    <!--script type="text/javaScript">
        /*var bookList = {}
        Object.defineProperty(bookList, 'inputValue', {
            configurable: true,
            get: function() {
                return document.getElementById('foo').value
            },
            set: function(value) {
                document.getElementById('foo').value = value
            }
        })*/
        function getAll(){
            $.ajax({
                //请求路径
                url : "",
                //请求类型
                type : "get",
                //成功响应的结果
                success : function(data) {
                    //if (data != null) {
                        this.bookList = data;
                        /*alert(data);
                        console.log(data);
                        console.log(bookList);*/
                    //}
                }
            });
        }
    </script-->
</html>