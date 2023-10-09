package com.dio.springweb.restapi.repository;

import com.dio.springweb.restapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> usuarios = new ArrayList<>();
    public void save(User usuario){
        if(usuarios.size() == 0) {
            usuarios.add(new User(1, usuario.getLogin(), usuario.getPassword()));
        }else {
            usuarios.add(new User(usuarios.get(usuarios.size()-1).getId()+1, usuario.getLogin(), usuario.getPassword()));
        }

        System.out.println(usuario);
    }
    public String deleteById(Integer id){
       System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));

        for (User user: usuarios) {
            if(user.getId().equals(id)){
                usuarios.remove(user);
                return "Registro removido com sucesso!";
            }
        }
        return "Registro não encontrado.";
    }
    public List<User> findAll(){
        System.out.println("LIST - Listando os usários do sistema");

        return usuarios;
    }
    public User findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));

        for (User user: usuarios) {
            if(user.getId().equals(id)){
                usuarios.remove(user);
                return user;
            }
        }
        return new User("","");
    }
    public User findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o usernamae: %s para localizar um usuário", username));

        for (User user: usuarios) {
            if(user.getLogin().equals(username)){
                return user;
            }
        }
        return new User("","");
    }
}
