@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Search">
        </form>

        @if(page.getUsers().size() > 0)
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th></th>
                </tr>
                @for(var user : page.getUsers())
                    <tr>
                        <td>${user.getId()}</td>
                        <td>${user.getFirstName() + " " + user.getLastName()}</td>
                        <td>${user.getEmail()}</td>
                        <td><a href="/users/${user.getId()}">Show</a></td>
                    </tr>
                @endfor
            </table>
        @endif
    `
)