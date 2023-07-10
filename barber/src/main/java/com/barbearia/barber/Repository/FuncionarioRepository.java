package com.barbearia.barber.Repository;

import com.barbearia.barber.ORM.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

}
