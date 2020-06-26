package model;

import javax.swing.table.AbstractTableModel;

public class modelTableTecnico extends AbstractTableModel{
    
    private List<modelTableTecnico> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Nome do Cliente", "Tipo de eletrônico", "Telefone"};
    
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    @Override
    public int getRowCount(){
        return dados.size();
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
    
        switch(coluna){
            case 0:
            
        }
        


        return null;
    }
    
}
