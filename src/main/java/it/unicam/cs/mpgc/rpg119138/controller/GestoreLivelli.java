package it.unicam.cs.mpgc.rpg119138.controller;

import it.unicam.cs.mpgc.rpg119138.modello.Livello;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Mostro;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Orco;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Serpente;
import it.unicam.cs.mpgc.rpg119138.modello.nemici.Vampiro;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Carica i livelli di gioco dal file livelli.xml.
 * Responsabilità unica: parsing XML e costruzione degli oggetti Livello.
 * Usa le API DOM standard di Java, senza librerie esterne (SOLID - DIP,
 * dipende da astrazioni Java standard e non da librerie di terze parti).
 */
public class GestoreLivelli {

    private static final String FILE_LIVELLI = "/livelli.xml";

    public List<Livello> caricaLivelli() {
        try {
            InputStream flusso = getClass().getResourceAsStream(FILE_LIVELLI);
            if (flusso == null) throw new IllegalStateException("File livelli.xml non trovato nelle risorse");

            Document documento = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(flusso);

            documento.getDocumentElement().normalize();
            NodeList nodi = documento.getElementsByTagName("livello");

            List<Livello> livelli = new ArrayList<>();
            for (int i = 0; i < nodi.getLength(); i++) {
                livelli.add(costruisciLivello((Element) nodi.item(i)));
            }
            return livelli;

        } catch (Exception e) {
            throw new RuntimeException("Errore durante il caricamento dei livelli: " + e.getMessage(), e);
        }
    }

    private Livello costruisciLivello(Element elemento) {
        int id = Integer.parseInt(elemento.getAttribute("id"));
        String nome = elemento.getAttribute("nome");
        boolean sbloccato = Boolean.parseBoolean(elemento.getAttribute("sbloccato"));
        Mostro nemico = costruisciNemico((Element) elemento.getElementsByTagName("mostro").item(0));
        return new Livello(id, nome, sbloccato, nemico);
    }

    private Mostro costruisciNemico(Element elemento) {
        String tipo = elemento.getAttribute("tipo");
        int hp = Integer.parseInt(elemento.getAttribute("hp"));
        int forza = Integer.parseInt(elemento.getAttribute("forza"));

        return switch (tipo) {
            case "Orco" -> new Orco(tipo, hp, forza);
            case "Vampiro" -> new Vampiro(tipo, hp, forza);
            case "Serpente" -> new Serpente(tipo, hp, forza);
            default -> throw new IllegalArgumentException("Tipo mostro non riconosciuto: " + tipo);
        };
    }
}
