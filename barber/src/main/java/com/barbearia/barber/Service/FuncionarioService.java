package com.barbearia.barber.Service;

import com.barbearia.barber.ORM.Funcionario;
import com.barbearia.barber.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository FuncionarioRepository;

    public ResponseEntity<?> cadastro(Funcionario funcionario){         //Regra para Identificar se o registro vai ter nome, sobre nome
        if (funcionario.getNome().equals("")){
            String Mensage = "O nome não pode ser vazio";
            return new ResponseEntity<>(Mensage, HttpStatus.BAD_REQUEST);
        } else if (funcionario.getSobrenome().equals("")) {
            String Mensage = "O SobreNome não pode ser vazio";
            return new ResponseEntity<>(Mensage,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(FuncionarioRepository.save(funcionario),HttpStatus.CREATED);
        }
    }
}
