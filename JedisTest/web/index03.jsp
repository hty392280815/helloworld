<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/8 0008
  Time: 下午 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.8.2.min.js"></script>

    <script>
        $(function(){

            $("#xi").change(function () {
                var xid = $("#xi").val();
                $("#ban").html("<option>===请选择班===</option>");
                $("#xue").html("<option>===请选择学生===</option>");
                $.ajax({
                    type:"post",
                    url:"BanServlet",
                    data:{"xid":xid},
                    dataType:"json",
                    success:function(data){
                        $.each(data,function(commentIndex,ban){
                            $("#ban").append("<option id="+ban.bid+" value="+ban.bid+">"+ban.bname+"</option>");
                        });
                    }
                });
            });

            $("#ban").change(function () {
                var bid = $("#ban").val();
                $("#xue").html("<option>===请选择学生===</option>");
                $.ajax({
                    type:"post",
                    url:"XueServlet",
                    data:{"bid":bid},
                    dataType:"json",
                    success:function(data){
                        $.each(data,function(commentIndex,xue){
                            $("#xue").append("<option id="+xue.sid+" value="+xue.sid+">"+xue.sname+"</option>");
                        });
                    }
                });
            });

        });
    </script>


</head>
<body>
    <select id="xi">
        <option>===请选择系===</option>
        <c:forEach items="${xis}" var="xi">
            <option id="${xi.xid}" value="${xi.xid}">${xi.xname}</option>
        </c:forEach>
    </select>
    <select id="ban">
        <option>===请选择班===</option>
    </select>
    <select id="xue">
        <option>===请选择学生===</option>
    </select>
</body>
</html>
