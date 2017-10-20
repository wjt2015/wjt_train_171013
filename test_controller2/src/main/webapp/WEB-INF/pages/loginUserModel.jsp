<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>loginUserModel</title>
<%--    <script type="text/javascript" src="../jquery/jquery-3.2.1.js"></script>--%>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
    <script type="text/javascript">
        function sendId() {
            var url = "http://localhost:8080/test_controller2_tomcat/id.h";
            var loginUserModel = {id:1232,userName:"Bill-Gates",password:"windows",loginTime:18931208931,role:1,isLogin:1};
            var loginUserModelStr = JSON.stringify(loginUserModel);
            $.ajax({
                url:"http://localhost:8080/test_controller2_tomcat/id.h",
                type:"POST",
                async:false,
                data:{id:1232,userName:"Bill-Gates",password:"windows",loginTime:18931208931,role:1,isLogin:1},
                dataType:"json",
                contentType: "application/x-www-form-urlencoded;charset=utf-8",
                success:function (result) {
                    alert("success;result=" + result);
                }
            });
        }

        function sendOne() {
            var url = "http://localhost:8080/test_controller2_tomcat/loginUserModel.h";
            var loginUserModel = {id:1232,userName:"Bill-Gates",password:"windows",loginTime:18931208931,role:1,isLogin:1};
            var loginUserModelStr = JSON.stringify(loginUserModel);
            $.ajax({
                url:url,
                type:"POST",
                async:false,
                data:loginUserModelStr,
                dataType:"json",
                contentType: "application/json; charset=utf-8",
                success:function (result) {
                    alert("success;result=" + result);
                }
            });
        }

        function sendList() {
            var url = "http://localhost:8080/test_controller2_tomcat/modelList.jsp";
            var modelList = [];
            var loginUserModel = {id:1232,userName:"Bill-Gates",password:"windows",loginTime:18931208931,role:1,isLogin:1};
            modelList.push(loginUserModel);
            loginUserModel = {id:1432,userName:"Bill-Clinton",password:"President",loginTime:199000129,role:0,isLogin:1};
            modelList.push(loginUserModel);
            alert("modelList=" + modelList);
            var modelListStr = JSON.stringify(modelList);
            alert("modelListStr=" + modelListStr);
            $.ajax({
                url:url,
                async:false,
                type:"POST",
                data:modelListStr,
                dataType:"json",
                contentType: "application/json; charset=utf-8",
                success:function (result) {
                    alert("result=" + result);
                }
            });
        }

        function createCookie(result) {
            var domainList = result.data.domainList;
            var idList = result.data.idList;
            var userinfoList = result.data.userinfoList;
            alert("before;cookie=" + document.cookie);
            for(var i = 0;i < domainList.length;i++){
                var domain = domainList[i];
                for(j = 0;j < idList.length;j++){
                    var id = idList[j];
                    var userinfo = userinfoList[j];
                    document.cookie = "ID=" + id + ";domain=" + domain;
                    document.cookie = "USER_INFO=" + userinfo + ";domain=" + domain;
                }
                alert("domain:" + domain + ";cookieStr=" + document.cookie);
            }
            alert("finish;cookie=" + document.cookie);
        }
        
        function showCookie() {
            alert("cookieStr=" + document.cookie);
        }

        function removeCookieByName(cookieName) {
            document.cookie = (cookieName + "=; expires=Thu, 01 Jan 1970 00:00:00 GMT");
            alert("cookie=" + document.cookie);
        }
        
        function login() {
            var userName = $("#userNameId").val();
            var password = $("#passwordId").val();
            alert("userName:" + userName + ";password:" + password);
            var url = "http://localhost:8080/test_controller2_tomcat/login.h";
            $.ajax({
                url:url,
                type:"POST",
                async:false,
/*                headers:{
                    Accept:"text/html, application/xhtml+xml+json, *!/!*"
                },*/
                data:{userName:userName,password:password},
                dataType:"json",
/*                contentType:"application/x-www-form-urlencoded;charset=utf-8",*/
                success:function (result) {
                    alert("success--result=" + result);
                    if(result.status == 0){
                        createCookie(result);
                    }
                },
                error:function (result) {
                    alert("error--result=" + result);
                }
            });
        }

    </script>
</head>
<body>

<div align="center">
    <input type="button" value="send one Id" onclick="sendId()" />
    <br/>
    <input type="button" value="send one loginUserModel" onclick="sendOne()" />
    <br/>
    <input type="button" value="sendList" onclick="sendList()" />
    <br/>
    <a href="/test_controller2_tomcat/loginUserModel.h">跳转到modelList页面</a>
    <br/>
    <input type="button" value="showCookie" onclick="showCookie()" />
    <br/>
    <input type="button" value="removeCookieByName" onclick="removeCookieByName('ID')" />
    <br/>
</div>

<div align="center">
    用户名:<input type="text" id="userNameId" />
    <br/>
    密码：<input type="text" id="passwordId" />
    <br/>
    <input type="button" value="login" onclick="login()" />
</div>

</body>
</html>



