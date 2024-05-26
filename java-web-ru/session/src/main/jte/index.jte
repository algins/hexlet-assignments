@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
    content = @`
        @if(page.getName() != null)
            <p>${page.getName().toString()}</p>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" value="Выйти" />
            </form>
        @else
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @endif
    `
)