<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- 常用的注解 --%>

    <%-- 将指定的请求参数赋给形参 --%>
    <%--<a href="anno/testRequestParam?username=涂涂">RequestParam</a>--%>

    <%-- 获取请求体中的内容 --%>
    <%--<form action="anno/testRequestBody" method="post">
        姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        生日：<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>--%>

    <%-- 获取请求ulr中的占位符 --%>
    <%--<a href="anno/testPathVariable/10">PathVariable</a>--%>

    <%-- 获取请求头的值 --%>
    <%--<a href="anno/testRequestHeader">RequestHeader</a>--%>

    <%-- 获取cookie的值 --%>
    <%--<a href="anno/testCookieValue">CookieValue</a>--%>

    <%-- ModelAttribute注解 --%>
    <%--<form action="anno/testModelAttribute" method="post">
        姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>--%>

    <a href="anno/testHttpServletRequest">testHttpServletRequest</a>
    <a href="anno/testModel">testModel</a>
    <a href="anno/testGetSession">testGetSession</a>
    <a href="anno/testDelSession">testDelSession</a>

</body>
</html>
