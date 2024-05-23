@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
        <main>
            <h1>All posts</h1>

            <div>
                <a href="/posts?page=${page.getPageNumber() + 1}">Next</a>
                <a href="/posts?page=${page.getPageNumber() - 1}">Previous</a>
            </div>

            @if(page.getPosts().size() > 0)
                <ul>
                    @for(var post : page.getPosts())
                        <li>
                            <a href="/posts/${post.getId()}">${post.getName()}</a>
                        </li>
                    @endfor
                </ul>
            @endif
        </main>
    `
)