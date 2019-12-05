package ImageHoster.repository;

import ImageHoster.model.Comments;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comments createComment(Comments comments) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comments);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comments;
    }

    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the images from the database
    //Returns the list of all the images fetched from the database
    public List<Comments> getAllComments(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comments> typedQuery = em.createQuery("Select i from Comments i where i.image.id = :image_Id", Comments.class);
        typedQuery.setParameter("image_Id", imageId);
        return typedQuery.getResultList();
    }

}
