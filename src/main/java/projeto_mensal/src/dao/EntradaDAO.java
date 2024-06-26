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
import javax.persistence.TypedQuery;
import static org.hibernate.criterion.Projections.id;
import projeto_mensal.src.model.Entrada;
import projeto_mensal.src.model.ItemEntrada;

/**
 *
 * @author henri
 */
public class EntradaDAO {

    private EntityManager em;

    public EntradaDAO() {
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

    public Entrada insert(Entrada entrada) {
        em.persist(entrada);
        return entrada;
    }

    public Entrada update(Entrada entrada) {
        em.merge(entrada);
        em.persist(entrada);
        return entrada;
    }

    public Entrada selectById(int id) throws SQLException {
        try {
            Entrada entrada = em.find(Entrada.class, id);
            return entrada;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro: " + e.getMessage(), e);
        }
    }

    public void delete(Entrada entrada) {
        em.remove(entrada);
    }

    public void close() {
        em.close();
    }

    public List<Entrada> selectAll() throws SQLException {
        try {
            String jpql = "SELECT e FROM Entrada AS e";
            Query query = em.createQuery(jpql);
            List<Entrada> entradas = query.getResultList();
            return entradas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean cadastrarEntrada(Entrada entrada) throws SQLException {
        try {
            beginTransaction();
            insert(entrada);
            commitTransaction();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean removerEntrada(int idEntrada) throws SQLException {
        try {
            beginTransaction();
            Entrada entrada = selectById(idEntrada);
            delete(entrada);
            commitTransaction();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public void removerItemEntrada(int id) throws SQLException {
        try {
            Entrada entrada = selectById(id);
            ItemEntrada itemEntrada = entrada.getItem();
            beginTransaction();

            em.remove(itemEntrada);
            entrada.setItem(null);

            commitTransaction();
        } catch (Exception e) {
            // Em caso de exceção, faz rollback da transação
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean alterar(Entrada novoEntrada) throws SQLException {
        try {
            beginTransaction();
            if (selectById(novoEntrada.getId()) != null) {
                em.merge(novoEntrada);
                commitTransaction();
                return true;
            } else {
                return false; // Retorna false se a receita não existir no banco de dados
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public List<ItemEntrada> listarEntradasPorProduto(int produtoId) {
        String jpql = "SELECT ie FROM ItemEntrada ie " +
                      "JOIN FETCH ie.entrada e " +
                      "JOIN FETCH ie.produto p " +
                      "WHERE p.id = :produtoId";

        Query query = em.createQuery(jpql);
        query.setParameter("produtoId", produtoId);

        return query.getResultList();
    }
}
