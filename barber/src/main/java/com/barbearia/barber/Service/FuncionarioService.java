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

    public ResponseEntity<?> cadastro(Funcionario funcionario){         //Método para cadastrar um Usuário,juntamente com regra para identificar se o campo
        if (funcionario.getNome().equals("")){                          //nome ou sobrenome estão vazios
            String Mensage = "O nome não pode ser vazio";
            return new ResponseEntity<>(Mensage, HttpStatus.BAD_REQUEST);
        } else if (funcionario.getSobrenome().equals("")) {
            String Mensage = "O SobreNome não pode ser vazio";
            return new ResponseEntity<>(Mensage,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(FuncionarioRepository.save(funcionario),HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> ListaRegistros(){                          //Método para pegar todos os registros de todos os usuários
        return new ResponseEntity<>(FuncionarioRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> SelecionarPeloID(Long id){                 //metodo para buscar um registro pelo ID
        if (id == 0){
            String Mensagem = "O registro informado não existe, por favor verifique o ID";
            return new ResponseEntity(Mensagem,HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(FuncionarioRepository.findById(id),HttpStatus.OK);
        }
    }
}
