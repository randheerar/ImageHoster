package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentService() {
        System.out.println("*** Comment Service ***");
    }

    //Call the getAllComments() method in the Repository and obtain a List of all the Comments in the database
    public List<Comments> getAllComments(Integer imageId) {
        return commentRepository.getAllComments(imageId);
    }

    //The method calls the createComment() method in the Repository and passes the Comments to be persisted in the database
    public void createComment(Comments comments) {
        comments.setCreatedDate(new Date());
        commentRepository.createComment(comments);
        System.out.println("New Comment created :" + comments);
    }
}
