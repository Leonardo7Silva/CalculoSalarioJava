import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] salarios = {0.00, 0.00, 0.00, 0.00, 0.00} ;

        System.out.println("Digite cinco salários. Um de cada vez:");

        for(int i = 0; i < salarios.length; i++){

            salarios[i] = sc.nextDouble();
            if(i < 4){
                System.out.println("Próximo:");
            }
        }

        for(int i = 0; i < salarios.length; i++){
            double salarioBruto = salarios[i];
            double descontoINSS = descontoINSS(salarioBruto);
            double descontoIRPF = descontoIRPF(salarioBruto);
            double salarioLiquido = salarioBruto - descontoINSS - descontoIRPF;
            System.out.println();
            System.out.println("Salário " + (i+1));
            System.out.println("--------------------");
            System.out.printf("Salário bruto: %.2f\n", salarioBruto);
            System.out.printf("Desconto INSS: %.2f\n", descontoINSS);
            System.out.printf("Desconto Imposto de renda: %.2f\n", descontoIRPF);
            System.out.printf("Salário líquido: %.2f\n", salarioLiquido);

        }

        sc.close();
    }

    public static double descontoINSS(double salarioBruto){

        if(salarioBruto > 7087.22) return salarioBruto*0.14;
        else if (salarioBruto >= 3641.04) return salarioBruto*0.14;
        else if (salarioBruto >= 2427.36) return salarioBruto*0.12;
        else if (salarioBruto >= 1212.01) return salarioBruto*0.09;
        else return salarioBruto*0.075;

    }

    public static double descontoIRPF(double salarioBruto){

        if(salarioBruto > 4664.68) return salarioBruto*0.275;
        else if (salarioBruto >= 3751.06) return salarioBruto*0.225;
        else if (salarioBruto >= 2826.66) return salarioBruto*0.15;
        else if (salarioBruto >= 1903.99) return salarioBruto*0.075;
        else return 0.00;

    }
}