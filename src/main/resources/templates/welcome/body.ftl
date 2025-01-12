<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to PECS</title>
    <style>
        body {
            @import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap') font-family: 'Arial', sans-serif;
            background-color: aliceblue;
            color: black;
            margin: 0;
            padding: 0;
            text-align: center;
            font-family: "Roboto", sans-serif;
            font-weight: 500;
        }

        .container {
            margin: 5em;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }

        h1 {
            color: #007bff;
        }

        p {
            line-height: 1.6;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #000000;
            color: #fff;
            text-decoration: none;
            border-radius: 3px;
        }

        .pecs-logo {
            width: 14em;
        }

        .footer {
            margin-top: 20px;
            padding-top: 10px;
            border-top: 1px solid #555;
            text-align: center;
            color: #888;
            font-size: 14px;
        }
    </style>
</head>

<body>
    <div class="container">
        <div>
            <img src="https://github.com/Atarian-ByVoid/free-images/blob/main/CGI__1_-removebg-preview.png?raw=true"
                alt="CGI Bank Logo" class="pecs-logo">
        </div>
        <h1>Welcome to CGI Bank</h1>
        <p>Hello ${name},</p>
        <p>We are delighted to welcome you to CGI Bank - your trusted financial partner.</p>
        <p>We are committed to providing you with top-notch banking services and ensuring a seamless banking experience.
        </p>
        <p>If you have any questions or need assistance, please don't hesitate to contact us. We are here to help!</p>
        <a href="${loginLink}" class="button">Access My Account</a>
        <p>Thank you once again for choosing CGI Bank!</p>
        <p>Best regards,<br>CGI Bank Team</p>
        <div class="footer">
            &copy; 2022 CGI Bank Platform. All rights reserved. Created by <strong>Metric</strong>
        </div>
    </div>


</body>

</html>