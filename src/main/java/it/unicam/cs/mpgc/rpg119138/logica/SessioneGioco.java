package it.unicam.cs.mpgc.rpg119138.logica;
import it.unicam.cs.mpgc.rpg119138.modello.personaggi.Eroe;
import it.unicam.cs.mpgc.rpg119138.persistenza.CaricamentoFile;

public class SessioneGioco {
    private Eroe eroeAttivo;
    private final MappaMondo mappa;
    private final CaricamentoFile persistenza;

    public SessioneGioco() {
        this.mappa = new MappaMondo();
        this.persistenza = new CaricamentoFile();
    }

    // Inizia da zero scegliendo un eroe dal catalogo
    public void iniziaNuovaPartita(Eroe scelto) {
        this.eroeAttivo = scelto;
    }

    // Riprende l'eroe con le stats salvate
    public void caricaPartitaEsistente() {
        Eroe caricato = persistenza.caricaSalvataggio();
        if (caricato != null) {
            this.eroeAttivo = caricato;
            mappa.ripristina(persistenza.caricaLivelloRaggiunto());
        }
    }

    public void vittoriaLivello(String idLivello) {
        mappa.sbloccaProssimoLivello(idLivello);
        if (eroeAttivo != null) {
            eroeAttivo.aumentaStatisticheLivello();
            eroeAttivo.incrementaLivello();
            eroeAttivo.ripristinaHp();
            persistenza.salvaPartita(eroeAttivo, Integer.parseInt(idLivello));
        }
    }

    public Eroe getEroeAttivo() { return eroeAttivo; }
    public MappaMondo getMappa() { return mappa; }
}