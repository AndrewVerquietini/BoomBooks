/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

class Avaliacao {
    private String comentario;
    private int nota;

    public Avaliacao(String comentario, int nota) {
        this.comentario = comentario;
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Nota: " + nota + ", Comentário: " + comentario;
    }
}