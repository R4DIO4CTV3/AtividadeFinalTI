package Classes;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class LoginSystem {
  private final Map<String, String> usuarios; // mapa que armazena os usuários e senhas
  private static String usuarioLogado;
  private static String chaveMestra = "mestra1234"; // chave mestra para adicionar usuários

  public LoginSystem() {
    usuarios = new HashMap<>();
    // adicione os usuários e senhas aqui
    usuarios.put("ryan", "1234");
    usuarios.put("isabella", "1234");
    usuarios.put("larissa", "1234");
    usuarios.put("flavia", "1234");
    usuarios.put("bernardo", "1234");
    usuarios.put("nicolas", "1234");
    usuarios.put("pescuma", "1234");
    //...
  }

  public boolean login(String usuario, String senha) {
    if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
      usuarioLogado = usuario; // armazena o usuário logado na variável estática
      return true; // login bem-sucedido
    } else {
      return false; // login falhou
    }
  }

  public void adicionarUsuario(String novoUsuario, String novaSenha, String chave) {
    if (chave.equals(chaveMestra)) {
      usuarios.put(novoUsuario, novaSenha);
      JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
    } else {
      JOptionPane.showMessageDialog(null, "Chave mestra inválida!");
    }
  }
}