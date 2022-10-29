package company.service;

import com.sun.istack.NotNull;
import company.model.Post;
import company.model.Writer;
import company.repository.PostRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    private final Post post = new Post("Graphic", new Date(100), new Date(100), new Writer("Alex", "Pushkin"));

    private final List<Post> posts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Graphic", new Date(100), new Date(100), new Writer("Alex", "Pushkin")));
        posts.add(new Post("Alf", new Date(100), new Date(100), new Writer("Lev", "Tolstoy")));
        return posts;
    }

    @Test
    public void saveTest_Successful() {
        Mockito.when(postRepository.save(any(Post.class))).thenReturn(post);
        Assertions.assertEquals("Alex", postService.save(new Post()).getWriter().getFirstName());
    }

    @Test
    public void saveTest_unSuccessful() {
        Mockito.when(postRepository.save(any(Post.class))).thenReturn(post);
        Assertions.assertNotEquals("peter", postService.save(new Post()).getWriter().getFirstName());
    }

    @Test
    public void updateTest_Successful() {
        Mockito.when(postRepository.update(any(Post.class))).thenReturn(post);
        Assertions.assertEquals("Alex", postService.update(new Post()).getWriter().getFirstName());
    }

    @Test
    public void updateTest_unSuccessful(){
        Mockito.when(postRepository.update(any(Post.class))).thenReturn(post);
        Assertions.assertNotEquals("peter",postService.update(new Post()).getWriter().getFirstName());
    }
    @Test
    public void getAllTest_Successful(){
        Mockito.when(postRepository.getAll()).thenReturn(posts());
        Assertions.assertEquals("Alex",postService.getAll().get(0).getWriter().getFirstName());
    }

    @Test
    public void getAllTest_unSuccessful(){
        Mockito.when(postRepository.getAll()).thenReturn(posts());
        Assertions.assertNotEquals("Lev",postService.getAll().get(0).getWriter().getFirstName());
    }
    @Test
    public void findByIdTest_Successful(){
        Mockito.when(postRepository.findByID(anyInt())).thenReturn(post);
        Assertions.assertEquals("Alex",postService.findById(anyInt()).getWriter().getFirstName());
    }

    @Test
    public void findByIdTest_unSuccessful(){
        Mockito.when(postRepository.findByID(anyInt())).thenReturn(post);
        Assertions.assertNotEquals(null,postService.findById(anyInt()).getWriter().getFirstName());
    }


}
