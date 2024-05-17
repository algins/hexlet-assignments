@import exercise.dto.users.UserPage
@param UserPage page

<html>
    <head>
        <title>User</title>
    </head>
    <body>
        <p>ID: ${page.getUser().getId()}</p>
        <p>First name: ${page.getUser().getFirstName()}</p>
        <p>Last name: ${page.getUser().getLastName()}</p>
        <p>Email: ${page.getUser().getEmail()}</p>
    </body>
</html>