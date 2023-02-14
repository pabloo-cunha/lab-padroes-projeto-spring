package dio.bootcamp.gof.service.impl;

import dio.bootcamp.gof.model.Cliente;
import dio.bootcamp.gof.service.ClienteService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, no qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, lea será tratada como um <b>Singleton</b>.
 *
 * @author pablo.cunha
 */

public class ClienteServiceImpl implements ClienteService {

    //TODO Singleton: Injetar os componentes do Spring com @Autowired.
    //TODO Strategy: Implementar os metedoso definidos na interface.
    //TODO Facade: Abstrair integração com subsistema, provendo uma interface simples.
    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME Buscar Cliente por ID.
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
