public class Gerente extends Funcionario {

    private String setor;
    private double bonus;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Setor: " + setor);
        System.out.println("Bonus: " + bonus);
    }
}