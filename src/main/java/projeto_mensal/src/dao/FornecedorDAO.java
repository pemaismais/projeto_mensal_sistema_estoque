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
import projeto_mensal.src.model.Fornecedor;

/**
 *
 * @author henri
 */
public class FornecedorDAO {
        private EntityManager em;

    public FornecedorDAO() {
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

    public Fornecedor insert(Fornecedor fornecedor) {
        em.persist(fornecedor);
        return fornecedor;
    }

    public Fornecedor update(Fornecedor fornecedor) {
        em.merge(fornecedor);
        em.persist(fornecedor);
        return fornecedor;
    }
  public void delete(Fornecedor fornecedor) {
        em.remove(fornecedor);
    }
  
    public Fornecedor selectById(int id) throws SQLException {
        try {
            Fornecedor fornecedor = em.find(Fornecedor.class, id);
            return fornecedor;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro: " + e.getMessage(), e);
        }
    }
    public List<Fornecedor> selectByNomeAll(String nome) throws SQLException {
        try {
            String jpql = "select f from Fornecedor f where f.nome like :nome order by f.nome";
            Query query = em.createQuery(jpql);
            query.setParameter("nome", "%" + nome + "%");

            List<Fornecedor> produtoes = query.getResultList();
            return produtoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }
        public List<Fornecedor> selectByCnpjCpfAll(String cnpjcpf) throws SQLException {
        try {
            String jpql = "select f from Fornecedor f where f.cnpjcpf like :cnpjcpf order by f.cnpjcpf";
            Query query = em.createQuery(jpql);
            query.setParameter("cnpjcpf", "%" + cnpjcpf + "%");

            List<Fornecedor> produtoes = query.getResultList();
            return produtoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }
    public List<Fornecedor> selectAll() throws SQLException {
        try {
            String jpql = "SELECT e FROM Fornecedor AS e";
            Query query = em.createQuery(jpql);
            List<Fornecedor> fornecedores = query.getResultList();
            return fornecedores;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }
    
      public boolean cadastrar(Fornecedor fornecedor) throws SQLException {
        try {
            em.clear();
            beginTransaction();
            insert(fornecedor);
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
            Fornecedor fornecedor = selectById(id);
            delete(fornecedor);
            commitTransaction();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage());
        }
    }
          public boolean alterar(Fornecedor novoFornecedor) throws SQLException {
        try {
            beginTransaction();
            if (selectById(novoFornecedor.getId()) != null) {
                em.merge(novoFornecedor);
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
