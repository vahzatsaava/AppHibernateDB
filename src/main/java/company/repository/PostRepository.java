package company.repository;

import company.model.Label;
import company.model.Post;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PostRepository extends GenericRepository<Post, Integer>{
    List<Label> getLabels(int postID);
}
