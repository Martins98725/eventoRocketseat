package br.icaromartins.todolisticaro.user;

public record RegisterDTO(String login, String passoword, UserRoles role) {
}
