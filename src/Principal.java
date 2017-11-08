/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 * Baseado nos slides 90 da aula do dia 25/08/2017 
 * Cálculo de Polinômio - Exemplo 2
 *
 * Dada uma sequência de núumeros reais an, an−1, . . . , a1, a0, e um 
 * número real x, calcular o valor do polinômio 
 *   Pn(x) = a(n)x^(n) + a(n−1)x^(n−1) + . . . + a1x + a0.
 */
public class Principal {

    /**
     * Cálcula o resultado do polinômio recursivamente.
     * Segunda solução indutiva, Hipótese de indução reforçada:
     * slides 90 
     * 
     * @param A Coeficientes A = an, an−1,..., a1, a0
     * @param x Um real x.
     * @return Um vetor com o resultado de Pn(x) e x^n
     */
    public static float[] calcularPolinomio(float[] A, float x) {
        //Tamanho do vetor, quantidade de termos do polinomio
        int n = A.length;
        float xn;
        //Variável de retorno
        float Pnx;
        // retorno = PLinha, xLinha
        float[] retorno = new float[2];

        // Quando restar apenas o último coeficiente, 
        // APENAS RETORNA (não é necessário multiplicar - grau de x = 0)
        if (n == 1) {
            retorno[0] = A[0]; //P0x
            retorno[1] = 1;    //xn
            return retorno;
        } else {

            // Elimina recursivamente o primeiro coeficiente da matriz
            // até que reste apenas um
            float[] ALinha = new float[n - 1];

            // n termos, grau do polinômio n-1
            // Meio de eliminar o elemento de grau n-1
            for (int i = 0; i < ALinha.length; i++) {
                ALinha[i] = A[i + 1];
            }

            retorno = calcularPolinomio(ALinha, x);

            float PLinha = retorno[0];
            float xLinha = retorno[1];

            xn = x * xLinha;

            // A[0] = a de grau n
            Pnx = PLinha + A[0] * xn;
        }

        retorno[0] = Pnx;
        retorno[1] = xn;

        return retorno;
    }

    public static void main(String args[]) {
        //Vetor dos dados    

        float[] A = {2, 3, 1};
        int x = 2;
        // 2 * x^ + 3 * x + 1 * x

        System.out.println(">>> Cálculo de Polinômio - Exemplo 2 <<<");

        
        float[] P = calcularPolinomio(A, x);

        System.out.println("P: " + P[0]);
        System.out.println("xn: " + P[1]);

    }
}
