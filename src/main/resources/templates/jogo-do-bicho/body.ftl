<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to CGI</title>
    <style>
        body {
            background-color: aliceblue;
            color: black;
            margin: 0;
            padding: 0;
            text-align: center;
            font-family: "Arial", sans-serif;
            font-weight: 500;
        }

        .container {
            margin: 5%;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }

        h1 {
            color: #007bff;
            font-size: 2em;
        }

        p {
            line-height: 1.6;
            font-size: 1.1em;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #000000;
            color: #fff;
            text-decoration: none;
            border-radius: 3px;
            font-size: 1em;
        }

        .pecs-logo {
            width: 70%;
            max-width: 14em;
        }

        .footer {
            margin-top: 20px;
            padding-top: 10px;
            border-top: 1px solid #555;
            text-align: center;
            color: #888;
            font-size: 14px;
        }

        @media only screen and (max-width: 600px) {
            .container {
                margin: 2%;
            }

            h1 {
                font-size: 1.5em;
            }

            p {
                font-size: 1em;
            }

            .pecs-logo {
                width: 90%;
            }
        }
    </style>
</head>

<body>
    <div class="container">
        <div>
            <img src="https://github.com/Atarian-ByVoid/free-images/blob/main/CGI__1_-removebg-preview.png?raw=true"
                alt="CGI Bank Logo" class="pecs-logo">
        </div>
        <h1>How about trying your luck in the animal game?</h1>
        <p>Hello <strong>${nome},</strong></p>
        <p>And you can start playing! We gift you with a balance of <strong>$50.00</strong> to start your bets.</p>

        <div>
            <img src="https://github.com/Atarian-ByVoid/free-images/blob/main/jogodobicho.png?raw=true"
                style="width: 100%; max-width: 40em; height: auto; border-radius: 10px;">
        </div>
        <p>Only here at CGI, we have special prizes every day!</p>

        <p>If you have any questions or need assistance, feel free to contact us.
            We're here to help!</p>

        <h2> Catalog</h2>
        <div>
            <img src="https://github.com/Atarian-ByVoid/free-images/blob/main/jogoDoBicho.png?raw=true"
                alt="CGI Bank Logo"
                style="width: 100%; max-width: 30em; height: auto; border-radius: 10px; margin-bottom: 2em;">
        </div>
        <a href="${loginLink}" class="button">Place bet</a>
        <p>Thank you once again for choosing CGI Bank!</p>
        <p>Best regards,<br>CGI Bank Team</p>
        <div class="footer">
            &copy; 2022 CGI Bank Platform. All rights reserved. Created by <strong>Metric</strong>
        </div>
    </div>
</body>

</html>