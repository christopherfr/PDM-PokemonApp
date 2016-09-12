package pe.edu.ulima.pokemonapp.model;

/**
 * Created by hernan on 9/9/16.
 */
public class Pregunta {
    private int id;
    private String pregunta;
    private String respuesta;
    private int imagen;

    public Pregunta(int id, String pregunta, String respuesta, int imagen) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
