package company.controller;

import company.model.Post;
import company.service.PostService;

import java.util.List;

public class PostController {
    private  PostService postService = new PostService();

    public Post save(Post post) {
        return postService.save(post);
    }

    public Post update(Post post) {
        return postService.update(post);
    }

    public List<Post> getPosts() {
        return postService.getAll();
    }

    public Post findById(Integer id) {
        return postService.findById(id);
    }

    public void delete(Integer id) {
        postService.delete(id);
    }
}
