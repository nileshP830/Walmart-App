
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
        <h1>Reset Password</h1>
        <form action="forgot-password" method="post">
            <div class="txt_field">
                <input type="email" name="email">
                <span></span>
                <label>email address</label>
            </div>
            <div class="txt_field">
                <input type="password" name="new-password">
                <span></span>
                <label>new password</label>
            </div>
            <div class="txt_field">
                <input type="password" name ="confirm-password">
                <span></span>
                <label> confirm password</label>
            </div>
            <input type="submit" value="Reset Password">
            <div class="login"><a href="login.jsp">Login</a></div>
        </form>
    </div>
</body>
</html>

