package company.service;

import company.model.Post;
import company.repository.PostRepository;
import company.repository.hibernate.HibernatePostRepositoryImpl;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new HibernatePostRepositoryImpl();
    }

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post update(Post post) {
        return postRepository.update(post);
    }

    public List<Post> getAll() {
        return postRepository.getAll();
    }

    public Post findById(Integer id) {
        return postRepository.findByID(id);
    }
    public void delete(Integer id){
        postRepository.delete(id);
    }
}
