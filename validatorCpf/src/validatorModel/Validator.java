package validatorModel;

public class Validator {

    int[] cpf = new int[11];

    public boolean validaCpf(String cpfUsuario){
        String cpf = cpfUsuario.replaceAll("[^0-9]","");

        if(cpf.equals("11111111111") || cpf.equals("22222222222") ||
        cpf.equals("33333333333") || cpf.equals("44444444444") ||
        cpf.equals("55555555555") || cpf.equals("66666666666") ||
        cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("00000000000") ||
                cpf.equals("99999999999")) {
            return false;
        }

        if(cpf.length() != 11) {
            return false;
        } else {
            realizaConversao(cpf);
        }
        return comparaDigitos(cpf,this.cpf);
    }

    public int[] realizaConversao(String cpfUsuario) {
        int tamanhoCpf = cpfUsuario.length();
        for (int i = 0; i < tamanhoCpf; i++){
            cpf[i] = Character.getNumericValue(cpfUsuario.charAt(i));
        }
        if(cpfUsuario.length() == 9) {
            calculaPrimeiroDigito(cpf);
            calculaSegundoDigito(cpf);
        } else {
            comparaDigitos(cpfUsuario,cpf);
        }
        return cpf;
    }

    public int calculaPrimeiroDigito(int[] cpf){
        int soma = 0;
        int multiplicacao = 10;
        int resultado, x;
        for(int i = 0; i < 9; i++){
            soma += cpf[i] * multiplicacao--;

        }

        resultado = soma % 11;
        if(resultado < 2){
            x = 0;
            cpf[9] = x;
        } else {
            x = 11 - resultado;
            cpf[9] = x;
        }
        return x;
    }


    public int calculaSegundoDigito(int[] cpf){
        int soma = 0;
        int multiplicacao = 11;
        int resultado,x;

        for(int i= 0; i < 10; i++){
            soma += cpf[i] * multiplicacao--;

        }
        resultado = soma % 11;
        if(resultado < 2){
            x = 0;
            cpf[10] = x;
        } else {
            x = 11 - resultado;
            cpf[10] = x;
        }

        return  x;
        }

        public boolean comparaDigitos(String cpfUs, int[] cpf){
        int decimoDigito = (Character.getNumericValue(cpfUs.charAt(9)));
        int decimoPrimeiroDigito = (Character.getNumericValue(cpfUs.charAt(10)));

        if(calculaPrimeiroDigito(cpf) == decimoDigito){
            if(calculaSegundoDigito(cpf) == decimoPrimeiroDigito){
                System.out.println("CPF VÁLIDO!");
                return true;
            } else {
                System.out.println("CPF INVÁLIDO!");
                return false;
            }
        }


            return false;
        }

    }

