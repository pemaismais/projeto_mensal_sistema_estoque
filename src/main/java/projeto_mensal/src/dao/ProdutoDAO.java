/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import projeto_mensal.src.model.Produto;

/**
 *
 * @author henri
 */
public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        this.em = emf.createEntityManager();
    }

    public void beginTransaction() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
    }

    public void commitTransaction() {
        EntityTransaction transaction = em.getTransaction();
        transaction.commit();
    }

    public Produto insert(Produto produto) {
        em.persist(produto);
        return produto;
    }

    public Produto update(Produto produto) {
        em.merge(produto);
        em.persist(produto);
        return produto;
    }

    public void delete(Produto produto) {
        em.remove(produto);
    }

    public Produto selectById(int id) throws SQLException {
        try {
            Produto produto = em.find(Produto.class, id);
            return produto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro: " + e.getMessage(), e);
        }
    }

    public List<Produto> selectByIdAll(String idStr) throws SQLException {
        try {
            int id = Integer.parseInt(idStr);
            String jpql = "select p from Produto p where p.id like :id order by p.id";
            Query query = em.createQuery(jpql);
            query.setParameter("id", id);

            List<Produto> produtoes = query.getResultList();
            return produtoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public List<Produto> selectAll() throws SQLException {
        try {
            String jpql = "SELECT e FROM Produto AS e";
            Query query = em.createQuery(jpql);
            List<Produto> produtoes = query.getResultList();
            return produtoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public List<Produto> selectByNomeAll(String nome) throws SQLException {
        try {
            String jpql = "select p from Produto p where p.nome like :nome order by p.nome";
            Query query = em.createQuery(jpql);
            query.setParameter("nome", "%" + nome + "%");

            List<Produto> produtoes = query.getResultList();
            return produtoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean cadastrar(Produto produto) throws SQLException {
        try {
            em.clear();
            beginTransaction();
            insert(produto);
            commitTransaction();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public void remover(int id) throws SQLException {
        try {
            beginTransaction();
            Produto produto = selectById(id);
            delete(produto);
            commitTransaction();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage());
        }
    }

    public boolean alterar(Produto novoProduto) throws SQLException {
        try {
            beginTransaction();
            if (selectById(novoProduto.getId()) != null) {
                em.merge(novoProduto);
                commitTransaction();
                return true;
            } else {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                return false;
            }
        } catch (IllegalArgumentException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

}
