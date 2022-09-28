
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Animated Registration Form </title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="center">
            <h1>Registration</h1>
            <form action="register" method="post">
                <div class="txt_field">
                    <input type="text" name="firstname" required>
                    <span></span>
                    <label>First Name</label>
                </div>
                <div class="txt_field">
                    <input type="text" name="lastname" required>
                    <span></span>
                    <label>Last Name</label>
                </div>
                <div class="txt_field">
                    <input type="email" name="email" required>
                    <span></span>
                    <label>Email Address</label>
                </div>
                <div class="txt_field">
                    <input type="text" name="mobile-number" required>
                    <span></span>
                    <label>Mobile number</label>
                </div>
                <div class="txt_field">
                    <input type="password" name="password" required>
                    <span></span>
                    <label>Create Password</label>
                </div>
                <div class="txt_field">
                    <input type="password" name="confirm-password" required>
                    <span></span>
                    <label>Confirm Password</label>
                </div>
                <div class="signup">
                    <input type="submit" value="Sign up">
                </div>
                <div class="signin_link"> Already have an account?
                    <a href="login.jsp">SignIn</a>
                </div>
            </form>
        </div>
    </body>
</html>
