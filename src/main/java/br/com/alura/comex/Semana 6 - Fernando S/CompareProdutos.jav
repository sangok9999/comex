public class Televisor {
    private String nome;
    private double tamanhoTela;
    private String resolucao;
    private double preco;

        public Televisor(String nome, double tamanhoTela, String resolucao, double preco) {
        this.nome = nome;
        this.tamanhoTela = tamanhoTela;
        this.resolucao = resolucao;
        this.preco = preco;
    }

    // Comparar os dois televisores//
    public boolean comparaTelevisores(Televisor outroTelevisor) {
        return this.preco == outroTelevisor.preco;
    }

    @Override
    public String toString() {
        return "Televisor{" +
                "nome='" + nome + '\'' +
                ", tamanhoTela=" + tamanhoTela + " polegadas" +
                ", resolucao='" + resolucao + '\'' +
                ", preco=$" + preco +
                '}';
    }
    
    public static void main(String[] args) {
        Televisor televisor1 = new Televisor("Samsung", 42.0, "4K HD", 2999.00);
        Televisor televisor2 = new Televisor("Panasonic", 55.0, "4K HD", 3799.00);

        System.out.println(televisor1);
        System.out.println(televisor2);

        if (televisor1.compararTelevisores(televisor2)) {
            System.out.println("Os televisores têm o mesmo valor.");
        } else {
            System.out.println("Os televisores têm valores diferentes.");
        }
    }
}