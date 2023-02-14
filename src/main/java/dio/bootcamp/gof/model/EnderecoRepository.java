package dio.bootcamp.gof.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {


}
