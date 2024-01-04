package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
import exercise.model.Comment;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;
  
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    List<PostDTO> index() {
        var posts = postRepository.findAll();

        var postDTOs = posts.stream()
                .map(this::toPostDTO)
                .toList();

        return postDTOs;
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        return this.toPostDTO(post);
    }

    private PostDTO toPostDTO(Post post) {
        var dto = new PostDTO();
        var postId = post.getId();

        dto.setId(postId);
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());

        var comments = commentRepository.findByPostId(postId);

        var commentDTOs = comments.stream()
                .map(this::toCommentDTO)
                .toList();

        dto.setComments(commentDTOs);

        return dto;
    }

    private CommentDTO toCommentDTO(Comment comment) {
        var dto = new CommentDTO();

        dto.setId(comment.getId());
        dto.setBody(comment.getBody());

        return dto;
    }
}
// END
