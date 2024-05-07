public class Comparendo {

    public Comparendo() {
    }
    //fotomulta(velocidad, tipo carro)
    //depeindoendo del tipo de carro y velocidad es el comparendo
    public void construirFotoMulta(int velocidad, String tipoVehiculo, int limiteInferiorVehiculos, int limiteInferiorIntermedioVehiculo, int limiteSuperiorVehiculo) {
        int tipoComparendo = calcularTipoComparendo(velocidad, tipoVehiculo, limiteInferiorIntermedioVehiculo, limiteInferiorVehiculos, limiteSuperiorVehiculo);
        String textoCorreo = enviarCorreoFotomulta(tipoVehiculo);

        if (tipoComparendo == -1) {
            System.out.println("No hay calculo para el tipo de vehiculo " + tipoVehiculo + "corre: " + textoCorreo);
        } else {
            System.out.println("El tipo de comparendo es: " + tipoComparendo + "\n" +
                "Cuerpo del correo: " + textoCorreo);
        }
    }
    public int calcularTipoComparendo(int velocidad, String tipoVehiculo,int limiteInferiorVehiculos, int limiteInferiorIntermedioVehiculo, int limiteSuperiorVehiculo){
        if(tipoVehiculo == "CARRO" || tipoVehiculo == "MULA" || tipoVehiculo == "CAMION"){

            if (velocidad <= limiteInferiorVehiculos) {
                return 0;
            } else if (velocidad >= limiteInferiorIntermedioVehiculo && velocidad <= limiteSuperiorVehiculo) {
                return 1;
            }
            return 2;
        }
        return -1;
    }
    public String enviarCorreoFotomulta(String tipoVehiculo) {

        if(tipoVehiculo != null) {
            String cuerpoMensaje = "Enviando correo para el vehiculo: " + tipoVehiculo;
            String asunto = "\n" + "Asunto: comparendo para el vehiculo: " + tipoVehiculo + "\n";
            return   asunto + cuerpoMensaje;
        } else {
            return "Enviando correo con vehiculo desconocido";
        }
    }
}