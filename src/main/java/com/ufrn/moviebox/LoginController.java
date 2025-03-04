package com.ufrn.moviebox;

import DAO.usersDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class LoginController {

    @FXML
    private Button buttonEntrarConta;

    @FXML
    private Button buttonVoltarTelaInitial;

    @FXML
    private Button buttonVoltarTelaLogin;

    @FXML
    private TextField senhaEntrarConta;

    @FXML
    private TextField usuarioEntrarConta;

    private usersDAO userDao = usersDAO.getInstance();

    @FXML
    void initialize() {
        // Carrega os dados salvos no momento da inicialização da tela de login
        userDao.carregarDados();
    }

    @FXML
    void clickButtonEntrarConta(ActionEvent event) {
        String email = usuarioEntrarConta.getText();
        String senha = senhaEntrarConta.getText();

        // Verifica se os campos estão vazios
        if(email.isEmpty() || senha.isEmpty()) {
            showAlert("Erro", "Por favor, preencha todos os campos!");
            return;
        }

        // Verificação de se o login é válido
        if(userDao.validateLogin(email, senha)) {
            System.out.println("Login realizado com sucesso");
            Main.changeScreen("movie");
        } else {
            showAlert("Erro", "Email ou senha incorretos!");
        }
    }

    @FXML
    void clickButtonVoltarTelaLogin(ActionEvent event) {
        System.out.println("ir para tela register");
        Main.changeScreen("register");
    }

    @FXML
    void clickButtonVoltarTelaInitial(ActionEvent event) {
        System.out.println("Voltar Tela initial");
        Main.changeScreen("initial");
    }


    @FXML
    void textFieldSenha(ActionEvent event) {

    }

    @FXML
    void textFieldUsuario(ActionEvent event) {

    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}