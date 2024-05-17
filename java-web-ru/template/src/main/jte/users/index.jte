@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th></th>
            </tr>
            @for(var user : page.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                    <td><a href="/users/${user.getId()}">Show</a></td>
                </tr>
            @endfor
        </table>
    </body>
</html>