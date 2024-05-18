@import gg.jte.Content

@param Content content
@param Content footer = null

<head>
    <title>Layout exercise</title>
</head>
<body>
    <header>
        <a href="/">Welcome page</a>
        <a href="/users">Users page</a>
    </header>
    <main>
        ${content}
    </main>
    <footer>
        <a href="https://github.com/algins">My GitHub</a>
    </footer>
</body>
