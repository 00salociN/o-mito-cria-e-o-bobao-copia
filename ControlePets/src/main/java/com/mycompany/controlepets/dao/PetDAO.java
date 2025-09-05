/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlepets.dao;

/**
 *
 * @author Etec
 */

import com.mycompany.controlepets.connection.ConnectionFactory;
import com.mycompany.controlepets.model.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PetDAO {
    
    // Método CREATE (Inserir)
public void create(Pet pet) {
Connection con = ConnectionFactory.getConnection();
PreparedStatement stmt = null;
try {
String sql = "INSERT INTO pets (nome_pet, raca, nome_tutor) VALUES (?, ?, ?)";
stmt = con.prepareStatement(sql);
stmt.setString(1, pet.getNomePet());
stmt.setString(2, pet.getRaca());
stmt.setString(3, pet.getNomeTutor());
stmt.executeUpdate();
JOptionPane.showMessageDialog(null, "Pet salvo com sucesso!");
} catch (SQLException e) {
JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
} finally {
try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
try { if (con != null) con.close(); } catch (SQLException e) {}
}
}
// Método READ (Listar)
public List<Pet> read() {
Connection con = ConnectionFactory.getConnection();
PreparedStatement stmt = null;
ResultSet rs = null;
List<Pet> pets = new ArrayList<>();
try {
String sql = "SELECT * FROM pets";
stmt = con.prepareStatement(sql);
rs = stmt.executeQuery();
while (rs.next()) {
Pet pet = new Pet();
pet.setId(rs.getInt("id"));
pet.setNomePet(rs.getString("nome_pet"));
pet.setRaca(rs.getString("raca"));
pet.setNomeTutor(rs.getString("nome_tutor"));
pets.add(pet);
}
} catch (SQLException e) {
JOptionPane.showMessageDialog(null, "Erro ao ler dados: " + e.getMessage());
} finally {
    try { if (rs != null) rs.close(); } catch (SQLException e) {}
try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
try { if (con != null) con.close(); } catch (SQLException e) {}
}
return pets;
}
// Método UPDATE (Atualizar)
public void update(Pet pet) {
Connection con = ConnectionFactory.getConnection();
PreparedStatement stmt = null;
try {
String sql = "UPDATE pets SET nome_pet = ?, raca = ?, nome_tutor = ? WHERE id = ?";
stmt = con.prepareStatement(sql);
stmt.setString(1, pet.getNomePet());
stmt.setString(2, pet.getRaca());
stmt.setString(3, pet.getNomeTutor());
stmt.setInt(4, pet.getId());
stmt.executeUpdate();
JOptionPane.showMessageDialog(null, "Pet atualizado com sucesso!");
} catch (SQLException e) {
JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
} finally {
try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
try { if (con != null) con.close(); } catch (SQLException e) {}
}
}
// Método DELETE (Excluir)
public void delete(int id) {
Connection con = ConnectionFactory.getConnection();
PreparedStatement stmt = null;
try {
String sql = "DELETE FROM pets WHERE id = ?";
stmt = con.prepareStatement(sql);
stmt.setInt(1, id);
stmt.executeUpdate();
JOptionPane.showMessageDialog(null, "Pet excluído com sucesso!");
} catch (SQLException e) {
JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
} finally {
try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
try { if (con != null) con.close(); } catch (SQLException e) {}
}
}
}
