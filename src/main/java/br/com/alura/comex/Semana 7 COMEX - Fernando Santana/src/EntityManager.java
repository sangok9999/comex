public interface EntityManager {
    Cliente find(Class<Cliente> clienteClass, Long id);

    void persist(Cliente cliente);

    void merge(Cliente cliente);

    void remove(Cliente cliente);

    Object createQuery(String selectCFromClienteC, Class<Cliente> clienteClass);
}
