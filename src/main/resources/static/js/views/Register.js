import createView from "../createView.js";

export default function Register(props) {
    return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Log In</title>
</head>
<body>
<h1>Log In</h1>

<form id="login-form">
    <label for="username">Username</label>
    <input id="username" name="username" type="text"/>
    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>
    <input id="login-btn" type="submit" value="Log In"/>
</form>
</body>
</html>`;

}

    export function RegisterEvent(){


        $("#register-btn").click(function () {

            let post = {
                username: $('#username').val(),
                email: $('#email').val(),
                password: $('.password').val()
            }

            let request = {
                method: "POST",
                header: {"Content-Type": "application/json"},
                body: JSON.stringify(post)
            };

            fetch("http://localhost:8080/api/users", request)
                .then((response) => {
                    console.log(response.status)
                    createView("/");
                });


        })

}