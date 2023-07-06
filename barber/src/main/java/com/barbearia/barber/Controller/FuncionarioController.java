package com.barbearia.barber.Controller;

import com.barbearia.barber.ORM.Funcionario;
import com.barbearia.barber.Repository.FuncionarioRepository;
import com.barbearia.barber.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/Funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService FuncionarioService;
/*
    @GetMapping
    public String FormularioAdimicao(){
        return "FormularioAdmicaoFuncionario";
    }
*/
    @RequestMapping(value = "/Formulario",method = RequestMethod.GET) //para pegar todos os registros da tabela de Funcionario
    public @ResponseBody Iterable<Funcionario> lista(){
        return funcionarioRepository.findAll();
    }

    @RequestMapping(value = "/Formulario", method = RequestMethod.POST) //Para Salvar um registro na tabela de Funcionario
    public @ResponseBody ResponseEntity<?> Registrar(@RequestBody Funcionario funcionario){
        return FuncionarioService.cadastro(funcionario);
    }

    @RequestMapping(value = "/Formulario/{id}",method = RequestMethod.GET) //para pegar um registro da tabela Funcionario
    public @ResponseBody Optional<Funcionario> pesquisar(@PathVariable Long id){
        return funcionarioRepository.findById(id);
    }
    @RequestMapping(value = "/Formulario",method = RequestMethod.PUT) //para fazer Update de um registro da tabela de Funcionario
    public @ResponseBody Funcionario Modificar(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @RequestMapping(value = "/Formularioo/{id}", method = RequestMethod.DELETE) //para deletar um registro da tabela de Funcionario
    public @ResponseBody void Deletar(@PathVariable Long id){
        this.funcionarioRepository.deleteById(id);
    }
    @RequestMapping(value ="/Formulario/teste",method = RequestMethod.GET)//para contabilizar a quantidade de registros da tabela de Funcionario
    public long contador(){
        return funcionarioRepository.count();
    }
}
