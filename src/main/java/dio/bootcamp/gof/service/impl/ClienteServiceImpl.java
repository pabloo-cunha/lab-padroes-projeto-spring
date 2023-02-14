package dio.bootcamp.gof.service.impl;

import dio.bootcamp.gof.model.Cliente;
import dio.bootcamp.gof.model.ClienteRepository;
import dio.bootcamp.gof.model.Endereco;
import dio.bootcamp.gof.model.EnderecoRepository;
import dio.bootcamp.gof.service.ClienteService;
import dio.bootcamp.gof.service.ViaCepService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, no qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, lea será tratada como um <b>Singleton</b>.
 *
 * @author pablo.cunha
 */
@org.springframework.stereotype.Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            return viaCepService.consultarCep(cep);
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }

    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);

    }
}
