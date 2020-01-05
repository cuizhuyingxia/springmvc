<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

    <script>
        // 页面加载完成后
        $(function () {
            // 为按钮绑定单击事件
            $("#btn").click(function () {
                // 发送ajax请求
                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=utf-8",
                    /*注意：如果在后台使用jackson自动解析json数据并封装到对应的实体类中时，需要在数据这里加上单引号*/
                    data : '{"username":"coco", "password":123, "age":18}',
                    type: "POST",
                    success:function (data) {
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="/user/testString">testString</a><br>
    <a href="/user/testVoid">testVoid</a><br>
    <a href="/user/testModelAndView">testModelAndView</a><br>
    <a href="/user/testForward">testForward</a><br>
    <a href="/user/testRedirect">testRedirect</a><br>

    <input type="button" id="btn" name="btn" value="发送ajax请求">
</body>
</html>
