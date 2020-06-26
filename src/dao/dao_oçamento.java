package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.modelOçamento;


public class dao_oçamento extends AbstractTableModel{

    private List<model.modelOçamento> dados;
    private String[] colunas = {"nome", "email", "cpf", "telefone", "servicos","produtos"};
    private final Connection connection;

     public dao_oçamento(){ 
        this.dados = new ArrayList<>();
        this.connection = new ConnectionFactory().getConnection();
    } 
     
     public void adiciona(modelOçamento ModelOçamento){ 
        String sql = "INSERT INTO orcamento (nome, email, cpf, telefone, servicos, produtos) VALUES(?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ModelOçamento.getNome());
            stmt.setString(2, ModelOçamento.getEmail());
            stmt.setString(3, ModelOçamento.getCpf());
            stmt.setString(4, ModelOçamento.getTelefone());
            stmt.setString(5, ModelOçamento.getServicos());
            stmt.setString(6, ModelOçamento.getProdutos());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getEmail();
            case 2: 
                return dados.get(linha).getCpf();
            case 3: 
                return dados.get(linha).getTelefone();
            case 4: 
                return dados.get(linha).getServicos();
            case 5: 
                return dados.get(linha).getProdutos();
        }
        
        return null;
        
    }
    
    public void addRow(model.modelOçamento c){
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

   
}