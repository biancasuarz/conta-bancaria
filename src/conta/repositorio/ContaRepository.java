package conta.repositorio;

import conta.model.Conta;

public interface ContaRepository {

    public void procurarPorNumero(int numero);
    public void listarTodas();
    public void cadastrar();
    public void atualizar();
    public void deletar();

    void cadastrar(Conta conta);

    void atualizar(Conta conta);

    void deletar(int numero);

    public void sacar(int numero, float valor);
    public void depositar(int numero, float valor);
    public void transferir(int numeroOrigem, int numeroDestino, float valor);

}
