<<<<<<< HEAD:socketerabiltzaile/src/main/java/dambi/Partida.java
package dambi;
=======
package zerbitzaria;
>>>>>>> ed4792831fc3caf047a1e83e46ea16079e8f17be:socketzerbitzari/src/main/java/dambi/zerbitzaria/Partida.java

import java.io.Serializable;
import java.util.Date;


public class Partida implements Serializable {
    public String langilea;
    public float puntuazioa;
    public Date data;
    
    
    public Partida(){
    }

    public Partida(String langilea, float puntuazioa, Date data) {
        this.langilea = langilea;
        this.puntuazioa = puntuazioa;
        this.data = data;
    }

    public String getLangilea() {
        return langilea;
    }

    public void setLangilea(String langilea) {
        this.langilea = langilea;
    }

    public float getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(float puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Partida{" + "langilea=" + langilea + ", puntuazioa=" + puntuazioa + ", data=" + data + '}';
    }
}
