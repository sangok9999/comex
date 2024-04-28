public class main {
    public static void main(String[] args) {
        ViaCepService viaCepService = new ViaCepService();
        String cep = "04870-050"; 
        Endereco endereco = viaCepService.consultarEnderecoPorCep(cep);
        System.out.println(endereco);
    }
}