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
import projeto_mensal.src.model.ItemSaida;
import projeto_mensal.src.model.Saida;

/**
 *
 * @author henri
 */
public class SaidaDAO {

    private EntityManager em;

    public SaidaDAO() {
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

    public Saida insert(Saida saida) {
        em.persist(saida);
        return saida;
    }

    public Saida update(Saida saida) {
        em.merge(saida);
        em.persist(saida);
        return saida;
    }

    public Saida selectById(int id) throws SQLException {
        try {
            Saida saida = em.find(Saida.class, id);
            return saida;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro: " + e.getMessage(), e);
        }
    }

    public void delete(Saida saida) {
        em.remove(saida);
    }

    public void close() {
        em.close();
    }

    public List<Saida> selectAll() throws SQLException {
        try {
            String jpql = "SELECT e FROM Saida AS e";
            Query query = em.createQuery(jpql);
            List<Saida> saidas = query.getResultList();
            return saidas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean cadastrarSaida(Saida saida) throws SQLException {
        try {
            beginTransaction();
            insert(saida);
            commitTransaction();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean removerSaida(int idSaida) throws SQLException {
        try {
            beginTransaction();
            Saida saida = selectById(idSaida);
            delete(saida);
            commitTransaction();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public void removerItem(int id) throws SQLException {
        try {
            Saida saida = selectById(id);
            ItemSaida itemSaida = saida.getItem();
            beginTransaction();

            em.remove(itemSaida);
            saida.setItem(null);

            commitTransaction();
        } catch (Exception e) {
            // Em caso de exceção, faz rollback da transação
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean alterar(Saida novaSaida) throws SQLException {
        try {
            beginTransaction();
            if (selectById(novaSaida.getId()) != null) {
                em.merge(novaSaida);
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

    public List<ItemSaida> listarSaidasPorProduto(int produtoId) {
        String jpql = "SELECT ie FROM ItemSaida ie "
                + "JOIN FETCH ie.saida e "
                + "JOIN FETCH ie.produto p "
                + "WHERE p.id = :produtoId";

        Query query = em.createQuery(jpql);
        query.setParameter("produtoId", produtoId);

        return query.getResultList();
    }

}
