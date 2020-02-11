import java.util.Scanner;

public class FolhaPGTO {
    public static void main(String[] args) {

        System.out.println("Vamos calcular a folha de pagamento do seu funcionário. Digite seu salário:" );

        Scanner salarioMensal = new Scanner(System.in);
        double salarioM = salarioMensal.nextDouble();

        //Bloco das alíquotas de INSS
        double inssMin = 0.08;
        double inssMed = 0.09;
        double inssMax = 0.11;

        //Bloco das alíquotas de IR
        double irMin = 0.075;
        double irMed = 0.15;
        double irMax = 0.225;
        double irTop = 0.275;

        //Armazenam os valores finais
        double inssD;
        double irD;
        double salarioLiq;


        //Bloco verifica o desconto do INSS
        if(salarioM < 1751.82){
            inssD = salarioM * inssMin;
        }
        else if (salarioM < 2919.73){
            inssD = salarioM * inssMed;
        }
        else{
            inssD = salarioM * inssMax;
        }

        //Salário após o desconto do INSS
        double salarioDesc1 = salarioM - inssD;

        //Bloco verifica o desconto de imposto de renda
        if(salarioM > 1903.99 && salarioM < 2862.65){
            irD = (salarioDesc1 * irMin) - 142.80;
        }
        else if(salarioM < 3751.05){
            irD = (salarioDesc1 * irMed) - 354.80;
        }
        else if(salarioM < 4664.68){
            irD = (salarioDesc1 * irMax) - 636.13;
        }
        else{
            irD = (salarioDesc1 * irTop) - 869.36;
        }

        salarioLiq = salarioDesc1 - irD;

        System.out.println("O salário do funcionário com os descontos de INSS e IR é: " + salarioLiq);



    }

}
