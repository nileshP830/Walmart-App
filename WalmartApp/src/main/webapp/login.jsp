
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Animated Login Form | CodingNepal</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="center">
        <h1>Login</h1>
        <form action="login" method="post">
            <div class="txt_field">
                <input type="text" name="email" required>
                <i class="far fa-envelope"></i>
                <span></span>
                <label>Email Address</label>
            </div>
            <div class="txt_field">
                <input type="password" name ="password" required>
                <i class="fas fa-lock" onclick="show()"></i>
                <span></span>
                <label>Password</label>
            </div>
            <div class="remember">
                <input type="checkbox">
                <span></span>
                <label>remember me</label>
            </div>
            <div class="forgot"><a href="forgot.jsp">Forgot Password?</a></div>
            <input type="submit" value="Login">
            <div class="signup_link">
                Not a member? <a href="register.jsp">SignUp</a>
            </div>
        </form>
    </div>
    <script>
        function show(){
            var password = document.getElementById('password');
            var icon = document.querySelector('.fas');
            if(password.type === "password"){
                password.type = "text";
                password.style.marginTop =  "20px";
                icon.style.color = "#7f2092";
            }else {
                password.type = "text";
            }
        }
    </script>
</body>
</html>
