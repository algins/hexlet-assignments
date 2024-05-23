@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
    content = @`
        <main>
            <h1>Post ${page.getPost().getId()}</h1>

            <div>
                <a href="/posts">All posts</a>
            </div>

            <dl>
                <dt>Name:</dt>
                <dd>${page.getPost().getName()}</dd>
                <dt>Body:</dt>
                <dd>${page.getPost().getBody()}</dd>
            </dl>
        </main>
    `
)