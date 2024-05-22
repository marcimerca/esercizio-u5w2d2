package esercizi.eserciziou5w2d2.services;

import esercizi.eserciziou5w2d2.exception.BlogPostException;
import esercizi.eserciziou5w2d2.models.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    private List<BlogPost> blogposts = new ArrayList<>();

    public Optional<BlogPost> getPostById(int id) {
        return blogposts.stream().filter(blogPost -> blogPost.getId() == id).findFirst();
    }

    public List<BlogPost> getAllPosts() {
        return blogposts;
    }

    public String savePost(BlogPost blogPost) {
        blogposts.add(blogPost);
        return "Post salvato con successo";
    }

    public BlogPost updatePost(int id, BlogPost blogPostUpd) throws BlogPostException {
        Optional<BlogPost> blogpostOpt = getPostById(id);
        if (blogpostOpt.isPresent()) {
            BlogPost blogPost = blogpostOpt.get();
            blogPost.setCategoria(blogPostUpd.getCategoria());
            blogPost.setTitolo(blogPostUpd.getTitolo());
            blogPost.setCover(blogPostUpd.getCategoria());
            blogPost.setMinutiDiLettura(blogPostUpd.getMinutiDiLettura());
            return blogPost;

        } else {
            throw new BlogPostException("Post da modificare non presente");
        }
    }

    public String deletePost(int id) throws BlogPostException{
        Optional<BlogPost> blogpostOpt = getPostById(id);

        if (blogpostOpt.isPresent()) {
            BlogPost blogPost = blogpostOpt.get();
           blogposts.remove(blogPost);
            return "Elemento eliminato correttamente";

        } else {
            throw new BlogPostException("Post da eliminare non presente");
        }
    }


}
