package metier;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.List;

import meserreurs.MonException;


public class Pays {

    private String nomPays;
    private String nomCapitale;
    private int nbHabitant;
    
    public Pays() {}

    public Pays(String nomP, String nomC, int nbH) {
        this.nomPays = nomP;
        this.nomCapitale = nomC;
        this.nbHabitant = nbH;
    }

    public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public String getNomCapitale() {
		return nomCapitale;
	}

	public void setNomCapitale(String nomCapitale) {
		this.nomCapitale = nomCapitale;
	}

	public int getNbHabitant() {
		return nbHabitant;
	}

	public void setNbHabitant(int nbHabitant) {
		this.nbHabitant = nbHabitant;
	}

	public void insertionStage() {

        String mysql = "";

        mysql = "INSERT INTO pays (nom_pays, nom_capitale, nb_habitants ,";
        mysql += " VALUES ( \'" + this.nomPays + "\', \'" + this.nomCapitale + "\', ";
        mysql += this.nbHabitant + " )";
        
        //DialogueBd.insertionBD(mysql);
    }
/*
    public List<Pays> rechercheLesStages() {
        List<Object> rs;
        List<Pays> mesStages = new ArrayList<Pays>();
        int index = 0;
        try {
            String mysql = "";

            mysql = "SELECT * FROM pays ORDER BY nom_pays ASC";

            //rs = DialogueBd.lecture(mysql);

            while (index < rs.size()) {
                // On cr�e un stage
                Pays unS = new Pays();
                // il faut redecouper la liste pour retrouver les lignes
                unS.setId(rs.get(index + 0).toString());
                unS.setLibelle(rs.get(index + 1).toString());
                DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");
                unS.setDatedebut(dateFormatpers.parse(rs.get(index + 2).toString()));
                unS.setDatefin((dateFormatpers.parse(rs.get(index + 3).toString())));
                unS.setNbplaces(Integer.parseInt(rs.get(index + 4).toString()));
                unS.setNbinscrits(Integer.parseInt(rs.get(index + 5).toString()));
                // On incr�mente tous les 6 champs
                index = index + 6;
                mesStages.add(unS);
            }

            return mesStages;

        } catch (MonException e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public List<Stage> recherche(String name) throws MonException, ParseException {
        List<Object> rs;
        List<Stage> mesStages = new ArrayList<Stage>();
        int index = 0;
        try {
            String mysql = "";

            mysql = "SELECT * FROM stages WHERE libelle LIKE '%" + name + "%' ORDER BY id ASC";

            rs = DialogueBd.lecture(mysql);

            while (index < rs.size()) {
                // On cr�e un stage
                Stage unS = new Stage();
                // il faut redecouper la liste pour retrouver les lignes
                unS.setId(rs.get(index + 0).toString());
                unS.setLibelle(rs.get(index + 1).toString());
                DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");
                unS.setDatedebut(dateFormatpers.parse(rs.get(index + 2).toString()));
                unS.setDatefin((dateFormatpers.parse(rs.get(index + 3).toString())));
                unS.setNbplaces(Integer.parseInt(rs.get(index + 4).toString()));
                unS.setNbinscrits(Integer.parseInt(rs.get(index + 5).toString()));
                // On incr�mente tous les 6 champs
                index = index + 6;
                mesStages.add(unS);
            }

            return mesStages;

        } catch (MonException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void supprimerStage(int id) throws MonException {
        String mysql = "DELETE FROM stages WHERE id=" + id + ";";
        try {
            DialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void findStageById(int id) throws ParseException, MonException {

        String mysql = "SELECT * FROM stages WHERE id=" + id + ";";
        try {
            List<Object> rs = DialogueBd.lecture(mysql);
            if (rs.size() == 6) {
                this.setId(rs.get(0).toString());
                this.setLibelle(rs.get(1).toString());
                DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");
                this.setDatedebut(dateFormatpers.parse(rs.get(2).toString()));
                this.setDatefin((dateFormatpers.parse(rs.get(3).toString())));
                this.setNbplaces(Integer.parseInt(rs.get(4).toString()));
                this.setNbinscrits(Integer.parseInt(rs.get(5).toString()));
            } else {
                throw new MonException("Duplicate id", "Identifiant du stage non valide");
            }
        } catch (MonException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String getDateDebutToString() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy,MM,dd");
        return dateformat.format(this.datedebut);
    }

    public String getDateFinToString() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy,MM,dd");
        return dateformat.format(this.datefin);
    }

    public boolean isExistingId() throws MonException {
        String mysql = "SELECT id FROM stages WHERE id=" + this.id + ";";
        List<Object> rs = DialogueBd.lecture(mysql);
        if(rs.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void modifierStage() throws MonException {
        try {
            String mysql = "";
            DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");
            String dd = dateFormatpers.format(this.getDatedebut());
            String df = dateFormatpers.format(this.getDatefin());

            mysql = "UPDATE stages";
            mysql = mysql + " SET libelle = '" + this.getLibelle() + "',";
            mysql = mysql + " datedebut = '" + dd + "',";
            mysql = mysql + " datefin = '" + df + "',";
            mysql = mysql + " nbplaces = '" + this.getNbplaces() + "',";
            mysql = mysql + " nbinscrits = '" + this.getNbinscrits() + "'";
            mysql = mysql + " WHERE id = " + this.getId();

            DialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }
    */
}
