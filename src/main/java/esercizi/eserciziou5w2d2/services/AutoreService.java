package esercizi.eserciziou5w2d2.services;

import esercizi.eserciziou5w2d2.exception.AutoreException;
import esercizi.eserciziou5w2d2.exception.BlogPostException;
import esercizi.eserciziou5w2d2.models.Autore;
import esercizi.eserciziou5w2d2.models.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    private List<Autore> autori = new ArrayList<>();

    public String saveAutore(Autore autore){
        autori.add(autore);
        return "Autore salvato con successo";
    }

    public List<Autore> getAllAutori(){
        return autori;
    }
    public Optional<Autore> getAutoreById(int id) {
        return autori.stream().filter(autore -> autore.getId() == id).findFirst();
    }

    public Autore updateAutore(int id, Autore autoreUpd) throws AutoreException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();
            autore.setNome(autoreUpd.getNome());
            autore.setCognome(autoreUpd.getCognome());
            autore.setEmail(autoreUpd.getEmail());
            autore.setDataDiNascita(autoreUpd.getDataDiNascita());
            return autore;

        } else {
            throw new AutoreException("Autore da modificare non presente");
        }


    }


    public String deleteAutore(int id) throws AutoreException{
        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            Autore blogPost = autoreOpt.get();
            autori.remove(blogPost);
            return "Elemento eliminato correttamente";

        } else {
            throw new AutoreException("Autore da eliminare non presente");
        }
    }
}
