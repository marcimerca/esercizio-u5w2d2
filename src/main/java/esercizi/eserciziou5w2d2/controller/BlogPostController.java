package esercizi.eserciziou5w2d2.controller;

import esercizi.eserciziou5w2d2.exception.BlogPostException;
import esercizi.eserciziou5w2d2.models.BlogPost;
import esercizi.eserciziou5w2d2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {

    @Autowired
    public BlogPostService blogPostService;

    @PostMapping("/blogPosts")
    public String saveBlogPost( @RequestBody BlogPost blogPost){
       return  blogPostService.savePost(blogPost);
    }

    @GetMapping("/blogPosts")
    public List<BlogPost> getallPosts(){
        return blogPostService.getAllPosts();
    }

    @GetMapping("blogPosts/{id}")
    public BlogPost getPostById(@PathVariable int id) throws BlogPostException{
        Optional<BlogPost> blogPostOpt = blogPostService.getPostById(id);

        if(blogPostOpt.isPresent()){
            return blogPostOpt.get();
        }
        else{
            throw new BlogPostException("blog post non trovato");
        }
    }


    @PutMapping("/blogPosts/{id}")
    public BlogPost updateBlogPost( @PathVariable int id, @RequestBody BlogPost blogPost) throws BlogPostException {
        return blogPostService.updatePost(id, blogPost);
    }

    @DeleteMapping("/blogPosts/{id}")
    public String deletePost(@PathVariable int id) throws BlogPostException{
        return blogPostService.deletePost(id);
    }


}
