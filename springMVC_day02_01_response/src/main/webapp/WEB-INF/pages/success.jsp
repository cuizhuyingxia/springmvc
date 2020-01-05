<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>成功页面</h3>
    <%-- 获取request域中的用户信息 --%>
    ${requestScope.user.username}
    ${requestScope.user.password}
    ${requestScope.user.age}
</body>
</html>
