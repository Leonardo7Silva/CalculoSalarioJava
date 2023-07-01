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
            double descontoIRPF = descontoIRPF(salarioBruto - descontoINSS);
            double salarioLiquido = salarioBruto - descontoINSS - descontoIRPF;
            mostrarResumo(i, salarioBruto,descontoINSS, descontoIRPF, salarioLiquido);

        }

        sc.close();
    }

    public static double descontoINSS(double salarioBruto){

        if (salarioBruto >= 3641.04){

            double calculo = (salarioBruto-3641.03)*0.14;
            double acumulado = 1212*0.075 + (2427.35 - 1212)*0.09 + (3641.03 - 2427.35)*0.12;
            return calculo + acumulado;

        } else if (salarioBruto >= 2427.36){

            double calculo = (salarioBruto-2427.35)*0.12;
            double acumulado = 1212*0.075 + (2427.35 - 1212)*0.09;
            return calculo + acumulado;

        } else if (salarioBruto >= 1212.01){

            double calculo = (salarioBruto-1212)*0.09;
            double acumulado = 1212*0.075;
            return calculo + acumulado;

        } else return salarioBruto*0.075;

    }

    public static double descontoIRPF(double salario){

        if(salario > 4664.68) return salario*0.275;
        else if (salario >= 3751.06) return salario*0.225;
        else if (salario >= 2826.66) return salario*0.15;
        else if (salario >= 1903.99) return salario*0.075;
        else return 0.00;

    }

    public static void mostrarResumo(int i, double salarioBruto, double descontoINSS, double descontoIRPF, double salarioLiquido ){

        System.out.println();
        System.out.println("Salário " + (i+1));
        System.out.println("--------------------");
        System.out.printf("Salário bruto: %.2f\n", salarioBruto);
        System.out.printf("Desconto INSS: %.2f\n", descontoINSS);
        System.out.printf("Desconto Imposto de renda: %.2f\n", descontoIRPF);
        System.out.printf("Salário líquido: %.2f\n", salarioLiquido);

    }
}