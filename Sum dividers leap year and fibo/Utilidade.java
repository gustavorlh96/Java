class Utilidade{

  public String fibonacci(int numero){
    int numeroFibonacci = 0, somador = 1;
    String sequencia = "";

    do{
      sequencia += Integer.toString(numeroFibonacci) + ", ";
      if(somador < numero){
        sequencia += Integer.toString(somador) + ", ";
      }
      numeroFibonacci += somador;
      somador += numeroFibonacci;
    } while(numeroFibonacci <= numero);
    sequencia = sequencia.replaceAll(", $", "");
    return sequencia;
  }
  
  public String divisores(int numero){
      int resto, i = 1;
      String strresto = "";
      
      for (i = 1; i <= numero; i++){
          resto = numero % i;
          if (resto == 0){
              strresto += Integer.toString(i) + ", ";
            }
        }
      strresto = strresto.replaceAll(", $", "");
      return strresto;
  }
  
  public String bissexto(int anoInicial, int anoFinal){
      String ehBissexto = "";
      
      while (anoInicial <= anoFinal){
          if (anoInicial % 400 == 0){
              ehBissexto += Integer.toString(anoInicial) + ", ";
            }
          else if ((anoInicial % 4 == 0) && (anoInicial % 100 != 0)){
              ehBissexto += Integer.toString(anoInicial) + ", ";
            }
          anoInicial++;
        }
      ehBissexto = ehBissexto.replaceAll(", $", "");
      return ehBissexto;
    }
    
  public double soma(int num){
      double S = 0, i;
      
      for (i = 1; i <= num; i++){
          S += 1/i;
        }
      return S;
    }
}