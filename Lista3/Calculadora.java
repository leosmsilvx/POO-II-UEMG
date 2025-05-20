public class Calculadora {
    
    public static double calculaExpressao(String expr) throws Exception {
        expr = expr.replaceAll("\\s+", ""); // Remove espaços em branco
        return calculaSomaSubtracao(expr);
    }
    
    private static double calculaSomaSubtracao(String expr) throws Exception {
        int index = acharOperador(expr, '+', '-');
        if (index != -1) {
            char op = expr.charAt(index);
            double esquerda = 0; // Caso a parte da esquerda seja vazia, coloca-se o valor de 0, para casos de numeros negativos
            if(!expr.substring(0, index).isEmpty()){
                esquerda = calculaSomaSubtracao(expr.substring(0, index));
            }
            double direita = calculaMultiplicacaoDivisao(expr.substring(index + 1)); 
            if (op == '+') return esquerda + direita;
            else return esquerda - direita;
        }
        return calculaMultiplicacaoDivisao(expr);
    }
    
    private static double calculaMultiplicacaoDivisao(String expr) throws Exception {
        int index = acharOperador(expr, '*', '/', '%'); 
        if (index != -1) {
            char op = expr.charAt(index);
            double esquerda = calculaMultiplicacaoDivisao(expr.substring(0, index));
            double direita = calculaPotencia(expr.substring(index + 1));
            if (op == '*') return esquerda * direita;
            else if(op == '%') return esquerda / 100 * direita; // X%Y = (X/100) * Y
            else {
                if (direita == 0) throw new ArithmeticException("Divisão por zero"); // Impossível dividir por 0
                return esquerda / direita;
            }
        }
        return calculaPotencia(expr);
    }
    
    private static double calculaPotencia(String expr) throws Exception {
        int index = acharOperador(expr, '^', '√');
        if (index != -1) {
            char op = expr.charAt(index);
            double esquerda = 1; // Caso a parte da esquerda seja vazia, coloca-se o valor de 1, para casos de somente raiz √25 = 1*√25
            if(!expr.substring(0, index).isEmpty()){
                esquerda = calculaSomaSubtracao(expr.substring(0, index));
            }
            double direita = calculaPotencia(expr.substring(index + 1));
            if(op == '^') return Math.pow(esquerda, direita);
            else return esquerda * Math.sqrt(direita);
        }
        return calculaNumero(expr);
    }
    
    private static double calculaNumero(String expr) throws Exception {
        if (expr.endsWith("!")) {
            double valor = calculaNumero(expr.substring(0, expr.length() - 1));
            return fatorial(valor);
        }
        return Double.parseDouble(expr);
    }

    private static double fatorial(double n) throws Exception {
        if (n < 0 || n != Math.floor(n)) throw new Exception("Fatorial inválido (negativo/decimal)"); // Impossivel calcular fatorial de negativo ou decimal
        double resultado = 1;
        for (int i = 2; i <= (int)n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    private static int acharOperador(String expr, char... operadores) {
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            for (char op : operadores) { 
                if(op == '-' && (i == 0 || "+-*/^%".indexOf(expr.charAt(i - 1)) != -1)) continue; // Caso o operador de menos não seja uma operação e sim um sinal do numero                
                if (c == op) return i;
            }
        }
        return -1;
    }
    
}
