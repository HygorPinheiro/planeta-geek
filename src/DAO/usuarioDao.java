package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.conexao;
import model.Produto;

public class usuarioDao {
    public void cadastrarProduto(Produto Produto ){
        String sql = "INSERT INTO ESTOQUE (ID,NOME,PRECO,QUANTIDADE) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;
        try {
            ps= conexao.getConexao().prepareStatement(sql);
            ps.setLong(1, Produto.getId());
            ps.setString(2, Produto.getNome());
            ps.setDouble(3, Produto.getPreco());
            ps.setLong(4, Produto.getQuantidade());
            

            ps.execute();
            ps.close();


        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    
}
