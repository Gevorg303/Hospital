package com.example.Hospital.repository;

import com.example.Hospital.domain.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Post> findAll() {
        return entityManager.createQuery("SELECT p FROM Post p", Post.class)
                .getResultList();
    }
    @Transactional
    public void addPosition(Post post) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("addposition");
        query.registerStoredProcedureParameter("position_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("salary", BigDecimal.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("position_description", String.class, ParameterMode.IN);

        query.setParameter("position_name", post.getName());
        query.setParameter("salary", post.getSalary());
        query.setParameter("position_description", post.getDescription());

        query.execute();
    }

    public void delete(Post post) {
        entityManager.remove(entityManager.contains(post) ? post : entityManager.merge(post));
    }
}
